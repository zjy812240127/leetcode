package com.msb.algorithm;

/**
 * @author Joya Zou
 * @date 2021年12月01日 10:31
 */
public class TrieTree01DemoTest {

    public static void main(String[] args) {
        String[] ss = new String[10];
        for (int i = 0; i < 3; i++) {
            ss[i] = "asd";
        }

        for (int i = 3; i < 6; i++) {
            ss[i] = "asdk";
        }

        for (int i = 6; i < 10; i++) {
            ss[i] = "abcd";
        }

        TrieTree01Demo.TrieTree trieTree = new TrieTree01Demo.TrieTree();
        for (int i = 0; i < 10; i++) {
            trieTree.insert(ss[i]);
        }

        System.out.println(trieTree.searchPre("as"));
        System.out.println(trieTree.searchWord("asd"));
        trieTree.delete("asd");
        System.out.println(trieTree.searchWord("asd"));
    }


}
