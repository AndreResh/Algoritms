package alg.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FirstDayDesign {
}
class LRUCache {

    private final Stack<Integer> stack;
    private final Map<Integer,Integer> map;
    private  int size;
    public LRUCache(int capacity) {
        this.size = capacity;
        this.stack = new Stack<>();
        this.map = new HashMap<>();

    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        return map.get(key);
    }

    public void put(int key, int value) {
        if(map.size()==size){
            System.out.println(map);
            System.out.println(stack);
            map.remove(stack.pop());
            map.put(key, value);
        } else {
            map.put(key, value);
        }
        stack.push(key);
        size++;
    }
}
