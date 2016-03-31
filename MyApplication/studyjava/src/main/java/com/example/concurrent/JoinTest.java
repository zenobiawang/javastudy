package com.example.concurrent;

/**
 * Created by wanghui on 2016/3/31.
 */
public class JoinTest {
    public static void main(String[] a){
        Sleeper sleeper = new Sleeper("1", 1000);
        Sleeper sleeper1 = new Sleeper("2", 1000);
        Joiner joiner = new Joiner("3", sleeper);
        Joiner joiner1 = new Joiner("4", sleeper1);
        sleeper1.interrupt();
    }

    public static class Sleeper extends Thread{
        private int duration;
        public Sleeper(String name, int duration){
            super(name);
            this.duration = duration;
            start();
        }

        @Override
        public void run() {
            try {
                sleep(duration);
            } catch (InterruptedException e) {
                System.out.println(getName() + " was interrupted. isInterrupted = " + interrupted());
                return;
            }
            System.out.println(getName() + " has awakened");
        }
    }

    public static class Joiner extends Thread{
        private Sleeper mSleeper;

        public Joiner(String name, Sleeper sleeper) {
            super(name);
            mSleeper = sleeper;
            start();
        }

        @Override
        public void run() {
            try {
                mSleeper.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(" interrupted");
            }
            System.out.println(getName() + " has completed");
        }
    }
}
