package com.zjut.juc.test;

/**
 * @author Joya Zou
 * @date 2021年10月14日 19:40
 */
public class LazyLoading {

    private static volatile LazyLoading instance;

    private LazyLoading(){};

    public LazyLoading getInstance(){
        if(instance == null) {
            synchronized (new Object()){
                if(instance == null){
                    instance = new LazyLoading();
                }
            }
        }
        return instance;
    }


}
