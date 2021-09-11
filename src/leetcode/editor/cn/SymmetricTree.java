//给定一个二叉树，检查它是否是镜像对称的。
//
//
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//
//
//
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
//
//
//
//
// 进阶：
//
// 你可以运用递归和迭代两种方法解决这个问题吗？
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1528 👎 0

package leetcode.editor.cn;
public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
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
    public boolean isSymmetric(TreeNode root) {
        // 从第二层开始，每个左节点的左子树等有右节点的右子树则为true
        if(root == null) return true;
        return isValid(root.left,root.right);

    }

    public boolean isValid(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null && right != null) return false;
        if(left != null && right == null) return false;

        if(left.val != right.val) return false;
       // if(left.left.val != right.right.val) return false;
       // if(left.right.val != right.left.val) return false;
        return isValid(left.left, right.right) && isValid(left.right, right.left);

    }


}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){
        this.left = null;
        this.right = null;
    }

    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
