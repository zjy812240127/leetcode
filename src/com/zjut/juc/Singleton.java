package com.zjut.juc;

public class Singleton {
    /**
     *  饿汉模式
     */
    private Singleton Instance = new Singleton();

    private Singleton(){}

    public Singleton getInstance(){
        return Instance;
    }


}
