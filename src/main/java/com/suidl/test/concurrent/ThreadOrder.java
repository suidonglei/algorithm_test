package com.suidl.test.concurrent;

public class ThreadOrder {
    public static void main(String[] args) {
        Alternate alternate = new Alternate();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 2; i++) {
                    alternate.printA();
                }
            }
        }, "A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 2; i++) {
                    alternate.printB();
                }
            }
        }, "B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 2; i++) {
                    alternate.printC();
                }
            }
        }, "C").start();
    }

    static class Alternate {
        private int num = 1;
        public synchronized void printA() {
            try {
                while (num != 1) {
                    wait();
                }
                for (int i = 1; i <= 3; i++) {
                    System.out.println(Thread.currentThread().getName() + i);
                }
                num = 2;
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public synchronized void printB() {
            try {
                while (num != 2) {
                    wait();
                }
                for (int i = 1; i <= 3; i++) {
                    System.out.println(Thread.currentThread().getName() + i);
                }
                num = 3;
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public synchronized void printC() {
            try {
                while (num != 3) {
                    wait();
                }
                for (int i = 1; i <= 3; i++) {
                    System.out.println(Thread.currentThread().getName() + i);
                }
                num = 1;
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
