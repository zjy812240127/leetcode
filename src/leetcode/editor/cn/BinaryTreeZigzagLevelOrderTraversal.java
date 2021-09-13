//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回锯齿形层序遍历如下：
//
//
//[
//  [3],
//  [20,9],
//  [15,7]
//]
//
// Related Topics 树 广度优先搜索 二叉树 👍 516 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        /**
         *      奇数层节点和偶数层节点的子节点加入双向队列的方式不同，头插法和尾插法  都是先加右节点，再加左节点
         *      偶数层， 尾插法，addLast
         *      奇数层， 头插法, addFirst
         */
        int level = 0;  // 父节点所在层数
        List<List<Integer>> resList = new ArrayList<>();
        if(root == null) return resList;

        Deque<TreeNode> path = new ArrayDeque<>();
        path.addLast(root);
        while(!path.isEmpty()){
            int len = path.size();
            List<Integer> res = new ArrayList<>();
            while(len > 0){

                if(level % 2 == 0){
                    TreeNode tmp = path.removeLast();
                    res.add(tmp.val);
                    if(tmp.right != null) path.addLast(tmp.right);
                    if(tmp.left != null) path.addLast(tmp.left);
                    len --;
                }else{
                    TreeNode tmp = path.removeFirst();
                    res.add(tmp.val);
                    if(tmp.right != null) path.addLast(tmp.right);
                    if(tmp.left != null) path.addLast(tmp.left);
                    len --;
                }
            }
            resList.add(res);
            level ++;
        }
        return resList;

    }
}


//leetcode submit region end(Prohibit modification and deletion)

}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){
        left = null;
        right = null;
    }

    TreeNode(int val){
        this.val = val;
    }

    public void setVal(int val){
        this.val = val;
    }
}
