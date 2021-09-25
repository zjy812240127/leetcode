//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
//
//
//
// 示例 1：
//
// 输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
//
//
// 示例 2：
//
// 输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
//
// Related Topics 数组 哈希表 矩阵 👍 36 👎 0

package leetcode.editor.cn;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

import java.util.HashSet;
import java.util.Set;

public class ZeroMatrixLcci {
    public static void main(String[] args) {
        Solution solution = new ZeroMatrixLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void setZeroes(int[][] matrix) {
        // 存放要消去的x行号
        Set<Integer> xSet = new HashSet<>();
        // 存放要消去的y列号
        Set<Integer> ySet = new HashSet<>();

        for(int i=0; i<matrix.length; i++){
            // if(xSet.contains(i)) continue;
            for(int j=0; j<matrix[0].length; j++){
                // if(ySet.contains(j)) continue;
                if(matrix[i][j] == 0) {
                    xSet.add(i);
                    ySet.add(j);
                }
            }
        }

        for(Integer x:xSet){
            for(int i=0; i<matrix[0].length; i++){
                matrix[x][i] = 0;
            }
        }

        for(Integer y:ySet){
            for(int i=0; i<matrix.length; i++){
                matrix[i][y] = 0;
            }
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
