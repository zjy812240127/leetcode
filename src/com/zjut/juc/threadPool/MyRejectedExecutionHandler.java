package com.zjut.juc.threadPool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Joya Zou
 * @date 2021年10月04日 18:33
 */
public class MyRejectedExecutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        // log日志记录 该任务未被执行
        // save kafka，mysql，redis
        // 尝试获取几次当前线程池情况，当可以接收新任务时，再次尝试从线程池调用线程执行该任务
    }
    /**
     *  自定义一个拒绝策略
     */


}
