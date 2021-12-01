package leetcode.editor.cn;

/**
 * @author Joya Zou
 * @date 2021年11月17日 10:10
 */
public class Solution {
    public static void main(String[] args) {
        String s = "car";
        String t = "rat";
        boolean anagram = isAnagram(s, t);
        System.out.println(anagram);
    }
    public static boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = s.toCharArray();
        if(sc.length != tc.length || s.equals(t)) {
            return false;
        }

        int[] sNums = new int[26];
        int[] tNums = new int[26];
        for(int i=0; i<sc.length; i++){
            sNums[sc[i] - 'a'] += 1;
        }

        for(int i=0; i<tc.length; i++){
            tNums[tc[i] - 'a'] += 1;
        }

        for(int i=0; i<26; i++){
            if(sNums[i] != tNums[i]) {
                return false;
            }
        }

        return true;
    }
}
