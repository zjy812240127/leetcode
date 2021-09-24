//检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
//
// 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
//
// 注意：此题相对书上原题略有改动。
//
// 示例1:
//
//
// 输入：t1 = [1, 2, 3], t2 = [2]
// 输出：true
//
//
// 示例2:
//
//
// 输入：t1 = [1, null, 2, 4], t2 = [3, 2]
// 输出：false
//
//
// 提示：
//
//
// 树的节点数目范围为[0, 20000]。
//
// Related Topics 树 深度优先搜索 二叉树 字符串匹配 哈希函数 👍 43 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;

public class CheckSubtreeLcci {
    public static void main(String[] args) {
        Solution solution = new CheckSubtreeLcci().new Solution();
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
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        // 遍历t1每一个节点 ，对每一个t1中与t2根节点值相同的节点判断是否为子树

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(t1);
        boolean resFlag = false;
        while(!list.isEmpty()){
            TreeNode node = list.removeFirst();
            if(node.val == t2.val) {
                if(isSubTree(node, t2)){
                    resFlag = true;
                    break;
                }
            }
            if(node.left != null) list.add(node.left);
            if(node.right != null) list.add(node.right);
        }
        return resFlag;
    }

    public boolean isSubTree(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if((t1 == null && t2 != null) || (t1 != null && t2 == null)) return false;
        if(t1.val != t2.val) return false;
        return isSubTree(t1.left, t2.left) && isSubTree(t1.right, t2.right);
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
//leetcode submit region end(Prohibit modification and deletion)

}
