package com.zjut.juc;

import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Joya Zou
 * @date 2021年10月03日 11:19
 */
public class ThreadLocalDemo {
    static ThreadLocal<Person> tl = new ThreadLocal<>();
    static ThreadLocal<Person> tl2 = new ThreadLocal<>();

    public static void main(String[] args) {
        ThreadLocalDemo demo = new ThreadLocalDemo();
        new Thread(()->{
            try {
                tl.set(new Person());
                tl2.set(new Person());
                tl2.get().setName("wangwu");
                TimeUnit.SECONDS.sleep(2);
                /** 线程自己没有设置tl中的成员变量，输出为null */
                System.out.println(Thread.currentThread().getName() + tl.get().getName() + tl2.get().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                /** 防止内存泄漏，手动释放tl所在的entry */
                tl.remove();
                tl2.remove();
            }
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                tl.set(new Person());
                tl.get().setName("lisi");
                /** 获取到自己设置的成员变量的值lisi */
                System.out.println(Thread.currentThread().getName() + tl.get().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                /** 防止内存泄漏，手动释放tl所在的entry */
                tl.remove();
            }
        }).start();
    }
}

class Person{
    int age;
    String name;
    String addr;

    Person(){}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
