package com.cute.leetcode.editor.cn;

import java.sql.Time;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class MultiAdd {
    public static void main(String[] args) throws InterruptedException {
        int count = 100000000;
        long res = 0;
        long[] nums = new long[100000000];
        Random r =new Random();
        for(int i=0; i<nums.length; i++){
            nums[i] = r.nextLong();
        }


        long start = System.currentTimeMillis();
        for(int i=0; i< count; i++){
            res += nums[i];
        }
        long end = System.currentTimeMillis();
        System.out.println("res =" + res + "计算时间：" + (end -start));

        int threadNum = 5;
        long[] resulti = new long[threadNum];
        Thread[] pool = new Thread[threadNum];
        int countNum = count / threadNum;
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);

        long MultiStart = System.currentTimeMillis();
        for(int i=0; i<threadNum; i++){
            int m = i;
            pool[i] = new Thread(()->{
                for(int j = m*countNum; j<(m+1) * countNum; j++){
                    resulti[m] += nums[j];
                }
            });
            countDownLatch.countDown();
        }

        for(int i=0; i<threadNum; i++){
            pool[i].start();
        }
        countDownLatch.await();

        long MultiRes = 0;
        for(int i=0; i<threadNum; i++){
            MultiRes += resulti[i];
        }
        long MultiEnd = System.currentTimeMillis();
        System.out.println("MultiRes=" + MultiRes+ "耗时：" + (MultiEnd - MultiStart));


    }

}
