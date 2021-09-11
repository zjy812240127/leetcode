//给你一个由 '('、')' 和小写字母组成的字符串 s。
//
// 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
//
// 请返回任意一个合法字符串。
//
// 有效「括号字符串」应当符合以下 任意一条 要求：
//
//
// 空字符串或只包含小写字母的字符串
// 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
// 可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」
//
//
//
//
// 示例 1：
//
// 输入：s = "lee(t(c)o)de)"
//输出："lee(t(c)o)de"
//解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
//
//
// 示例 2：
//
// 输入：s = "a)b(c)d"
//输出："ab(c)d"
//
//
// 示例 3：
//
// 输入：s = "))(("
//输出：""
//解释：空字符串也是有效的
//
//
// 示例 4：
//
// 输入：s = "(a(b(c)d)"
//输出："a(b(c)d)"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10^5
// s[i] 可能是 '('、')' 或英文小写字母
//
// Related Topics 栈 字符串 👍 127 👎 0

package leetcode.editor.cn;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        Solution solution = new MinimumRemoveToMakeValidParentheses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minRemoveToMakeValid(String s) {
        /**
         *  用一个栈存放左括号（右括号不入栈），遇到字母直接跳过，一个数组表示s中每个下标字符的有效性
         *  如果是 ( 那么先进栈，有效性数组对应元素标记为无效  --- 单个左括号无效
         *  如果是 ），判断栈中是否为空，空的话数组中对应元素标记为无效，不为空弹出栈顶元素（左括号），将其数组对应元素标记改为有效，第一步加入栈时设置为无效
         */
        Stack<Integer> stack = new Stack<>();  // 存放下标
        boolean[] isValid = new boolean[s.length()];  // 标记括号是否有效
        for (int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);  // 左括号入栈
                isValid[i] = false;  // 单个左括号无效
            }
            if(s.charAt(i) == ')'){
                if(stack.isEmpty()){  // 栈为空或者
                    isValid[i] = false;  // 右括号在左括号前面无效
                }else{
                    int index = stack.pop();
                    isValid[index] = true;  // 形成一对有效括号
                    isValid[i] = true;
                }
            }else{  // 字母
                isValid[i] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(isValid[i]){
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
