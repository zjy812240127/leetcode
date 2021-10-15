package com.zjut.juc.threadPool;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Joya Zou
 * @date 2021年10月05日 11:34
 */
public class ForkJoinPoolStreamApi {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 1000000; i++) {
            nums.add(100 + r.nextInt(10000));
        }

        long start = System.currentTimeMillis();
        nums.forEach(v->isPrime(v));
        long end = System.currentTimeMillis();
        System.out.println("ForEach所用的时间为=" + (end - start));

        long start2 = System.currentTimeMillis();
        nums.parallelStream().forEach(ForkJoinPoolStreamApi::isPrime);
        long end2 = System.currentTimeMillis();
        System.out.println("并行Stream底层是ForkJoinPool，用时=" + (end2 - start2));
    }

    /** 判断是否是素数 */
    static boolean isPrime(int num){
        for (int i = 2; i < num /2; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
