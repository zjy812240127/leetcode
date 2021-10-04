package com.zjut.juc.threadPool;

import java.util.concurrent.*;

/**
 * @author Joya Zou
 * @date 2021年10月04日 16:18
 */
public class FutureTaskDemo {
    public static void main(String[] args) {
        FutureTask<String> ft = new FutureTask<>(()->{
            return "future task";
        });
        /** 起一个线程异步执行future任务 */
        new Thread(ft).start();

        try {
            /** 从Future中获取返回值的操作是阻塞的 */
            System.out.println(ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
