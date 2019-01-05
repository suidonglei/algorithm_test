package com.suidl.test.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueTest {
    public static final String EXIT_MESSAFE = "good bye";
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        Thread producer = new Thread(() -> {
            for(int i = 0; i < 20; i ++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String message = "Message" + i;
                System.out.println("produce new item :" + message);
                try {
                    blockingQueue.put(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("exit");
            try {
                blockingQueue.put(EXIT_MESSAFE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            String message = null;
            try {
                message = blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while(!EXIT_MESSAFE.equals(message)) {
                try {
                    message = blockingQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("consumed item:" + message);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("good bye");
        });

        producer.start();
        consumer.start();
    }
}
