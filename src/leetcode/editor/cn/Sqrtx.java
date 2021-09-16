//给你一个非负整数 x ，计算并返回 x 的 平方根 。
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
//
//
//
// 示例 1：
//
//
//输入：x = 4
//输出：2
//
//
// 示例 2：
//
//
//输入：x = 8
//输出：2
//解释：8 的平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
//
//
//
//
// 提示：
//
//
// 0 <= x <= 2³¹ - 1
//
// Related Topics 数学 二分查找 👍 769 👎 0

package leetcode.editor.cn;
public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         *  牛顿迭代法：
         *      x = (x + target/x) /2 移项后即为 x*x = target
         */
        int s;
    public int mySqrt(int x) {
        s = x;
        if(x == 0) return 0;
        return ((int)dfs(x));
    }

    public double dfs(double x){
        double res = (x + s/x) /2;
        if(res == x){
            return x;
        }else{
            return dfs(res);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
