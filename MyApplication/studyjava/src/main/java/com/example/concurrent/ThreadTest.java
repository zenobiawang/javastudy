package com.example.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by wanghui on 2016/3/30.
 * 同步访问共享的可变数据
 * 当多个线程共享可变数据的时候，每个读或者写数据的线程都必须执行同步
 */
public class ThreadTest {
    public static boolean shouldStop;

    public static void main(String[] args) throws InterruptedException {
        stop3();
    }

    public static void stop1() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!shouldStop){
                    i ++;                       //书本上所说，的方法，shouldStop被置为true后，后台依然执行,已验证确实如此
//                    System.out.println("wh-----" + i ++);  //考虑到i ++ 不能被直观看到，所以用了System.out.println，事实上，打印停止下来了，这是为什么？
                }
            }
        });
        thread.start();

        TimeUnit.SECONDS.sleep(1);
        shouldStop = true;
    }

    public static boolean isShouldStop;
    public static synchronized void shouldStop(){
        isShouldStop = true;
    }
    public static synchronized boolean isShouldStop(){
        return isShouldStop;
    }

    public static void stop2() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!isShouldStop()){
                    i ++;
//                    System.out.println("wh-----" + i ++);
                }
            }
        });
        thread.start();

        TimeUnit.SECONDS.sleep(1);
        shouldStop();
    }

    public static volatile boolean stopnew;
    public static void stop3() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopnew){
                    i ++;
//                    System.out.println("wh-----" + i ++);
                }
            }
        });
        thread.start();

        TimeUnit.SECONDS.sleep(1);
        stopnew = true;
    }

}
