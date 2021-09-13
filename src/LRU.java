import java.util.LinkedHashMap;

public class LRU {
    /**
     *   LinkedHashMap
     */
    int capacity;
    LinkedHashMap<Integer, Integer> map;

    LRU(int capacity){
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key){
        if(!map.containsKey(key)) return -1;
        else {
            int val = map.get(key);
            map.remove(key);
            map.put(key, val);
            return val;
        }
    }

    public void put(int key, int val){
        if(map.size()<capacity){
            map.put(key,val);
        }else{
            map.remove(map.entrySet().iterator().next().getKey());
            map.put(key,val);
        }
    }



}
