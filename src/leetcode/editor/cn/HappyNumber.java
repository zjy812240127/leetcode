//编写一个算法来判断一个数 n 是不是快乐数。
//
// 「快乐数」定义为：
//
//
// 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
// 如果 可以变为 1，那么这个数就是快乐数。
//
//
// 如果 n 是快乐数就返回 true ；不是，则返回 false 。
//
//
//
// 示例 1：
//
//
//输入：19
//输出：true
//解释：
//1² + 9² = 82
//8² + 2² = 68
//6² + 8² = 100
//1² + 0² + 0² = 1
//
//
// 示例 2：
//
//
//输入：n = 2
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= n <= 2³¹ - 1
//
// Related Topics 哈希表 数学 双指针 👍 686 👎 0

package leetcode.editor.cn;
public class HappyNumber {
    public static void main(String[] args) {
        Solution solution = new HappyNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isHappy(int n) {
        /**
         *  快慢指针判断，当n最终可以变为1的话，快指针一次执行两次转换，慢指针一次执行一次变换，最终快指针和慢指针会相遇，---》之后一直循环，
         *      判断是否是由1引起的循环
         *      是1的话返回true
         *      如果不是说明是另一个非1的循环，肯定存在环形
         */

        if(n == 1) return true;
        int fast = n;
        int slow = n;
        do{
            slow = reverse(slow);
            fast = reverse(fast);
            fast = reverse(fast);
        }while (slow != fast);

        if(slow == 1) return true;
        else return false;

    }

    public int reverse(int n){
        int res = 0;
        while(n != 0){
            int tmp = n % 10;
            res += tmp * tmp;
            n /= 10;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
