package com.zjut.juc.test;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Joya Zou
 * @date 2021年10月14日 18:49
 */
public class TestMultiThread {

    static Thread t1 = null;
    static Thread t2 = null;

    public static void printA(char[] str){
        for(char s: str){
            System.out.println(s);
            LockSupport.unpark(t2);
            LockSupport.park();
        }
    }


    public static void printa(char[] str){
        for(char s: str){
            LockSupport.park();
            System.out.println(s);
            LockSupport.unpark(t1);

        }
    }


    public static void main(String[] args) {
        char[] strA = new char[26];
        char[] stra = new char[26];

        for(int i=0; i<26; i++){
            strA[i] = (char)('A' + i);
            stra[i] = (char)('a' + i);
        }

        TestMultiThread t = new TestMultiThread();

        t1 = new Thread(()->{
            printA(strA);
        });

        t2 = new Thread(()->{
            printa(stra);
        });

        t1.start();
        t2.start();






    }


}
