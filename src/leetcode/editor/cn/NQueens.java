//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
//
//
//
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
//
//
// 示例 1：
//
//
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：[["Q"]]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 9
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
//
//
//
// Related Topics 数组 回溯 👍 1005 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *  回溯遍历每一行的每一个元素，遍历同一行一个元素后要回溯到改行该元素的下一个元素 -- 因为要求所有棋盘摆放方式
     */
    class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();  // 结果集
      //  List<String> myList = new ArrayList<>();  // 存放单个结果
        // 初始化棋盘
        char[][] board = new char[n][n];  // 棋盘
        for(char[] bd : board){
            Arrays.fill(bd,'.');
        }
        dfs(board,res,0);

        return res;

    }

    // num表示递归层数--当前行
    public void dfs(char[][] board, List<List<String>> res, int num){
        if(num == board.length){
            // 加入结果集
            List<String> tmpList = toList(board);
            res.add(tmpList);
        }

        // 回溯遍历该层每一个元素
        for(int i=0; i<board.length; i++){

            if(isValid(board, num, i)){  // 判断x行，i列是否可以放入Q
                board[num][i] = 'Q';  // 成功放入
                dfs(board, res, num +1);  // 遍历下一行
                board[num][i] = '.';  // 当前位置元素还原，判断改行其他元素
            }
        }

    }

    public List<String> toList(char[][] board){
        List<String> res = new ArrayList<>();
        int x = board.length;  // 行数
        int y = board[0].length;  // 列数
        for(int i=0; i< x; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<y; j++){
                sb.append(board[i][j]);
            }
            res.add(sb.toString());
        }
        return res;
    }

        /**
         * 三个方向判断当前棋盘摆放是否可行，横向因为回溯了肯定不存在同行的元素
         *
         * @param board
         * @param num  当前行数
         * @param y   当前列
         * @return
         */
    public boolean isValid(char[][] board, int num, int y){
        // 纵向
        for(int i=0; i<num; i++){
            if(board[i][y] == 'Q') return false;
        }
        // 45度
        int addy = y + 1;
        int subx = num - 1;
        while(addy < board[0].length && subx >= 0){
            if(board[subx][addy] == 'Q') return false;
            addy ++;
            subx --;
        }
        // 135度
        int subbx = num-1;
        int suby = y-1;
        while(subbx >=0 && suby>=0){
            if(board[subbx][suby] == 'Q') return false;
            subbx --;
            suby --;
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
