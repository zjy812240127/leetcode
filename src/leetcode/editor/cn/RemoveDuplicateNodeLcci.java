//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
//
// 示例1:
//
//
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
//
//
// 示例2:
//
//
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
//
//
// 提示：
//
//
// 链表长度在[0, 20000]范围内。
// 链表元素在[0, 20000]范围内。
//
//
// 进阶：
//
// 如果不得使用临时缓冲区，该怎么解决？
// Related Topics 哈希表 链表 双指针 👍 124 👎 0

package leetcode.editor.cn;

import java.util.*;

public class RemoveDuplicateNodeLcci {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicateNodeLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        // 出现的值，和对应的下标
        Set set = new HashSet();
        ListNode pre = head;

        ListNode cur = pre;

        while(cur != null){
            if(set.contains(cur.val)){
                pre.next = cur.next;
            }else{
                set.add(cur.val);
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }
}

 public class ListNode {
    int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

//class ListNode{
//    int val;
//    ListNode next;
//
//    ListNode(int val){
//        this.val = val;
//    }
//
//}
//leetcode submit region end(Prohibit modification and deletion)

}
