//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10
//
// Related Topics 数组 回溯 👍 804 👎 0

package leetcode.editor.cn;

import java.util.*;

public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        int[] nums = {1,2,3};
        List<List<Integer>> res = solution.permuteUnique(nums);
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        /**
         *  排序 + isused标记分支分层
         */
        // 避免重复不能取上一个已经用过的
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        // 用来标记是前一层还是下一层
        boolean[] isUsed = new boolean[nums.length];

        Arrays.sort(nums);
        dfs(nums,res,path,isUsed);
        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, Deque<Integer> path, boolean[] isUsed){
        if(path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=0; i<nums.length; i++){
            // 无论当前分支还是并行分支都不能重复使用同一个元素
            if(isUsed[i]) continue;
            // isUsed为false表示当前操作的是平行分支，不能重复选择同样值的节点
            if(i>0 && nums[i] == nums[i-1] && !isUsed[i-1]) continue;

            path.addLast(nums[i]);
            // true表示为下一层
            isUsed[i] = true;
            dfs(nums, res, path, isUsed);

            path.removeLast();
            // 表示为同一层
            isUsed[i] = false;

        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
