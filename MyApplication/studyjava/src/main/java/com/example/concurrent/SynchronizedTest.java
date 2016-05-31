package com.example.concurrent;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by wanghui on 2016/5/27.
 */
public class SynchronizedTest {
    private static int i;
    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 10; j++){
                    System.out.println("wh--thread1---i=" + i ++);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 10; j++){
                    System.out.println("wh--thread2---i=" + i ++);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        i = 5;
    }
}
