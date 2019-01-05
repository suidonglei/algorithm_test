package com.suidl.test.concurrent;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueHandOff {
    /**
     * 如果我们需要实现的是两个线程之间接力性（handoff）的场景，
     * 可能会选择CountDownLatch，但是SynchronousQueue也是完美符合这种场景的，
     * 而且线程间协调和数据传输统一起来，代码更加规范。可能令人意外的是，
     * 很多时候SynchronousQueue的性能表现，往往大大超过其他实现，尤其是在队列元素较小的场景。
     */
    public static void main(String[] args) {
        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();
        Integer[] number = {1};
        Thread oddThread = new Thread(() -> {
            try {
                while(number[0] < 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + number[0]);
                    number[0] ++;
                    synchronousQueue.put(1);
                    Thread.sleep(10000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread evenThread = new Thread(() -> {
            try {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + ":" + number[0]);
                    synchronousQueue.take();
                    Thread.sleep(10000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        oddThread.start();
        evenThread.start();
    }

}
