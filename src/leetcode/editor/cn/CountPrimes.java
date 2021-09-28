//统计所有小于非负整数 n 的质数的数量。
//
//
//
// 示例 1：
//
// 输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
//
//
// 示例 2：
//
// 输入：n = 0
//输出：0
//
//
// 示例 3：
//
// 输入：n = 1
//输出：0
//
//
//
//
// 提示：
//
//
// 0 <= n <= 5 * 10⁶
//
// Related Topics 数组 数学 枚举 数论 👍 754 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class CountPrimes {
    public static void main(String[] args) {
        Solution solution = new CountPrimes().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 初始化一个长度为n的boolean数组，
         * 从2开始到根号n，将每一个数的倍数落在数组范围内的都变为flase，表示该元素表示的数字i不是素数，可以被小于他的数整除
         *
         * @param
         * @return
         */
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes,true);
        int len = primes.length;

        for(int i = 2; i * i< n; i++){
            for(int j = i*i; j< len; j += i){
                primes[j] = false;
            }
        }

        int res = 0;
        for(int i=2; i<primes.length; i++){
            if(primes[i]) res++;
        }
        return res;

    }


    //public boolean isPrimes(int n){
    //    int up = (int) Math.sqrt(n);
    //    for(int i=2; i<=up; i++){
    //        if(n % i == 0) return false;  // 说明不是质数
    //    }
    //    return true;
    //}
}
//leetcode submit region end(Prohibit modification and deletion)

}
