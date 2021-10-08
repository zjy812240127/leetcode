package com.cute.leetcode.editor.cn;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Joya Zou
 * @date 2021年10月02日 19:35
 */
public class SourceCode {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        CountDownLatch countDownLatch = new CountDownLatch(5);
        int i =0;
        lock.lock();
        try{
            i++;
            System.out.println("上锁");
        }finally {
            lock.unlock();
        }
    }
}
