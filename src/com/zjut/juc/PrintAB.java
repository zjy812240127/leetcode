package com.zjut.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Joya Zou
 * @date 2021年10月02日 14:49
 */
public class PrintAB {
    /** 两个线程交叉顺序打印A-Z，a-z */
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    Condition condition2 = lock.newCondition();
    int flag = 0;

    public void printA(char[] chars){
        lock.lock();
        try{
            TimeUnit.SECONDS.sleep(1);
            int i=0;
            while(i<26){
                while(flag != 0){
                    condition.await();
                }
                System.out.println(Thread.currentThread().getName() + "打印" + chars[i]);
                flag =1;
                condition2.signal();
                i++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printa(char[] chars){
        lock.lock();
        try{
            int i=0;
            while(i<26){
                while(flag != 1){
                    condition2.await();
                }
                System.out.println(Thread.currentThread().getName() + "打印" + chars[i]);
                flag = 0;
                condition.signal();
                i++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        char[] charsA = new char[26];
        char[] charsa = new char[26];
        for(int i=0; i<26; i++){
            charsA[i] = (char) ('A' + i);
        }
        for(int i=0; i<26; i++){
            charsa[i] = (char) ('a' + i);
        }

        PrintAB p = new PrintAB();

        Thread A = new Thread(()->{
            p.printA(charsA);
        });

        Thread a = new Thread(()->{
            p.printa(charsa);
        });

        A.start();
        a.start();
    }
}
