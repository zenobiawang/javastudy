package com.example.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wanghui on 2016/3/30.
 *
 */
public class ExecuterTest {
    public static void main(String[] args){
        test1();
    }

    public static void test1(){
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i ++){
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("wh----");
                }
            });
        }
        exec.shutdown();
    }

}
