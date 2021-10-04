package com.zjut.juc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Joya Zou
 * @date 2021年10月02日 11:16
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        /** 允许几个线程并发执行，许可证数量 */
        Semaphore s = new Semaphore(10);
        /** 按照线程加入顺序公平获取许可证AQS实现 */
        Semaphore fairS = new Semaphore(10,true);

        for(int i=0; i<50; i++){
            new Thread(()->{
                try {
                    /** 当前线程想要继续执行，必须从semaphore里获取一个许可 */
                    s.acquire();
                    Date date = new Date();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String time = format.format(date);
                    System.out.println(Thread.currentThread().getName() + "执行任务" + time);
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    /** 当前s个线程数都执行完了，刷新一次许可证数量 */
                    s.release();
                }
            },"AA").start();
        }
    }
}
