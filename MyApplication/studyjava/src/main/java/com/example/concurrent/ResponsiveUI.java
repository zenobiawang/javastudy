package com.example.concurrent;

import java.io.IOException;

/**
 * Created by wanghui on 2016/4/1.
 * 使用线程的动机之一就是建立有响应的界面
 */
public class ResponsiveUI extends Thread {
    public static volatile double d = 1;
    public ResponsiveUI() {
        setDaemon(true);      //在后台运行
        start();
    }

    @Override
    public void run() {
        while (true){
            d = d + (Math.E + Math.PI)/d;
        }
    }

    public static void main(String[] args) throws IOException {
        new ResponsiveUI();
        System.in.read();
        System.out.println(d);
    }
}
