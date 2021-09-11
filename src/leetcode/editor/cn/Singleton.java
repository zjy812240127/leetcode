package leetcode.editor.cn;

/**
 *  饿汉式单例模式。static属性再类初始化时就加载，所以只存在一个实例
 */
public class Singleton {

    private static Singleton instance = new Singleton();
    private Singleton (){

    }

    public static Singleton getInstance(){
        return instance;
    }
}
