//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
//
//
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
//
//
// 示例 2：
//
//
//输入：nums = [0]
//输出：[[],[0]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
//
//
//
// Related Topics 位运算 数组 回溯 👍 648 👎 0

package leetcode.editor.cn;

import java.util.*;

public class SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *   回溯算法，每一层节点中不能使用该层前几个节点用过的数，保证不会重复
     *    每次进入下一层时将上一层的子集加入结果集
     */
    class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        // used为false表示同一层， used为true表示下一层
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,0,res,path, used);
        return res;

    }

        /**
         *
         * @param nums
         * @param index  当前层要加入的第一个元素下标
         */
    public void dfs(int[] nums, int index, List<List<Integer>> res, Deque<Integer> path,  boolean[] used){
        res.add(new ArrayList<>(path));  // 每递归一次就是一个结果
        if(index >= nums.length) return;

        // 该层遍历每一个后续元素
        for(int i = index; i < nums.length; i++){
            // 判断加入的值和上一个值是否相等
            if(i>0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            path.addLast(nums[i]);
            // 此处需要标记在该层已使用nums[i]
            used[i] = true;  // 表示下一层
            // 调用dfs执行的是下一层节点，不需要考虑nums[i+1]在本层有没有被使用

            dfs(nums, i+1, res, path, used);
            path.removeLast();
            // 这里回溯进入for循环下一个下标，本层没有取nums[i] 所以下个循环nums[i+1]可以等于本层的nums[i]
            // 此处需要标记在该层没有用nums[i]，所以下一层nums[index+1]的值可以等于本层的nums[index]
            used[i] =false;  // 表示同一层
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
