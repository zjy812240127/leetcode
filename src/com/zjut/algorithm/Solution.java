package com.zjut.algorithm;

/**
 * @author Joya Zou
 * @date 2021年10月25日 10:43
 */
public class Solution {
    public static void main(String[] args) {
        int[] num = new int[100];
        for(int i=0; i<100; i++){
            num[i] = i;
        }
        int target = 50;
        int res = search(num,0, num.length -1, target);

        System.out.println(res);
    }

    public static int search(int[] num, int left, int right, int target){
        if(num[left] == target) {
            return left;
        }
        if(num[right] == target) {
            return right;
        }
        int mid = (left + right) /2;
        if (target < num[right]){
            return search(num, left, mid, target);
        }else{
            return search(num,mid+1,right, target);
        }
    }
}
