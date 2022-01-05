package com;

import java.util.TreeMap;

/**
 * @author Joya Zou
 * @date 2021年12月27日 8:57
 */
public class TestTreeMap {
    TreeMap<Integer, Integer> tree;

    public static void main(String[] args) {
        TestTreeMap testTreeMap = new TestTreeMap();
        // ["MyCalendar","book","book","book","book","book","book","book","book","book","book"]
        // [[],[47,50],[33,41],[39,45],[33,42],[25,32],[26,35],[19,25],[3,8],[8,13],[18,27]]
        int[][] arr = {{47,50}, {33,41},{39,45},{33,42},{25,32},{26,35},{19,25},{3,8},{8,13},{18,27}};
        for (int[] a:arr){
            boolean book = testTreeMap.book(a[0], a[1]);
            System.out.println(book);
        }
    }


    public TestTreeMap() {
        tree = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if(tree.isEmpty() || tree.firstKey() >= end || tree.lastKey() <= start
        || (tree.floorKey(end) < start && tree.ceilingKey(start) > end)){
            tree.put(start, 1);
            tree.put(end-1, 1);
            return true;
        }

        return false;
    }
}
