package com.cute.leetcode.editor.cn;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {

    public static void main(String[] args) {
        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();


        Thread AA = new Thread(()->{
            lock1.lock();
           try {
               Thread.sleep(1000);
               System.out.println("尝试获取锁2");
               lock2.lock();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }finally {
               lock1.unlock();
           }
        });

        Thread BB = new Thread(()->{
            lock2.lock();
            try {
                Thread.sleep(1000);
                System.out.println("尝试获取锁1");
                lock1.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock2.unlock();
            }
        });
        AA.start();
        BB.start();
    }


}
