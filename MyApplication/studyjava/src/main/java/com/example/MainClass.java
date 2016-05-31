package com.example;

import java.lang.ref.WeakReference;

/**
 * Created by wanghui on 2016/3/28.
 */
public class MainClass {
    public static void main(String[] args){
        WeakReference<MainClass> mReference = new WeakReference<>(null);
    }
}
