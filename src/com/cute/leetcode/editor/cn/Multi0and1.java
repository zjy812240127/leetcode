package com.cute.leetcode.editor.cn;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  多线程交替打印01
 */
public class Multi0and1 {


    public static void main(String[] args) {
        Source source = new Source();
        new Thread(()->{
            source.print1();
        },"AA").start();

        new Thread(()->{
            source.print2();
        },"BB").start();

        new Thread(()->{
            source.print3();
        },"CC").start();



    }



}

class Source{
    ReentrantLock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    int flag = 0;

    public void print1(){
        lock.lock();
        try{
            for (int i=0; i<100; i++){
                while(flag != 0){
                    condition1.await();
                }
                System.out.println("A打印1。。。");
                flag = 1;
                condition2.signal();

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void print2(){
        lock.lock();
        try{
            for (int i=0; i<100; i++){
                while(flag != 1){
                    condition2.await();
                }
                System.out.println("B打印1。。。");
                condition3.signal();
                flag = 2;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print3(){
        lock.lock();
        try{
            for (int i=0; i<100; i++){
                while(flag != 2){
                    condition3.await();
                }
                System.out.println("C打印1。。。");
                flag = 0;
                condition1.signal();

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


}
