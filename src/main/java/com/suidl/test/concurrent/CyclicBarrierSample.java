package com.suidl.test.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierSample {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
            System.out.println(" action go again");
        });
        for(int i = 0; i < 5; i ++) {
            Thread t = new Thread(() -> {
                for(int j = 0; j < 3; j ++) {
                    System.out.println(Thread.currentThread().getName() + " executed");
                    try {
                        cyclicBarrier.await();
                        System.out.println(Thread.currentThread().getName() + " pass await");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
    }
}
