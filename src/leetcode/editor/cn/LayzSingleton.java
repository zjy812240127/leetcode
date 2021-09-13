package leetcode.editor.cn;

/**
 *  static内部类，实例化静态内部类时初始话他的static属性，相当于懒汉模式内部放了一个饿汉模式
 */
public class LayzSingleton {

    //private LayzSingleton(){}
    //
    //
    //private static class getLazyInstance{
    //    private static LayzSingleton instance = new LayzSingleton();
    //}
    //
    //public LayzSingleton getInstance(){
    //    return getLazyInstance.instance;
    //}


    private LayzSingleton(){}

    private static class LazyInstance{
        public static LayzSingleton instance = new LayzSingleton();
    }

    public LayzSingleton getInstance(){
        return LazyInstance.instance;
    }



}
