package com.zjut.juc.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Joya Zou
 * @date 2021年10月14日 19:06
 */
public class ThreeThread {
    static int flag = 1;

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();


        Thread t1 = new Thread(()->{
            lock.lock();
            try {
                for (int i = 0; i < 100; i++) {
                    while (flag != 1) {
                        condition1.await();
                    }
                    System.out.println(Thread.currentThread().getName() + i);
                    flag = 2;
                    condition2.signal();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.lock();
            }
        },"AA");

        Thread t2 = new Thread(()->{
            lock.lock();
            try {
                for (int i = 0; i < 100; i++) {
                    while (flag != 2) {
                        condition2.await();
                    }
                    System.out.println(Thread.currentThread().getName() + i);
                    flag = 3;
                    condition3.signal();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.lock();
            }
        },"BB");

        Thread t3 = new Thread(()->{
            lock.lock();
            try {
                for (int i = 0; i < 100; i++) {
                    while (flag != 3) {
                        condition3.await();
                    }
                    System.out.println(Thread.currentThread().getName() + i);
                    flag = 1;
                    condition1.signal();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.lock();
            }
        },"CC");


        t1.start();
        t2.start();
        t3.start();
    }
}
