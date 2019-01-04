package com.suidl.test.semaphore;

import java.util.concurrent.Semaphore;

public class UsualSemaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for(int i = 0; i < 15; i ++) {
            Thread t = new Thread(new SemaphoreWorker(semaphore));
            t.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static class SemaphoreWorker implements Runnable{
        private String name;
        private Semaphore semaphore;
        public SemaphoreWorker(Semaphore semaphore) {
            this.semaphore = semaphore;
        }
        @Override
        public void run() {
            try {
                log("is waiting for a permit");
                semaphore.acquire();
                log("acquired a permit");
                Long sleep = (long)(100000 * Math.random());
                log("sleep " + sleep);
                Thread.sleep(sleep);
                log("exit");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }

        private void log(String message) {
            if(null == name) {
                name = Thread.currentThread().getName();
            }
            System.out.println(name + " " + message);
        }
    }
}
