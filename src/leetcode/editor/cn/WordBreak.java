//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//
// 说明：
//
//
// 拆分时可以重复使用字典中的单词。
// 你可以假设字典中没有重复的单词。
//
//
// 示例 1：
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
//
//
// 示例 2：
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
//
//
// 示例 3：
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
//
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 👍 1160 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        Solution solution = new WordBreak().new Solution();
        //String s = "leetcode";
        //List<String> wordDict = new ArrayList<>();
        //wordDict.add("leet");
        //wordDict.add("code");
        //boolean flag = solution.wordBreak(s,wordDict);
        //System.out.println(flag);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        /**  便于快速查询是否含有某子串 */
        Set<String> mySet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];  // 多一个元素是为了第一个无效的辅助元素置为true
        dp[0] = true;  // 辅助元素
        for(int i=1; i<=s.length(); i++){
            /** 每一个子串都重新判断其是否可以被分割 */
            for(int j=0; j<i; j++){
                if(dp[j] && mySet.contains(s.substring(j,i))){
                    // 检查该子串是否可以被分割
                    dp[i] = true;
                    break;  // 直接判断s的下一位
                }
            }
        }

        return dp[s.length()];

    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
