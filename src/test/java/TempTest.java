package com.jd.job;

import org.junit.Assert;
import org.junit.Test;

public class TempTest {
    @Test
    public void should_main() {
        VolatileTest volatileTest = new VolatileTest();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                volatileTest.read();
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                volatileTest.write();
            }
        };
        thread2.start();
        thread1.start();
        System.out.println(volatileTest.flag);
    }

    class VolatileTest {
        int a = 0;
        volatile boolean flag = true;
        public void write(){
            a = 1;
            flag = true;
        }
        public void read() {
            int i = 0;
            if(flag) {
                i = a;
            }
            System.out.println(i);
        }
    }
    @Test
    public void should_sum() {
        //given
        int a = 1, b = 2, c = 3;

        a += b = c;

        Assert.assertEquals(4, a);

    }
    @Test
    public void should_test() {
        //given
        int x = 9;
        System.out.println(x & ( x - 1));
        System.out.println(x & 1);
        //when

        //then

    }
}
