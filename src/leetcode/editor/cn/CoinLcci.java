//硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
//
// 示例1:
//
//
// 输入: n = 5
// 输出：2
// 解释: 有两种方式可以凑成总金额:
//5=5
//5=1+1+1+1+1
//
//
// 示例2:
//
//
// 输入: n = 10
// 输出：4
// 解释: 有四种方式可以凑成总金额:
//10=10
//10=5+5
//10=5+1+1+1+1+1
//10=1+1+1+1+1+1+1+1+1+1
//
//
// 说明：
//
// 注意:
//
// 你可以假设：
//
//
// 0 <= n (总金额) <= 1000000
//
// Related Topics 数组 数学 动态规划 👍 221 👎 0

package leetcode.editor.cn;
public class CoinLcci {
    public static void main(String[] args) {
        Solution solution = new CoinLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int waysToChange(int n) {
        /**
         *  先对硬币从小到大排序
         *  先遍历硬币再内部遍历1-n
         */
        // dp[n] = dp[n -1] + dp[n-5] + dp[n-10] + dp[n-25]
        int[] dp = new int[n+1];
        dp[0] = 1;


        int[] coins = new int[4];
        coins[0] = 1;
        coins[1] = 5;
        coins[2] = 10;
        coins[3] = 25;



        for(int i=0; i<4; i++){
            for(int j=0; j<=n; j++){
                if(j-coins[i] >=0){
                    dp[j] += dp[j-coins[i]];
                    dp[j] = dp[j] % 1000000007;
                }

            }
        }

        return  dp[n];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
