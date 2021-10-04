package com.zjut.juc;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Joya Zou
 * @date 2021年10月04日 15:03
 */
public class LockSupportDemo2 {
    static Thread t1;
    static Thread t2;
    public static void main(String[] args) {

        t1 = new Thread(()->{
            for (int i = 0; i < 26; i++) {
                System.out.println(i);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });

        t2 = new Thread(()->{
            for (int i = 0; i < 26; i++) {
                LockSupport.park();
                System.out.println((char)('A' + i));
                LockSupport.unpark(t1);
            }
        });

        t1.start();
        t2.start();

    }
}
