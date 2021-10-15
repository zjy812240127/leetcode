package com.zjut.juc.test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Joya Zou
 * @date 2021年10月14日 19:48
 */
public class LRUCache {
    public Map<Integer, Integer> map = new LinkedHashMap<>(16,0.75f,true);

    public void put(Integer key, Integer val){
        if(map.containsKey(key)){
            map.remove(key);
        }else {
            if(map.size() == 16){
                map.remove(map.keySet().iterator().next());
            }
        }
        map.put(key,val);
    }

    public int get(Integer key){
        if(map.containsKey(key)){
            int val = map.get(key);
            map.remove(key);
            map.put(key,val);
            return val;
        }else {
            return -1;
        }
    }
}
