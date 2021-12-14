package com.msb.algorithm.digui;

/**
 * 递归经典问题：汉诺塔额问题
 * @author Joya Zou
 * @date 2021年12月13日 10:23
 */
public class Hannoi {

    private static final String LEFT = "左柱子";
    private static final String RIGHT = "右柱子";
    private static final String MID = "中间柱子";
    /**
     * from, to, other三个柱子，每个柱子在每一步都会交换身份
     *   将 1-n块从from -- to
     */
    public void move(int n, String from, String to, String other){
        if (n == 1) {
            System.out.println("将块" + 1 + "从" + from + "移动到" + to );
        }else {
            // 将上面的n-1块移动到other
            move(n-1, from, other, to);
            // 将最底下的第n块移到to
            System.out.println("将块" + n + "从" + from + "移动到" + to);
            // 将other上的前n块移到到to上
            move(n-1, other, to, from);
        }
    }

    public static void main(String[] args) {
        Hannoi hannoi = new Hannoi();
        System.out.println("将1-3块从左移到右");
        hannoi.move(3, LEFT, RIGHT, MID);

    }
}
