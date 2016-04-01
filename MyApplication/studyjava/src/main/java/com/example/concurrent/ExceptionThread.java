package com.example.concurrent;

/**
 * Created by wanghui on 2016/4/1.
 */
public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("run by" + thread);
        System.out.println("the et-" + thread.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}
