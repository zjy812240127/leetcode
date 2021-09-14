//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。
//
// 示例 2：
//
//
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100
//
// Related Topics 数组 动态规划 👍 938 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        // 01背包
        /**
         *   dp[i][j]:true/false
         *   表示0-i这几个元素中可以凑出和为j的情况，可以就为true，否则为false, 所以结果返回 dp[len-1][sum(nums) /2]就可以了
         *
         *   如果j = sum(nums[]) / 2 那么就表示存在两组子集，和相等，都为所有元素的和的一半
         *   dp[i+1][j] = dp[i][j] || dp[i+1][j-nums[i+1]]
         *   如果上一行已经满足了，那么这一行加了一个可选元素但是目标值不变，所以也满足，
         *   如果上一行不满足，这一行的目标值减去新加的这个元素作为新目标值如果在前面已经成立那么也满足
         *
         */
        int sum = 0;
        for(int num:nums){
            sum += num;
        }

        // 总和为奇数，无法分成两份一样的
        if(sum %2 ==1){
            return false;
        }

        int target = sum /2;
        int len = nums.length;
        boolean[][] dp = new boolean [len][target+1];


        // 第一行只有一个元素可以取，所以目标值只能是等于nums[0]时dp才能为true，否则默认为false
        if(nums[0] <= target) dp[0][nums[0]] = true;


        // 继续填充剩余的dp
        for(int i=1; i<len; i++){
            for(int j=0; j<=target; j++){
                // 如果上一行已经成功了，那么这一行只是多了一个可选元素，必然成功
                dp[i][j] = dp[i-1][j];

                // 如果以上dp[i][j] 不为true，以下判断是否可以在本行成为true
                if(nums[i] == j) {  // 当前元素一个值就等于target，则为true，直接进行下一轮循环
                    dp[i][j] = true;
                    continue;
                }
                if(nums[i] < j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
                // 以上 j-nums[i] 为下标，所以j>nums[i]，不分析j<nums[i]
            }
        }
        return dp[len-1][target];




    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
