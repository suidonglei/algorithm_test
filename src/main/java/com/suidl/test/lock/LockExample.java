package com.suidl.test.lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    public void reentrantLockExample(){
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();
    }
}
