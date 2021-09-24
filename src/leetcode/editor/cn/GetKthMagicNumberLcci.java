//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。
//
// 示例 1:
//
// 输入: k = 5
//
//输出: 9
//
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 69 👎 0

package leetcode.editor.cn;
public class GetKthMagicNumberLcci {
    public static void main(String[] args) {
        Solution solution = new GetKthMagicNumberLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getKthMagicNumber(int k) {
        /**
         *  丑数，每次都比较 x_a * 3, x_b * 5, x_c * 7, 取出其中最小的值，
         *  当第i个元素被取用后，乘以他的质数因该在下次乘以序列中的第i+1个元素
         */
       // if(k ==1) return 1;
        int[] dp = new int[k];
        dp[0] = 1;
        int a = 0, b=0, c=0;

        for(int i=1; i<k; i++){
            int x1 = dp[a]*3, x2 = dp[b]*5, x3 = dp[c]*7;
            dp[i] = Math.min(Math.min(x1,x2), x3);
            if(dp[i] == x1) a++;
            if(dp[i] == x2) b++;
            if(dp[i] == x3) c++;
        }

        return dp[k-1];


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
