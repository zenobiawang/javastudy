package com.example.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wanghui on 2016/3/31.
 * 优先级，书中所示代码运行结果应该是第六个线程优先级最高，所以6th应该先执行完再执行其他，但是事实运行的结果并不是，大概是代码写错了
 */
public class PrioritiesTest {
    public static void main(String[] a){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i ++){
            executorService.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        executorService.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        executorService.shutdown();
    }

    public static class SimplePriorities implements Runnable{
        private int countDown = 5;
        private volatile double mDouble;
        private int priority;

        public SimplePriorities(int priority) {
            this.priority = priority;
        }

        @Override
        public String toString() {
            return Thread.currentThread() + ": " + countDown;
        }

        @Override
        public void run() {
            Thread.currentThread().setPriority(priority);
            while (true){
                for (int i = 0; i < 100000; i ++){
                    mDouble += (Math.PI + Math.E)/(double)i;
                    if (i % 1000 == 0){
                        Thread.yield();
                    }
                }
                System.out.println(this);
                if (--countDown == 0){
                    return;
                }
            }
        }
    }
}
