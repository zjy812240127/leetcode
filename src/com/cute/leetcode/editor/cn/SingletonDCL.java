package com.cute.leetcode.editor.cn;


public class SingletonDCL {
    /** DCL懒汉模式对象的属性必须使用volatile修饰，防止多线程使用半初始化的对象中的java默认属性值 */
    private static volatile SingletonDCL Instance;

    private  SingletonDCL(){}
    /**
     * Volatile避免多线程获取半初始化对象的java默认属性值
     * DCL,解决多线程造成的多例现象
     * @return
     */
    public static SingletonDCL getInstance(){
        /** 第一重检查，当已经有对象建立了之后，直接复用当前对象 */
        if(Instance == null){
            synchronized (SingletonDCL.class){
                /** 第二重检查，避免两个线程同时进入上述if语句块，当一个线程释放锁后，第二个线程获得锁，如果不加该判断会new一个新的对象 */
                if(Instance == null){
                    try{
                        Thread.sleep(1);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Instance = new SingletonDCL();
                }
            }
        }
        /** 当上一个线程创建了一个半初始化对象时，第二个线程判断已有了Instance直接到这里获取这个半初始化对象，后续该线程使用的就是这个半初始化对象的默认属性值了 */
        return Instance;
    }
}
