package com.cute.leetcode.editor.cn;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Joya Zou
 * @date 2021年10月01日 21:05
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(30, ()->{
            System.out.println("满30线程，发车");
        });
        Thread[] threads = new Thread[30];

        for(int i = 0; i<30; i++){
            threads[i] = new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName() + "等待");
                    /** 每个线程都阻塞在此处，等阻塞了30个线程后，这些线程再一起执行后面的操作 */
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }

        for(Thread t:threads){
            t.start();
        }
    }
}
