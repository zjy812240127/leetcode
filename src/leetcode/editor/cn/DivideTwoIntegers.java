//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
//
// 返回被除数 dividend 除以除数 divisor 得到的商。
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
//
//
//
// 示例 1:
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
//
// 示例 2:
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2
//
//
//
// 提示：
//
//
// 被除数和除数均为 32 位有符号整数。
// 除数不为 0。
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2³¹, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
//
// Related Topics 位运算 数学 👍 647 👎 0

package leetcode.editor.cn;
public class DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new DivideTwoIntegers().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int divide(int dividend, int divisor) {
        
        long count = 0;  // ×的次数
        long sum = 0;  // divisor累加和
        boolean flag = false;  // 默认两者符号不同
        if((dividend > 0 && divisor >0) ||(dividend <0 && divisor <0)) flag = true;  // 两者符号相同

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if(dividend < divisor) return 0;
        while(true){
            sum += divisor;
            count ++;
            if(sum <= dividend && sum+divisor >dividend) break;
        }

        if(flag) return count > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)count ;
        else return 0-count < Integer.MIN_VALUE ? Integer.MIN_VALUE: 0-(int)count;



    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
