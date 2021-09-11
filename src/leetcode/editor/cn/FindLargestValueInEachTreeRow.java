//给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
//
//
//
// 示例1：
//
//
//输入: root = [1,3,2,5,3,null,9]
//输出: [1,3,9]
//解释:
//          1
//         / \
//        3   2
//       / \   \
//      5   3   9
//
//
// 示例2：
//
//
//输入: root = [1,2,3]
//输出: [1,3]
//解释:
//          1
//         / \
//        2   3
//
//
// 示例3：
//
//
//输入: root = [1]
//输出: [1]
//
//
// 示例4：
//
//
//输入: root = [1,null,2]
//输出: [1,2]
//解释:
//           1
//            \
//             2
//
//
// 示例5：
//
//
//输入: root = []
//输出: []
//
//
//
//
// 提示：
//
//
// 二叉树的节点个数的范围是 [0,10⁴]
// -2³¹ <= Node.val <= 2³¹ - 1
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 142 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FindLargestValueInEachTreeRow {
    public static void main(String[] args) {
        Solution solution = new FindLargestValueInEachTreeRow().new Solution();
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return  res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);


        while(!queue.isEmpty()){
            List<Integer> myList = new ArrayList<>();  // 存放每层的节点值
            int len = queue.size();  // 标记每一层
            while (len >0){
                TreeNode first = queue.removeFirst();
                myList.add(first.val);
                if(first.left != null){
                    queue.addLast(first.left);
                }

                if(first.right != null){
                    queue.addLast(first.right);
                }
                len --;
            }

            int max = Integer.MIN_VALUE;
            for(int i=0; i<myList.size(); i++){
                if(myList.get(i) > max){
                    max = myList.get(i);
                }
            }

            res.add(max);


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
    }

    public void setVal(int val){
        this.val = val;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
