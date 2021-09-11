//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 20
//
// Related Topics 数组 矩阵 模拟 👍 477 👎 0

package leetcode.editor.cn;
public class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int up = 0;
        int down = n-1;
        int left = 0;
        int right = n-1;
        int[][] res = new int[n][n];

        printMat(res, up, down,left,right, 1, n);
        return res;


    }

    // start是本轮开始的第一个元素
    public void printMat(int[][] res, int up, int down, int left, int right, int start, int n){

        if(start > n*n) return;

        // 打印上边
        if(up<=down){
            for(int i= left; i<= right ; i++){
                res[up][i] = start;
                start ++;
            }
            up ++;
        }

        // 打印右边
        if(right >= left){
            for(int i= up; i<=down; i++){
                res[i][right] = start;
                start ++;
            }
            right --;
        }

        // 打印下边
        if(down >= up){
            for(int i=right; i>=left; i--){
                res[down][i] = start;
                start ++;
            }
            down --;
        }

        // 打印左边
        if(left <=right){
            for(int i= down; i>=up; i--){
                res[i][left] = start;
                start ++;
            }
            left ++;
        }

        printMat(res,up,down,left,right,start,n);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
