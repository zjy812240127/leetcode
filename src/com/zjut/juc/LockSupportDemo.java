package com.zjut.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author Joya Zou
 * @date 2021年10月02日 13:42
 */
public class LockSupportDemo {

    public static void main(String[] args) {
        Thread t =new Thread(()->{
            for(int i=0; i<20; i++){
                if(i==5) {
                    /** 停车 */
                    LockSupport.park();
                }
                System.out.println(i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("经过10s后执行unpark");
        /** 开车，指定让某个线程继续执行 */
        LockSupport.unpark(t);
    }

}
