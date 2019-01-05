package com.suidl.test.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        int[] count = {1};
        Thread oddThread = new Thread(() -> {
           reentrantLock.lock();
           try {
               while (count[0] < 100) {
                   while (count[0] % 2 != 1) {
                       condition.await();
                   }
                   System.out.println(Thread.currentThread().getName() + ":" + count[0]);
                   count[0] ++;
                   condition.signal();
               }
           } catch (InterruptedException e) {
               e.printStackTrace();
           } finally {
               reentrantLock.unlock();
           }
        });
        Thread evenThread = new Thread(() -> {
            reentrantLock.lock();
            try {
                while (count[0] < 100) {
                    while (count[0] % 2 != 0) {
                        condition.await();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + count[0]);
                    count[0] ++;
                    condition.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        });
        oddThread.start();
        evenThread.start();
    }

}
