//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 示例 1：
//
//
//
//
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//
//
// 示例 2：
//
//
//输入：height = [4,2,0,3,2,5]
//输出：9
//
//
//
//
// 提示：
//
//
// n == height.length
// 0 <= n <= 3 * 10⁴
// 0 <= height[i] <= 10⁵
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 2653 👎 0

package leetcode.editor.cn;

import java.util.Stack;

public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        // 栈为空，入栈
        // 当前元素比栈顶元素大，出战，如果此时栈中为空，当前元素入栈，如果不为空，以栈顶当前元素与当前元素作为左右边界，计算容量
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i=0; i<height.length; i++){
            // 遍历不断加入更矮的柱子
            // 当前柱子更高，就要计算一次容量
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                int midIndex = stack.pop();  // 中间元素的下标
                if(stack.isEmpty()) break;
                int midHeight = height[midIndex];  // 中间柱子高度
                int distance = i - stack.peek() -1;
                int subH = Math.min(height[i], height[stack.peek()]);
                res += (subH-midHeight) * distance;

            }
            stack.push(i);
        }
        return res;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

    //
    //// 栈，比当前栈顶元素小的就入栈，比栈顶元素大的就出战，计算该段雨水,栈中存放下标
    //Stack<Integer> stack = new Stack<>();
    //int res = 0;
    //int index = 0;
    //    while(index<height.length){
    //    // 当前值大于栈顶元素，计算雨水
    //    while(!stack.isEmpty() &&  height[index] > height[stack.peek()]){
    //    int h = height[stack.peek()];  // 栈顶的主子高度
    //    stack.pop();
    //    // 如果栈中只有一个元素，没有左边界
    //    if(stack.isEmpty()){
    //    break;
    //    }
    //    // stack中下一个元素作为左边界，计算左右两边界的距离
    //    int distance = index - stack.peek() -1;
    //    int min = Math.min(height[index], height[stack.peek()]);  // 高度的最小值
    //    // 左右墙最小高度减去中间柱子高度
    //    res += (min-h) * distance;
    //    }
    //    // 小于栈顶元素入栈
    //    stack.push(index);
    //    index++;
    //    }
    //    return res;
