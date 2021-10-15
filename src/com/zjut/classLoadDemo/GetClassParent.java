package com.zjut.classLoadDemo;

/**
 * @author Joya Zou
 * @date 2021年10月11日 10:28
 */
public class GetClassParent {
    public static void main(String[] args) {
        // 得到该类的加载器（AppClassLoader）
        System.out.println(ClassLoaderDemo.class.getClassLoader());  // sun.misc.Launcher$AppClassLoader@18b4aac2
        // 该类的类加载器所属于的类的类加载器 == 加载类加载器的加载器都是bootstrapClassLoader（c++实现，java中拿不到所以返回null）
        System.out.println(ClassLoaderDemo.class.getClassLoader().getClass().getClassLoader());  // null
        // 该类的类加载器的父类（AppClassLoader的父类为 --》 ExtClassLoader的父类为 --》BootstrapClassLoader）
        System.out.println(ClassLoaderDemo.class.getClassLoader().getParent());  // sun.misc.Launcher$ExtClassLoader@1540e19d
        // 该类的类加载器的父类（ExtClassLoader）的父类（BootstrapClassLoader == null）
        System.out.println(ClassLoaderDemo.class.getClassLoader().getParent().getParent());  // null（bootClassLoader）
    }
}
