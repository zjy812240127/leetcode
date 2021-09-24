//括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
//
// 说明：解集不能包含重复的子集。
//
// 例如，给出 n = 3，生成结果为：
//
//
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
//
// Related Topics 字符串 动态规划 回溯 👍 88 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BracketLcci {
    public static void main(String[] args) {
        Solution solution = new BracketLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<String> generateParenthesis(int n) {
        /**
         *   1. 先排出所有组合，再写一个函数判断是否是有效括号
         *
         *   ps: 使用StringBuilder的话要回溯，因为每次都是再同一个对象上操作
         *          使用String拼接的话不用回溯，每次拼接都相当于生成了一个新的String对象
         */
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int leftNum = n;
        int rightNum = n;
        dfs("", leftNum, rightNum, res);
        return res;
    }

    public void dfs(String sb, int leftNum, int rightNum, List<String> res){
        /** 此处可以直接判断当前是否是合法的组合，加入的左括号必须多于右括号， 因此剩余可用的左括号必须少于右括号 */
        if(leftNum <0 || rightNum <0 || leftNum > rightNum) return;
        if(leftNum == 0 && rightNum ==0) {
            res.add(sb.toString());
            return;
        }

        /** String无需回溯，StringBuilder需要剪枝 */
      //  sb.append('(');
        dfs(sb + "(", leftNum -1, rightNum ,res);
      //  sb.deleteCharAt(sb.length() -1);
      //  sb.append(')');
        dfs(sb + ")", leftNum, rightNum -1, res);
        //sb.deleteCharAt(sb.length() -1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
