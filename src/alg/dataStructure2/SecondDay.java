package alg.dataStructure2;

import java.util.*;

public class SecondDay {
    public static void main(String[] args) {
        new SecondDay().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<>();
        for (int[] ints: intervals){
            if(list.isEmpty() || list.get(list.size()-1)[1]<ints[0]){
                list.add(ints);
            } else {
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1], ints[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
class MyHashMap {
    private int[] ints;
//    private class Node<K, V>{
//        private int key;
//        private int value;
//
//        public Node(int key, int value) {
//            this.key = key;
//            this.value = value;
//        }
//    }
    public MyHashMap() {
        ints = new int[100];
        Arrays.fill(ints, -1);
    }

    public void put(int key, int value) {
        ints[key] = value;
    }

    public int get(int key) {
return ints[key];
    }

    public void remove(int key) {
ints[key] = -1;
    }
}