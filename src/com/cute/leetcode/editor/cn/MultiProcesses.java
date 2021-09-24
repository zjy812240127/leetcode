package com.cute.leetcode.editor.cn;

import java.util.concurrent.CountDownLatch;

public class MultiProcesses {
    public static int a,b;
    public static int x,y;

    public static void main(String[] args) {
        int count = 0;
        for(int i=0; i<Long.MAX_VALUE;i++){
            a=0;
            b=0;
            x=0;
            y=0;
            CountDownLatch countDownLatch = new CountDownLatch(2);

            new Thread(()->{
                a = 1;
                x = b;
                countDownLatch.countDown();
            },"AA").start();

            new Thread(()->{
                b = 1;
                y = a;
                countDownLatch.countDown();
            },"BB").start();

            if(x == 0 && y ==0){
                break;
            }
            count ++;
        }

        System.out.println("在第" + count + "次达到了 x = 0; y = 0");




    }


}
