package com.cute.leetcode.editor.cn;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Joya Zou
 * @date 2021年10月02日 10:39
 */
public class ReadWriteLockDemo {
    private Lock lock = new ReentrantLock();
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();

    public void write(Lock lock){
        lock.lock();
        try{
            System.out.println("write val");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void read(Lock lock){
        lock.lock();
        try {
            System.out.println("read val");
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockDemo rw = new ReadWriteLockDemo();
        Thread[] threads = new Thread[20];
        Thread[] writeThreads = new Thread[3];

        for(int i=0; i<20; i++){
            new Thread(()->{
                rw.read(rw.readLock);
            },"AA").start();
        }

        for(int i=0; i<3; i++){
            new Thread(()->{
                rw.write(rw.writeLock);
            },"BB").start();
        }

    }
}
