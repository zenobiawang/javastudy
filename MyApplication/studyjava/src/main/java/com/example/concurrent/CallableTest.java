package com.example.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by wanghui on 2016/3/31.
 */
public class CallableTest {
    public static void main(String[] a){
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> test  = new ArrayList<>();
        for (int i = 0; i < 10; i ++){
            test.add(executorService.submit(new CallableResult()));
        }

        for (Future<String> future: test){
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                executorService.shutdown();
            }
        }

    }

    private static class CallableResult implements Callable<String>{

        @Override
        public String call() throws Exception {
            return "It comes end";
        }
    }
}
