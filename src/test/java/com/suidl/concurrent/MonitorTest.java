package com.suidl.concurrent;

import org.junit.Test;

import java.util.*;

public class MonitorTest {
    class SynTest{
        final List<Object> resourceList = new ArrayList<>();
        synchronized void apply(Object from, Object to) throws InterruptedException {
            while (resourceList.contains(from) || resourceList.contains(to)) {
                System.out.println(Thread.currentThread().getName() + "; wait");
                wait();
                System.out.println(Thread.currentThread().getName() + "; wait_notified");
            }
            resourceList.add(from);
            resourceList.add(to);
        }

        synchronized void free(Object from, Object to) {
            resourceList.remove(from);
            resourceList.remove(to);
            notifyAll();
        }
    }

    @Test
    public void applyResourceTest() {
        String account1 = "001";
        String account2 = "002";
        SynTest synTest = new SynTest();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + "; apply");
                    synTest.apply(account1, account2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synTest.free(account1, "003");
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + "; apply");
                    synTest.apply(account1, account2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread3 = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + "; apply");
                    synTest.apply(account1, account2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
