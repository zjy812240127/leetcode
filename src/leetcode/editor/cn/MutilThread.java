package leetcode.editor.cn;

import javax.swing.plaf.SpinnerUI;
import java.sql.SQLOutput;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MutilThread {

    public static void main(String[] args) {

        Source source = new Source();
        int flag = 0;

        new Thread(()->{
            source.print0();
        },"AA").start();

        new Thread(()->{
            source.print1();
        },"BB").start();

        new Thread(()->{
            source.print2();
        },"CC").start();
    }
}

class Source{

    ReentrantLock lock = new ReentrantLock();
    Condition c0 = lock.newCondition();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    int flag = 0;

    public void print0(){
        lock.lock();
        try{
            for(int i=0; i<100; i++){
                while(flag != 0){
                    c0.await();
                }

                System.out.println(i);
                flag = 1;
                c1.signal();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public void print1(){
        lock.lock();
        try{
            for(int i=0; i<100; i++){
                while(flag != 1){
                    c1.await();
                }
                System.out.println(i);
                flag = 2;
                c2.signal();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public void print2(){
        lock.lock(  );
        try{
            for(int i=0; i<100; i++){
                while(flag != 2){
                    c2.await();
                }
                System.out.println(i);
                flag = 0;
                c0.signal();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


}
