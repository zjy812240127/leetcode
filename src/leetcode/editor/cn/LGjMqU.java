//给定一个单链表 L 的头节点 head ，单链表 L 表示为：
//
// L0 → L1 → … → Ln-1 → Ln
//请将其重新排列后变为：
//
// L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
// 示例 1:
//
//
//
//
//输入: head = [1,2,3,4]
//输出: [1,4,2,3]
//
// 示例 2:
//
//
//
//
//输入: head = [1,2,3,4,5]
//输出: [1,5,2,4,3]
//
//
//
// 提示：
//
//
// 链表的长度范围为 [1, 5 * 10⁴]
// 1 <= node.val <= 1000
//
//
//
//
// 注意：本题与主站 143 题相同：https://leetcode-cn.com/problems/reorder-list/
// Related Topics 栈 递归 链表 双指针 👍 4 👎 0

package leetcode.editor.cn;

import java.util.List;

public class LGjMqU {
    public static void main(String[] args) {
        Solution solution = new LGjMqU().new Solution();
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

    public void reorderList(ListNode head) {
        // 快慢指针找到中间节点，将后半链反转
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode sNode = pre;
        ListNode fNode = pre;
        while(fNode != null && fNode.next!= null){
            sNode = sNode.next;
            fNode = fNode.next.next;
        }

        ListNode subHead = sNode.next;  // 后半连的首节点
        sNode.next = null;  // 断开后半段链

        // 反转后半连 cur tmp pre,
        /**
         *  反转链表
         *  1. pre为前节点，初始指向尾节点null
         *  2. cur为当前节点，初始指向首节点
         *  3. tmp为临时节点。存放cur操作前的下一个节点，作为下一轮操作的cur
         */
        // 初始化首尾节点
        ListNode cur = subHead.next;
        pre = null;
        // 翻转
        while (cur.next != null){
            ListNode tmp = cur.next;
            cur.next = pre;  // 改变链接方向
            pre = cur;  // 准备下一轮前节点
            cur = tmp;  // 下一轮操作节点
        }
        // 反转链表首节点
        ListNode rHead = cur;

        //合并前后两段链 head, cur
        ListNode curr = new ListNode();
        ListNode lHead = head;
        while(rHead != null){
            ListNode lTmp = lHead.next;
            ListNode rTmp = rHead.next;
            curr.next = lHead;
            curr.next.next = rHead;
            lHead = lTmp;
            rHead = rTmp;
        }
        // 防止前半链多出一个节点(奇数个节点时)
        if(lHead != null){
            curr.next = lHead;
        }

    }


}

public class ListNode{
    int val;
    ListNode next;

    ListNode(){

    }

    ListNode(int val){
        this.val = val;
    }

    public void setVal(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
