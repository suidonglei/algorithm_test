package com.suidl.test.concurrent;

public class ThreadOrder {
    public void printNumber() {
        int[] count = {1};
        String lock = "lock";
        Thread oddThread = new Thread(() -> {
            synchronized (lock) {
                while(count[0] < 100) {
                    while(count[0] %2 != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + count[0]);
                    count[0]++;
                    lock.notifyAll();
                }
            }
        });
        Thread evenThread = new Thread(() -> {
            synchronized (lock) {
                while(count[0] < 100) {
                    while(count[0] %2 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + count[0]);
                    count[0]++;
                    lock.notifyAll();
                }
            }
        });
        oddThread.start();
        evenThread.start();
    }
    public static void main(String[] args) {
        new ThreadOrder().printNumber();
    }
}
