package leetcode.editor.cn;

import java.util.*;

public class PhoneNumber {
    public static void main(String[] args) {
        String digits = "23";
        PhoneNumber pn = new PhoneNumber();
        List<String> letterCombinations = pn.letterCombinations(digits);
        System.out.println(letterCombinations);
    }


    public List<String> letterCombinations(String digits) {
        // 存入map
        // 对每一个数子遍历他对应的String中的每一个元素（回溯）
        Map<Integer, String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        List<String> res = new ArrayList<>();
        Deque<Character> path = new ArrayDeque<>();
        int len = digits.length();
        int index = 0;

        dfs(digits, index, res, path, len,map);
        return res;

    }

    public void dfs(String digits, int index, List<String> res, Deque<Character> path, int len, Map<Integer, String> map){

        if(path.size() == len){
            res.add(path.toString());
            return;
        }

        for(int i=0; i<map.get(digits.charAt(index)).length(); i++){
            path.addLast(map.get(digits.charAt(index)).charAt(i) );
            dfs(digits, index+1, res, path, len, map);
            path.removeLast();
        }

    }
}
