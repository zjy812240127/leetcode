//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
//
//
// 示例 1:
//
//
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
//
//
// 示例 2:
//
//
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4
//
//
//
// 提示：
//
//
// 1 <= k <= nums.length <= 10⁴
// -10⁴ <= nums[i] <= 10⁴
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1270 👎 0

package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            // 默认的小顶堆
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        /**
         *  小顶堆堆顶存放的是堆中的最小值，
         *  整个堆中存放的是所有元素中的前几个最大的，所以只有当元素大于堆顶元素的时候，才能替换堆顶元素
         *  堆顶元素被新元素替换后，对内部会再次进行排序，将当前堆中最小的元素放到堆顶
         */
        for(Integer num: nums){
            if(pq.size() <k) pq.add(num);
            else {
                if(num > pq.peek()){
                    pq.remove();
                    pq.add(num);
                }
            }
        }

        return pq.peek();


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
