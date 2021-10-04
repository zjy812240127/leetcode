package com.zjut.juc;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Joya Zou
 * @date 2021年10月02日 15:21
 */
public class ProviderConsumer {
    /**
     *  实现一个容器，模拟多线程并发加入元素与取出元素
     */
     Lock lock = new ReentrantLock();
     /** 专门用来唤醒生产者 */
     Condition provider = lock.newCondition();
     /** 专门唤醒消费者 */
     Condition consumer = lock.newCondition();
    // 存放产品的容器
    final LinkedList<Object> list = new LinkedList<>();
    // 最多放十个对象
    final int max = 10;
    // 当前容器中的元素个数
    int count = 0;

    public void put()  {
        lock.lock();
        try{
           Object o = new Object();
            while(count == max){
                try {
                   System.out.println("容器满了");
                    /** 所有生产者停止 */
                    provider.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(o);
            ++ count;
           System.out.println("生产中" + count);
            /** 通知消费者 */
            consumer.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public synchronized Object get(){
        lock.lock();
        try{
            while(list.size() == 0){
                try {
                     System.out.println("容器空了");
                    /** 所有消费者停止 */
                    consumer.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Object o = list.removeFirst();
            count --;
            System.out.println("消费中" + count);
            /** 通知生产者 */
            provider.signalAll();
            return o;
        }finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        ProviderConsumer pc = new ProviderConsumer();
        // 消费者
        for(int i=0; i<10; i++){
            new Thread(()->{
                for(int j=0; j<10; j++) {System.out.println(pc.get());}
            },"A" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 生产者
        for(int i=0; i<10; i++){
            new Thread(()->{
                for(int j=0; j<10; j++) {pc.put();}
            }, "B" + i).start();
        }
    }
}
