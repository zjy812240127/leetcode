//给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
//
//
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
//
// 初始状态下，所有 next 指针都被设置为 NULL。
//
//
//
// 进阶：
//
//
// 你只能使用常量级额外空间。
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
//
//
//
//
// 示例：
//
//
//
//
//输入：root = [1,2,3,4,5,6,7]
//输出：[1,#,2,3,#,4,5,6,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由
//next 指针连接，'#' 标志着每一层的结束。
//
//
//
//
// 提示：
//
//
// 树中节点的数量少于 4096
// -1000 <= node.val <= 1000
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 546 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNode().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        /**
         *  每一次递归先将该递归的root的中间节点用next串联  （纵向每一层 左右子树之间分开的两个节点链接）
         *  递归调用该root的left和right
         */
        dfs(root);
        return root;
    }

    public void dfs(Node root){
        if(root == null) return;
        Node left = root.left;
        Node right = root.right;

        // 左子树存在时才需要链接
        while(left != null){  // 该节点以下所有子层的中线处左右子节点相连，每一层只连接中间两个节点
            left.next = right;  // 第一层子层 左右相连
            /** 循环遍历该节点以下的所有子层 */
            left = left.right;
            right = right.left;
        }

        /** 连接每一层非中间线上的左右子节点，完整连接一层所有节点 */
        dfs(root.left);
        dfs(root.right);
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
