package com.zjut.juc.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Joya Zou
 * @date 2021年10月14日 18:42
 */
public class TestDeadLockDemo {

    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Thread t1 = new Thread(()->{
            lock1.lock();
            try {
                lock2.lock();
                System.out.println("获得锁2");

            }finally {
                lock1.unlock();
            }
        });

        Thread t2 = new Thread(()->{
            lock2.lock();
            try {
                lock1.lock();
                System.out.println("获得锁1");

            }finally {
                lock2.unlock();
            }
        });

        t1.start();
        t2.start();

    }

}
