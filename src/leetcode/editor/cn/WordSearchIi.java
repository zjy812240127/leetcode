//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。
//
//
//
// 示例 1：
//
//
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f",
//"l","v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
//
//
// 示例 2：
//
//
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
//
//
//
//
// 提示：
//
//
// m == board.length
// n == board[i].length
// 1 <= m, n <= 12
// board[i][j] 是一个小写英文字母
// 1 <= words.length <= 3 * 10⁴
// 1 <= words[i].length <= 10
// words[i] 由小写英文字母组成
// words 中的所有字符串互不相同
//
// Related Topics 字典树 数组 字符串 回溯 矩阵 👍 555 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSearchIi {
    public static void main(String[] args) {
        Solution solution = new WordSearchIi().new Solution();
        char[][] board = new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        final List<String> stringList = solution.findWords(board, words);
        System.out.println(stringList);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findWords(char[][] board, String[] words) {

        List<String> resList = new ArrayList<>();
        boolean nextWord = true;
        // 搜索每一个word
        for(int indexWords=0; indexWords<words.length && nextWord; indexWords++){
            String str = words[indexWords];
            // 主函数中遍历board找到第一个匹配的字符，然后dfs中遍历该格子的四周格子
            // 判断当前格子元素是否被占用
            boolean isUsed[][] = new boolean[board.length][board[0].length];
            // str的当前匹配的下标
            int index = 0;
            for(int i = 0; i<board.length && nextWord; i++){
                for(int j=0; j<board[0].length && nextWord; j++){
                    if(!isUsed[i][j] && board[i][j] == str.charAt(index)){
                        index ++;
                        isUsed[i][j] = true;
                        if(isMatched(board,str,i+1,j, 1,isUsed) || isMatched(board,str,i-1,j, 1,isUsed)
                                ||isMatched(board,str,i,j+1, 1,isUsed)||isMatched(board,str,i,j-1, 1,isUsed)){
                            resList.add(str);
                            nextWord = false;
                            break;
                        }
                        // 当前情况失败，重置
                       //  Arrays.fill(isUsed,false);
                        isUsed = new boolean[board.length][board[0].length];
                    }
                }
            }
            //indexWords ++;
            nextWord = true;

        }

        return resList;
    }

        /**
         *
         * @param board
         * @param str
         * @param x 当前匹配元素格子位置
         * @param y
         * @param index 当前需要匹配的str的字符的下标
         * @return
         */
    public boolean isMatched(char[][] board, String str, int x, int y, int index, boolean isUsed[][]){
        if(index == str.length()) return true;
        if(x<0 || x>=board.length || y<0 || y>=board[0].length) return false;
        if(board[x][y] == str.charAt(index) && !isUsed[x][y] ) {
            isUsed[x][y] = true;
            index ++;
            return isMatched(board,str,x+1, y, index, isUsed) || isMatched(board,str,x-1, y, index, isUsed)
                    || isMatched(board,str,x, y+1, index, isUsed) || isMatched(board,str,x, y-1, index, isUsed);
        }
        else{
            return false;
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
