package alg.ace_inteviev_1;

import java.util.*;
import java.util.stream.Collectors;

public class DayFifteen {
    public static void main(String[] args) {
        System.out.println(new DayFifteen().lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }

    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            queue.add(stones[i]);
        }
        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            if (a != b) {
                queue.add(a - b);
            }
//            System.out.println(queue);
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        Queue<String> queue = new PriorityQueue<>(((o1, o2) -> {
            int result = map.get(o2) - map.get(o1);
            return result == 0 ? o1.compareTo(o2) : result;
        }));
        queue.addAll(map.keySet());
        List<String> list = new ArrayList<>();
        while (k != 0) {
            list.add(queue.poll());
            k--;
        }
        return list;
    }
}
