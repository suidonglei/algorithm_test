package com.suidl.concurrent;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.junit.Test;

import java.util.concurrent.*;

public class ThreadTest {
    @Test
    public void test() {
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(20);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor
                (2, 10, 100, TimeUnit.SECONDS
                        ,workQueue,
                        new BasicThreadFactory.Builder()
                        .namingPattern("FanSkuByJdPriceThreadPool-%d")
                        .build());

        for(int i = 0; i < 1000; i++) {
            System.out.println("i:" + i);
            System.out.println(threadPoolExecutor.getPoolSize());
            threadPoolExecutor.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
