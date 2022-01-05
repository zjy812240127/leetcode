package com.zjut.ths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Joya Zou
 * @date 2022年01月05日 9:11
 */
public class Test01 {

    public static void main(String[] args) {
        int[][] arr = {{2,3},{4,5},{6,7},{8,9},{9,10}};
        Test01 test01 = new Test01();
        int[][] merge = test01.merge(arr);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(merge[i][0]);
        }
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(o1, o2) ->o1[0] - o2[0]);

        List<int[]> exist = new ArrayList<>();
        int[][] res = new int[intervals.length][2];
        // 当前exist中的最新元素下标，有最大右区间
        int index = 0;

        for(int i=0; i<intervals.length; i++){
            if (i == 0 || intervals[i][0] > res[index-1][1]) {
                res[index ++ ] = intervals[i];
            }
            else {
                res[index -1][1] = Math.max(intervals[i][1], res[index-1][1]);
            }
        }

        return Arrays.copyOf(res,index);
    }


}
