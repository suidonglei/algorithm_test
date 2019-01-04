package com.suidl.test.concurrent;

import java.util.concurrent.CountDownLatch;

public class LatchSample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for(int i = 0; i < 5; i ++) {
            Thread t = new Thread(()->{
                System.out.println("first count");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
            t.start();
        }
        for(int i = 0; i < 5; i ++) {
            Thread t = new Thread(()->{
                try {
                    countDownLatch.await();
                    System.out.println("second count");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }

        while (countDownLatch.getCount() != 1){
            Thread.sleep(10000);
        }

        System.out.println("wait for first batch finish");
        countDownLatch.countDown();
    }
}
