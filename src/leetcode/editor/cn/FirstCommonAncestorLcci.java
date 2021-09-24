//设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
//
//     3
//   / \
//  5   1
// / \ / \
//6  2 0  8
//  / \
// 7   4
//
//
// 示例 1:
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
//
// 示例 2:
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
//
// 说明:
//
// 所有节点的值都是唯一的。
//p、q 为不同节点且均存在于给定的二叉树中。
// Related Topics 树 深度优先搜索 二叉树 👍 54 👎 0

package leetcode.editor.cn;
public class FirstCommonAncestorLcci {
    public static void main(String[] args) {
        Solution solution = new FirstCommonAncestorLcci().new Solution();
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
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q || root == null) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p,q);
        if(left == null && right!=null) return right;
        if(left != null && right == null) return left;
        if(left != null && right != null) return root;
        return null;
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
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
