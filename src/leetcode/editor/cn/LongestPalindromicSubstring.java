//给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
//输入：s = "cbbd"
//输出："bb"
//
//
// 示例 3：
//
//
//输入：s = "a"
//输出："a"
//
//
// 示例 4：
//
//
//输入：s = "ac"
//输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母（大写和/或小写）组成
//
// Related Topics 字符串 动态规划 👍 4083 👎 0

package leetcode.editor.cn;
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int max = Integer.MIN_VALUE;
        int lIndex = 0;
        int rIndex = 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        // 双指针两层for训话遍历
        for(int i=0; i<len; i++){
            for(int j=0; j<=i; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(i-j <2 || dp[j+1][i-1]){
                        dp[j][i] = true;
                        if(i-j+1 > max){
                            max = i-j+1;
                            lIndex = j;
                            rIndex = i;
                        }
                    }else dp[j][i] = false;
                }
            }
        }

        return s.substring(lIndex,rIndex+1);

    }



    public boolean isReverse(String s, int start, int end){
        if(!(s.charAt(start) == s.charAt(end))) return false;
        if(end - start <= 2) return true;
        return isReverse(s, start +1, end -1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
