package com.zjut.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Joya Zou
 * @date 2021年10月01日 20:51
 */
public class CountDownLatchDemo {
    ReentrantLock lock = new ReentrantLock();
    CountDownLatch countDownLatch = new CountDownLatch(10);
    int count = 0;

    public void add(){
        lock.lock();
        try{
            count ++;
            countDownLatch.countDown();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo();
        for(int i=0; i<10; i++){
            threads[i] = new Thread(countDownLatchDemo::add, i +"");
        }

        for(Thread t:threads){
            t.start();
        }

        try {
            /** 主线程阻塞等待countDown计数完毕 */
            countDownLatchDemo.countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(countDownLatchDemo.count);
    }
}
