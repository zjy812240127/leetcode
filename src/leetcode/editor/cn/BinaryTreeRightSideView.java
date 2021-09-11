//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
//
//
// 示例 1:
//
//
//
//
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
//
//
// 示例 2:
//
//
//输入: [1,null,3]
//输出: [1,3]
//
//
// 示例 3:
//
//
//输入: []
//输出: []
//
//
//
//
// 提示:
//
//
// 二叉树的节点个数的范围是 [0,100]
// -100 <= Node.val <= 100
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 532 👎 0

package leetcode.editor.cn;

import java.util.*;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // 层序遍历，找到每一层的最右侧节点
        List<Integer> resList = new ArrayList<>();
        if(root == null){
            return resList;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);


        while(!queue.isEmpty()){
            int len = queue.size();
            Deque<TreeNode> myList = new ArrayDeque<>();
            while(len >0){
                TreeNode first = queue.removeFirst();
                myList.add(first);
                if(first.left != null) {
                    queue.addLast(first.left);
                }
                if(first.right != null){
                    queue.addLast(first.right);
                }
                len --;
            }
            // 加入最右侧节点值
            resList.add(myList.removeLast().val);
        }
        return resList;

    }


}

public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){
        left = null;
        right = null;
    }

    TreeNode(int val){
        this.val = val;
        left = null;
        right = null;
    }

    public void setVal(int val){
        this.val = val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
