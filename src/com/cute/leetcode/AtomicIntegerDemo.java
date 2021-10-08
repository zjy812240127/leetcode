package com.cute.leetcode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Joya Zou
 * @date 2021年10月01日 15:21
 */
public class AtomicIntegerDemo {
    AtomicInteger count = new AtomicInteger(1);

    public void add(){
        count.getAndIncrement();  // count ++
    }

    public AtomicInteger getCount(){
        return count;
    }

    public static void main(String[] args) {
        Thread[] pool = new Thread[100];
        AtomicIntegerDemo at = new AtomicIntegerDemo();

        for(int i=0; i<100; i++){
            pool[i] = new Thread(at::add, i + "");
        }

        for(Thread t:pool){
            t.start();
        }

        /** 此处不加join的话会导致主线程先输出count，其他线程并没有执行完count++ */
        for(Thread t:pool){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(at.count);

    }

}
