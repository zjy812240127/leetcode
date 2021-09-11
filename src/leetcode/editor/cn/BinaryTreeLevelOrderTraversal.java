//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例：
//二叉树：[3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层序遍历结果：
//
//
//[
//  [3],
//  [9,20],
//  [15,7]
//]
//
// Related Topics 树 广度优先搜索 二叉树 👍 996 👎 0

package leetcode.editor.cn;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            // 计算每层的节点数，队列每出一个节点减一次，长度为零表示该层结束，加入结果集
            int len = queue.size();
            List<Integer> tmpList = new ArrayList<>();  // 存放每一层的节点

            while(len > 0){
                TreeNode first = queue.removeFirst();
                tmpList.add(first.val);  // 每个节点的值加入数组

                if(first.left != null){
                    queue.addLast(first.left);
                }
                if(first.right != null){
                    queue.addLast(first.right);
                }
                len --;
            }
            // 一层结束
            res.add(tmpList);

        }

        return res;

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
