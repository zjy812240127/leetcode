package com.zjut.juc.threadPool;

import java.io.IOException;
import java.util.concurrent.*;

/**
 * @author Joya Zou
 * @date 2021年10月04日 17:10
 */
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(3,8,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 8; i++) {
            tpe.execute(()->{
                try {
                    /** 阻塞，模拟线程满了后的拒绝策略 */
                    System.out.println(Thread.currentThread().getName());
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        /** 获取任务队列信息 */
        System.out.println(tpe.getQueue());

        for (int i = 0; i < 8; i++) {
            tpe.execute(()->{
                System.out.println(Thread.currentThread().getName());
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        /** 获取任务队列信息 */
        System.out.println(tpe.getQueue());
    }
}
