//有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
//
// 示例1:
//
//  输入：S = "qqe"
// 输出：["eqq","qeq","qqe"]
//
//
// 示例2:
//
//  输入：S = "ab"
// 输出：["ab", "ba"]
//
//
// 提示:
//
//
// 字符都是英文字母。
// 字符串长度在[1, 9]之间。
//
// Related Topics 字符串 回溯 👍 47 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class PermutationIiLcci {
    public static void main(String[] args) {
        Solution solution = new PermutationIiLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] permutation(String S) {
        boolean[] isUsed = new boolean[S.length()];
        StringBuilder sb = new StringBuilder();
        List<String> resList = new ArrayList<>();
        dfs(S,sb,isUsed,resList);
        return resList.toArray(new String[resList.size()]);

    }

    public void dfs(String S, StringBuilder sb, boolean[] isUsed, List<String> resList){
        if(sb.length() == S.length()){
            resList.add(sb.toString());
            return;
        }

        for(int i=0; i<S.length(); i++){
            if(i>0 && S.charAt(i) == S.charAt(i -1) && !isUsed[i-1]) continue;

            if(!isUsed[i]){
                sb.append(S.charAt(i));
                isUsed[i] = true;
                dfs(S, sb, isUsed, resList);
                sb.deleteCharAt(sb.length() -1);
                isUsed[i] = false;
            }


        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
