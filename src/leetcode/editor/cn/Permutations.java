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
// Related Topics 数组 回溯 👍 1569 👎 0

package leetcode.editor.cn;

import javax.swing.plaf.ListUI;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] isUsed = new boolean[nums.length];
        dfs(nums, res, path, isUsed);
        return res;

    }

    public void dfs(int[] nums, List<List<Integer>> res, LinkedList<Integer> path, boolean[] isUsed ){
        if(path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0; i<nums.length; i++){
            /** 使用isUsed必须使用continue，不能在if块里操作 */
            if(isUsed[i]) continue;
            path.add(nums[i]);
            isUsed[i] = true;
            dfs(nums, res, path, isUsed);
            path.removeLast();
            isUsed[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
