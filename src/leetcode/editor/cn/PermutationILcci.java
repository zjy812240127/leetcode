//无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
//
// 示例1:
//
//
// 输入：S = "qwe"
// 输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
//
//
// 示例2:
//
//
// 输入：S = "ab"
// 输出：["ab", "ba"]
//
//
// 提示:
//
//
// 字符都是英文字母。
// 字符串长度在[1, 9]之间。
//
// Related Topics 字符串 回溯 👍 52 👎 0

package leetcode.editor.cn;

import com.sun.deploy.util.StringUtils;

import java.util.*;

public class PermutationILcci {
    public static void main(String[] args) {
        Solution solution = new PermutationILcci().new Solution();
        String S = "qwe";
        final String[] permutation = solution.permutation(S);
        System.out.println(permutation);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public String[] permutation(String S) {
        char[] chars = S.toCharArray();
        int num = 0;  // 当前字符串字符个数
        int len = chars.length;
        /** 需要用sb替代Deque 的 path，不然退出时只能清空deque中的元素才能拼接String，deque中没元素了影响后面回溯 */
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        dfs(chars,len,sb,res);

        return res.toArray(new String[len]);
    }

    public void dfs(char[] chars,  int len, StringBuilder sb, List<String> res){
        if(sb.length() == len){
            res.add(new String(sb));
            return ;
        }

        for(int i=0; i<len; i++){
            String str = new String(sb);
            if(str.contains (chars[i] + "")){
                continue;
            }
            sb.append(chars[i] + "");
            dfs(chars,len, sb, res);
            sb.deleteCharAt(sb.length() -1);
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
