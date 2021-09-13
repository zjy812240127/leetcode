//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
//
//
//
// 示例 1：
//
//
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
//
// 示例 2：
//
//
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹
//
// Related Topics 并查集 数组 哈希表 👍 906 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        /**
         *      1. 放入hashset
         *      2. 遍历每一个key，计算从该key开始的最长连续子串
         */
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int key: nums) {
            set.add(key);
        }
        int max = Integer.MIN_VALUE;
        for(int key: set){
            if(!set.contains(key -1)){
                int len = 1;
                while(set.contains(key +1)){
                    len ++;
                    key++;
                }
                max = Math.max(max, len);
            }
        }

        return max;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
