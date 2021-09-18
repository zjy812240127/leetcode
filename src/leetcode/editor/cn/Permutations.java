//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
// 示例 2：
//
//
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// nums 中的所有整数 互不相同
//
// Related Topics 数组 回溯 👍 1554 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        List<Integer> path = new ArrayList<>();
        boolean[] isUsed = new boolean[len];  // 标记每个元素是否已经被用过了

    }

    public void dfs(List<Integer> path,List<List<Integer>> res, int len){
        if(path.size() == len) {
            res.add(path);
        }

        for()

            AtomicInteger

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
