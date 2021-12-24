package com.zjut.ths;

import java.util.Arrays;

/**
 * @author Joya Zou
 * @date 2021年12月23日 9:02
 */
public class Solution {
    public static void main(String[] args) {
        //[312884470]
        // 968709470
        int[] piles = {312884470};
        int h = 968709470;

        Solution solution = new Solution();
        int i = solution.minEatingSpeed(piles, h);
        System.out.println(i);
    }

    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int len = piles.length;
        int res = 0;
        long total = 0L;  // 总香蕉数
        for(int i=0; i<len; i++){
            total += piles[i];
        }

        int smallest = (int) (total / h);  // 必须大于该速度
        if (smallest == 0){
            smallest = 1;
        }
        for(int k = smallest; k <= piles[len -1]; k++){
            if(eat(k, piles, h)){
                res = k;
                break;
            }
        }
        return res;
    }

    public boolean eat(int speed, int[] piles, int h){
        int n = piles.length -1;
        int sum = 0;
        boolean flag = true;

        for(int i=0; i<=n; i++){
            // 该堆有剩余，计算需要吃几次，直接用除法加速
            if(piles[i] <= speed) {
                sum += 1;
            }else {
                int add = (piles[i] % speed) > 0 ? piles[i] / speed + 1 : piles[i] / speed;
                sum += add;
            }
        }
        if(sum > h){
            flag = false;

        }

        return flag;
    }
}
