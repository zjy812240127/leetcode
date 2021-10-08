//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。
//
//
//
// 示例 1：
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
//
//
// 示例 2：
//
// 输入：lists = []
//输出：[]
//
//
// 示例 3：
//
// 输入：lists = [[]]
//输出：[]
//
//
//
//
// 提示：
//
//
// k == lists.length
// 0 <= k <= 10^4
// 0 <= lists[i].length <= 500
// -10^4 <= lists[i][j] <= 10^4
// lists[i] 按 升序 排列
// lists[i].length 的总和不超过 10^4
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 1532 👎 0

package leetcode.editor.cn;

import javax.swing.*;

public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0) return null;
        return merge(lists,0, lists.length-1);
    }

    // TODO:分治 + 合并
    public ListNode merge(ListNode[] lists, int left, int right){
        if(left >= right) return lists[left];
        int mid = (left + right) /2;
        ListNode leftList = merge(lists, left, mid);
        ListNode rightList = merge(lists, mid +1, right);
        return mergeTwoList(leftList,rightList);

    }

    public ListNode mergeTwoList(ListNode ls1, ListNode ls2){
        if(ls1 == null) return ls2;
        if (ls2 == null) return ls1;

        if(ls1.val <= ls2.val) {
            ls1.next = mergeTwoList(ls1.next , ls2);
            return ls1;
        }else{
            ls2.next = mergeTwoList(ls1, ls2.next);
            return ls2;
        }
    }
}

//class ListNode{
//    int val;
//    ListNode next;
//    ListNode(){};
//    ListNode(int val){
//        this.val = val;
//    }
//    ListNode(int val, ListNode next){
//        this.val = val;
//        this.next = next;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)

}
