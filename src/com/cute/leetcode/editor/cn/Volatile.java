package com.cute.leetcode.editor.cn;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @author Joya Zou
 * @date 2021年10月01日 14:21
 */
public class Volatile {


    private /** volatile */ boolean flag = true;

    public void m(){
        System.out.println("im running");
        while(flag){

        }
        System.out.println("end");
    }

    public static void main(String[] args) throws InterruptedException {
        Volatile v = new Volatile();
        new Thread(v::m, "v1").start();
        TimeUnit.SECONDS.sleep(1);
        v.flag = false;
    }
}
