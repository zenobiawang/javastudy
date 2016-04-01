package com.example.concurrent;

import java.util.concurrent.ThreadFactory;

/**
 * Created by wanghui on 2016/4/1.
 */
public class HandleThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        System.out.println("Creating new thread");
        Thread thread = new Thread(r);
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("et---" + thread.getUncaughtExceptionHandler());
        return thread;
    }
}
