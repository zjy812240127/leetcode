package leetcode;

import java.util.*;

/**
 * @author Joya Zou
 * @date 2021年12月09日 10:51
 */
public class DoubleBFS {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        DoubleBFS doubleBFS = new DoubleBFS();
        int i = doubleBFS.ladderLength(beginWord, endWord, wordList);
        System.out.println(i);

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 双向BFS，起点和终点同时往中间搜，当他们的path有相同的元素时返回他们的step和

        // bfs 每次下一层元素为当前元素改变一个char后可以得到的 则加入queue
        // 到达目标元素的步数
        int step = 0;
        // 下一层的String
        LinkedList<String> path = new LinkedList<>();
        LinkedList<String> pathFinal = new LinkedList<>();

        // 防止找到前几层的元素
        Set<String> set = new HashSet<>();

        if(beginWord.equals(endWord)) return step;
        path.add(beginWord);
        pathFinal.add(endWord);

        boolean goon = true;
        while(path.size() >0 && pathFinal.size() >0 && goon){
            int len = path.size();
            int lenFinal = pathFinal.size();
            step ++;
            for(int i=0; i<len ; i++){
                // if(path.size() >0){
                /**  1. 起点走一步 */
                String tmp = path.removeFirst();
                set.add(tmp);
                findNextWord(tmp, wordList, path, set);
                if(hasSameNode(path, pathFinal)) {
                    goon = false;
                    step = 2*step;
                    break;
                }
                // }
            }

            if(!goon) break;

            for(int i= 0; i<lenFinal; i++){
                //  if(pathFinal.size()>0){
                /**  1. 终点走一步 */
                String tmpFinal = pathFinal.removeFirst();
                set.add(tmpFinal);
                findNextWord(tmpFinal, wordList, pathFinal,set);
                if(hasSameNode(path, pathFinal)) {
                    goon = false;
                    step = 2*step+1;
                    break;
                }
                // }
            }
        }

        return goon == false ? step : 0;
    }

    /**
     wordList中找所有可以作为下一层的words
     */
    public void findNextWord(String beginWord, List<String> wordList, LinkedList<String> path, Set<String> set){
        for(String s:wordList){
            if(isNearWord(beginWord,s) && !set.contains(s)) path.add(s);
        }
    }

    /**
     判断是否只需要改变一个char
     */
    public boolean isNearWord(String s1, String s2){
        if(s1.length() != s2.length()) return false;

        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        // 不同char的个数
        int count = 0;
        for(int i=0; i<cs1.length; i++){
            if(count > 1) {
                break;
            }
            if(cs1[i] != cs2[i]) count ++;
        }
        if(count != 1) return false;
        return true;
    }

    /**
     判断双向BFS的交集 todo 不能remove出元素
     */
    public boolean hasSameNode(LinkedList<String> path, LinkedList<String> pathFinal){
        Set<String> set = new HashSet<>();
        for (String s : path) {
            set.add(s);
        }

        boolean flag = false;
        for (String s : pathFinal) {
            if (set.contains(s)){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
