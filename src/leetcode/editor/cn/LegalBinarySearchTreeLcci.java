//实现一个函数，检查一棵二叉树是否为二叉搜索树。示例 1: 输入:     2    / \   1   3 输出: true 示例 2: 输入:     5
//    / \   1   4      / \     3   6 输出: false 解释: 输入为: [5,1,4,null,null,3,6]。
//  根节点的值为 5 ，但是其右子节点值为 4 。 Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 60 👎 0

package leetcode.editor.cn;

import javax.transaction.TransactionRequiredException;
import java.util.ArrayList;
import java.util.List;

public class LegalBinarySearchTreeLcci {
    public static void main(String[] args) {
        Solution solution = new LegalBinarySearchTreeLcci().new Solution();
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
    public boolean isValidBST(TreeNode root) {
        // 递归判断每一个节点作为根节点是否是合法的,
        // 每一个子树的子节点除了满足和他自己的根节点的大小关系，还要满足祖父根节点的大小关系
        // 中序遍历，得到的因该是递增的数组
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        boolean flag = true;
        for(int i=1; i<list.size(); i++){
            if(list.get(i) <=list.get(i-1)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public void dfs(TreeNode root, List<Integer> list){
        if(root == null) return;
        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);
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
