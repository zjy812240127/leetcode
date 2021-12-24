package com.msb.algorithm.stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 单调栈：查找[1,2,3,5,2,3,4,1,2]每个元素左侧res[i][0]和右侧res[i][1]第一个比他小的元素
 *
 * @author Joya Zou
 * @date 2021年12月24日 9:44
 */
public class MonoStack {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 2, 3, 4, 1, 2};
        int[][] monotonous = getMonotonous(arr);
        for (int i = 0; i < monotonous.length; i++) {
            System.out.println(i + "左侧：" + monotonous[i][0]);
            System.out.println(i + "右侧：" + monotonous[i][1]);
        }
    }

    /**
     * stack中元素都是从小到大，否则弹出元素右侧min为当前元素，左侧min为弹出后的stack栈顶元素
     *
     * @param arr
     */
    public static int[][] getMonotonous(int[] arr) {
        // [i][0] 左侧 [i][1] 右侧
        int[][] res = new int[arr.length][2];
        Stack<LinkedList<Integer>> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (!stack.isEmpty()) {
                while (arr[stack.peek().get(0)] > arr[i]) {
                    LinkedList<Integer> popList = stack.pop();
                    for (int j = 0; j < popList.size(); j++) {
                        res[popList.get(j)][0] = stack.isEmpty() ? -1 : stack.peek().getLast();
                        res[popList.get(j)][1] = i;
                    }
                }
            }

            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(i);
            } else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                stack.push(list);
            }
        }

        while (!stack.isEmpty()) {
            List<Integer> pop = stack.pop();
            for (int i = 0; i < pop.size(); i++) {
                res[pop.get(i)][0] = stack.isEmpty() ? -1 : stack.peek().getLast();
                res[pop.get(i)][1] = -1;
            }
        }

        return res;
    }
}
