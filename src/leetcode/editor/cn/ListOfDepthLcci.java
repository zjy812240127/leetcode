//给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
//
//
//
// 示例：
//
// 输入：[1,2,3,4,5,null,7,8]
//
//        1
//       /  \
//      2    3
//     / \    \
//    4   5    7
//   /
//  8
//
//输出：[[1],[2,3],[4,5,7],[8]]
//
// Related Topics 树 广度优先搜索 链表 二叉树 👍 54 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListOfDepthLcci {
    public static void main(String[] args) {
        Solution solution = new ListOfDepthLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {
        // 层序遍历，每一层作为一个数组
        List<ListNode> resList = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(tree);

        while(!list.isEmpty()){
            int len = list.size();
            // List<ListNode> path = new ArrayList<>();
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            while(len >0){
                TreeNode node = list.removeFirst();
                cur.next = new ListNode(node.val);
                cur = cur.next;
                if(node.left != null) list.add(node.left);
                if(node.right != null) list.add(node.right);
                len --;
            }
            resList.add(dummy.next);
        }

        return resList.toArray(new ListNode[resList.size()]);


    }


}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){
        this.val = val;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
