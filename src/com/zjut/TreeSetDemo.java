package com.zjut;

import java.util.TreeSet;

/**
 * @author Joya Zou
 * @date 2021年12月18日 8:56
 */
public class TreeSetDemo {

    public static void main(String[] args){
        // Long ceiling = treeSet.ceiling();

    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            long tmp = nums[i] * 1L;
            // treeSet.add(tmp);
            // 找到比tmp大的最小的值
            Long ceiling = treeSet.ceiling(tmp);
            // 比tmp小的最大值的值
            Long floor = treeSet.floor(tmp);
            if (ceiling != null && ceiling - tmp <= t) {
                return true;
            }

            if (floor != null && tmp - floor <= t) {
                return true;
            }

            treeSet.add(tmp);
            // 当元素数量大于k时替换最先加入的元素，加入新的i节点，保证满足任意两个节点下标差<=k
            if (i >= k){
                treeSet.remove(nums[i-k]*1L);
            }
        }

        return false;

    }
}
