package com.cute.leetcode.editor.cn;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupt {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
           for(;;){
               if(Thread.currentThread().isInterrupted()){
                   System.out.println("线程被中断......");
                   break;
               }
               System.out.println("线程未被中断");
           }
        });

        t1.start();
        try {
            TimeUnit.MILLISECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        System.out.println("end");
    }
}
