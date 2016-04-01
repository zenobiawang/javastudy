package com.example.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by wanghui on 2016/4/1.
 * 线程中的异常一旦逃出任务的run方法，它就会向外传播到控制台，除非才具特殊的步骤捕获这种错误的异常
 */
public class CaptureUncationException {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool(new HandleThreadFactory());
        executorService.execute(new ExceptionThread());
    }

}
