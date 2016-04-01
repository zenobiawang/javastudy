package com.example.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wanghui on 2016/4/1.
 * ReentrantLock允许你尝试获得但最终未获取锁，这样如果其他人已经获取这个锁，不用等待直至锁释放
 */
public class MuteEvenGenerator extends IntGenerator {
    private Lock mLock = new ReentrantLock();
    private int currentInt = 0;

    @Override
    public int next() {
        try {
            mLock.lock();
            ++ currentInt;
            Thread.yield();
            ++ currentInt;
            return currentInt;
        }finally {
            mLock.unlock();
        }

    }

    public static void main(String[] args){
        EventChecker.test(new MuteEvenGenerator());
    }
}
