package com.example.concurrent;

/**
 * Created by wanghui on 2016/4/1.
 */
public class EventGenerator extends IntGenerator {
    private int currentInt = 0;
    @Override
    public synchronized int next() {
        ++ currentInt;
        ++ currentInt;
        return currentInt;
    }

    public static void main(String[] args){
        EventChecker.test(new EventGenerator());
    }
}
