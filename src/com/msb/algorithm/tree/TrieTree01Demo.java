package com.msb.algorithm.tree;

/**
 * 前缀树，搜索一个字符串在字符串数组中出现的次数 或者以某个字符串开头的字符串在数组中个数
 * @author Joya Zou
 * @date 2021年12月01日 9:35
 */
public class TrieTree01Demo {


    /**
     * 前缀树节点，只保存pass和end，路径上存储字符串字符
     */

    public static class Node{
        // 经过该节点的次数
        int pass;
        // 以该节点为终点的字符串数量
        int end;
        // 下一个节点支路，假设字符串只包含26个小写字母，路径上为该字母
        Node[] next;

        Node(){
            this.pass = 0;
            this.end = 0;
            this.next = new Node[26];
        }
    }

    public static class TrieTree{
        // 头结点
        Node root;

        TrieTree(){
            this.root = new Node();
        }
        /**
         * 加入字符串
         * @param word
         */
        public void insert(String word){
            if (word == null){
                return;
            }
            Node node = root;
            node.pass ++;
            char[] cs = word.toCharArray();
            for (int i=0; i<cs.length; i++){
                int path = cs[i] - 'a';
                if (node.next[path] == null){
                    Node tmp = new Node();
                    node.next[path] = tmp;
                }
                node = node.next[path];
                node.pass ++;
            }
            node.end++;
        }

        /**
         * 搜索word出现的次数
         * @param word
         * @return
         */
        public int searchWord(String word){
            if (word == null) {
                return 0;
            }

            char[] cs = word.toCharArray();
            Node node = root;
            for (int i=0; i<cs.length; i++){
                int path = cs[i] - 'a';
                if (node.next[path] == null){
                    return 0;
                }
                node = node.next[path];
            }

            return node.end;
        }

        /**
         * 搜索前缀出现次数
         * @param prefix
         * @return
         */
        public int searchPre(String prefix){
            if (prefix == null){
                return 0;
            }

            char[] cs = prefix.toCharArray();
            Node node = root;
            for(int i=0; i<cs.length; i++){
                int path = cs[i] - 'a';
                if (node.next[path] == null){
                    return 0;
                }
                node = node.next[path];
            }
            return node.pass;
        }

        /**
         * 减少一次word出现的次数，当word为0次时释放内存
         * @param word
         */
        public void delete(String word){
            if (searchWord(word) == 0) {
                return;
            }

            char[] cs = word.toCharArray();
            Node node = root;
            node.pass --;
            for (int i = 0; i < cs.length; i++) {
                int path = cs[i] - 'a';
                /** 释放内存，防止内存泄漏  */
                if (--node.next[path].pass == 0){
                    node.next[path] = null;
                    return;
                }
                node = node.next[path];
                node.pass --;
            }
            node.end --;
        }


    }



}
