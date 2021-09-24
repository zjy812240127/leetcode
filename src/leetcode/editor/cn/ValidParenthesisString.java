//给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
//
//
// 任何左括号 ( 必须有相应的右括号 )。
// 任何右括号 ) 必须有相应的左括号 ( 。
// 左括号 ( 必须在对应的右括号之前 )。
// * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
// 一个空字符串也被视为有效字符串。
//
//
// 示例 1:
//
//
//输入: "()"
//输出: True
//
//
// 示例 2:
//
//
//输入: "(*)"
//输出: True
//
//
// 示例 3:
//
//
//输入: "(*))"
//输出: True
//
//
// 注意:
//
//
// 字符串大小将在 [1，100] 范围内。
//
// Related Topics 栈 贪心 字符串 动态规划 👍 394 👎 0

package leetcode.editor.cn;

import java.util.Stack;

public class ValidParenthesisString {
    public static void main(String[] args) {
        Solution solution = new ValidParenthesisString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkValidString(String s) {
        /**
         *  1. 双栈
         *  2. 栈中存放的是元素的下标（便于比较*与左括号的次序）
         *  3. 遍历完s后再遍历完左括号栈与右括号栈
         */
        // 两个栈，一个存放左括号出现的下标，一个存放*出现的下标
        // 优先消耗左括号，left栈为空再消耗star
        // 遍历完s后再比较left和star栈顶元素的index，star栈顶index更大则说明可以抵消left中的左括号（逐个出栈）
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        /**
         *  ps: 这里放入栈中的是元素的下标
         */
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') left.push(i);
            else if(s.charAt(i) == '*') star.push(i);
            else {
                if(!left.isEmpty()) left.pop();
                else if(!star.isEmpty()) star.pop();
                else return false;
            }
        }
        /**
         *  比较剩余的left 和star,逐个出栈，必须每一个*都在左括号右边
         */
        while(!left.isEmpty()){
            if(star.isEmpty()) return false;
            else {
                int leftTop = left.pop();
                int starTop = star.pop();
                if(starTop < leftTop) return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
