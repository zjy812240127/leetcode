package com.zjut.juc;

/**
 * @author Joya Zou
 * @date 2021年10月04日 15:26
 */
public class CASDemo {
    enum number {T1, T2};
    static volatile number flag = number.T1;

    public static void main(String[] args) {
        new Thread(()->{
            /** 自旋 */
            for (int i = 0; i < 26; i++) {
                while(flag != number.T1){};
                System.out.println(i);
                flag = number.T2;
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 26; i++) {
                /** 自旋 */
                while(flag != number.T2){};
                System.out.println((char)('A' + i));
                flag = number.T1;
            }
        }).start();
    }
}
