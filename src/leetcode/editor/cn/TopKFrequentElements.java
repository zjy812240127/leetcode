//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
//
//
//
// 示例 1:
//
//
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
//
//
// 示例 2:
//
//
//输入: nums = [1], k = 1
//输出: [1]
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// k 的取值范围是 [1, 数组中不相同的元素的个数]
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
//
//
//
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 858 👎 0

package leetcode.editor.cn;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /**
         *  map + 堆排序
         *   堆排序：
         *   1. 首先建立堆排序的比较器规则 a-b 为从小到大， b-a为从大到小
         *   2. 进行排序
         *      2.1 遍历每一个元素，前k个直接放入堆中作为初始堆
         *      2.2 后面每次加入一个元素与堆顶比较，大于堆顶元素就替换堆顶元素
         *
         */
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }else{
                map.put(nums[i], 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for(Integer key:map.keySet()){
            if(pq.size() < k) pq.add(key);
            else{
                if(map.get(key) > map.get(pq.peek())){
                    pq.remove();
                    pq.add(key);
                }
            }
        }

        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = pq.remove();
        }
        return res;





    }

}
//leetcode submit region end(Prohibit modification and deletion)

}


//    Map<Integer, Integer> map = new HashMap<>();
//        for(int i=0; i<nums.length; i++){
//        if(map.containsKey(nums[i])){
//        map.put(nums[i], map.get(nums[i]) +1);
//        }else {
//        map.put(nums[i], 1);
//        }
//        }
//        // 定义从小到大排的堆
//        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
//@Override
//public int compare(Integer o1, Integer o2) {
//        return map.get(o1) - map.get(o2);
//        }
//        });
//
//        // 遍历map的keys，进行排序挑选出频率最高的keys
//        for(Integer key: map.keySet()){
//        if(pq.size()< k){
//        pq.add(key);
//        }else if(map.get(key) >map.get(pq.peek())){
//        pq.remove();
//        pq.add(key);
//        }
//        }
//
//        int[] resInt = new int[k];
//        // 取出堆中的元素
//        for(int i=0; i<k; i++){
//        resInt[i] = pq.remove();
//        }
//        return resInt;
