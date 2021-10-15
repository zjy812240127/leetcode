package com.zjut.juc.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Joya Zou
 * @date 2021年10月14日 19:24
 */
public class ReadWriteLockDemo {
    static ReadWriteLock rw = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        Thread[] readThread = new Thread[10];
        Thread[] writeThread = new Thread[3];

        final Lock readLock = rw.readLock();
        final Lock writeLock = rw.writeLock();

        for(int i=0; i< 10; i++){
            readThread[i] = new Thread(()->{
                readLock.lock();
                try{
                    System.out.println(Thread.currentThread().getName() + "读线程消费");
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    readLock.unlock();
                }
            });
        }

        for (int i = 0; i < 3; i++) {
            writeThread[i] = new Thread(()->{
                writeLock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + "写线程生产");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    writeLock.unlock();
                }
            });
        }

        for (int i = 0; i < 10; i++) {
            readThread[i].start();
        }

        for (int i = 0; i < 3; i++) {
            writeThread[i].start();
        }


    }
}
