package com.example.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wanghui on 2016/4/1.
 */
public class EventChecker implements Runnable {
    private IntGenerator mIntGenerator;
    private final int id;

    public EventChecker(int id, IntGenerator intGenerator) {
        this.id = id;
        mIntGenerator = intGenerator;
    }

    @Override
    public void run() {
        while (!mIntGenerator.isCanceled()){
            int val = mIntGenerator.next();
            if (val % 2 != 0){
                System.out.println(val + "not even!");
                mIntGenerator.cancel();
            }
        }
    }

    public static void test(IntGenerator gp, int count){
        System.out.println("Press Control-C to exit");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i ++){
            executorService.execute(new EventChecker(i, gp));
        }
        executorService.shutdown();
    }

    public static void test(IntGenerator gp){
        test(gp, 10);
    }
}
