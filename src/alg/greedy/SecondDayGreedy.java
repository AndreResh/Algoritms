package alg.greedy;

import java.time.LocalDateTime;
import java.util.*;

public class SecondDayGreedy {
    static {
        System.out.println("Hekki");
    }
    public static void main(String[] args) {
        System.out.println(new SecondDayGreedy().solve(new ArrayList<>(List.of(3, 2, 4, 1, 5)), 3));
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            queue.add(A.get(i));
            map.put(A.get(i), i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            if (B != 0) {
                int max = queue.poll();
                list.add(max);
                if (max == A.get(i)) {
                    continue;
                }
                A.set(map.get(max), A.get(i));
                map.put(A.get(i), map.get(max));
                B--;
            } else {
                list.add(A.get(i));
            }
        }
        return list;
    }

    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int sum = 0;
        while (startPos[0] != homePos[0]) {
            if (startPos[0] < homePos[0]) {
                sum += rowCosts[++startPos[0]];
            } else {
                sum += rowCosts[--startPos[0]];
            }
        }
        while (startPos[1] != homePos[1]) {
            if (startPos[1] < homePos[1]) {
                sum += colCosts[++startPos[1]];
            } else {
                sum += colCosts[--startPos[1]];
            }
        }
        return sum;
    }


    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int a : nums) {
            treeMap.put(a, treeMap.getOrDefault(a, 0) + 1);
        }
        int size = nums.length;
        while (size != 0) {
            int current = treeMap.firstKey();
            for (int i = 0; i < k; i++) {
                if (treeMap.containsKey(current)) {
                    int count = treeMap.get(current) - 1;
                    if (count == 0) {
                        treeMap.remove(current);
                    } else {
                        treeMap.put(current, count);
                    }
                    current = current + 1;
                } else {
                    return false;
                }
            }
            size -= k;
        }
        return true;
    }

    public int solve(ArrayList<ArrayList<Integer>> A) {
        A.sort((Comparator.comparingInt(o -> o.get(0))));
        int size = 1;
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(A.get(0).get(1));
        for (int i = 1; i < A.size(); i++) {
            while (!queue.isEmpty() && queue.peek() <= A.get(i).get(0)) {
                queue.poll();
            }
            queue.offer(A.get(i).get(1));
            size = Math.max(size, queue.size());
        }
        return size;
    }

    public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        Collections.sort(A);
        Collections.sort(B);
        int max = 0;
        for (int i = 0; i < A.size(); i++) {
            max = Math.max(max, Math.abs(A.get(i) - B.get(i)));
        }
        return max;
    }

    public int bulbs(ArrayList<Integer> A) {
        int countOfSwitch = 0;
        for (Integer integer : A) {
            if (integer == 0 && countOfSwitch % 2 == 0) {
                countOfSwitch++;
            } else if (integer == 1 && countOfSwitch % 2 != 0) {
                countOfSwitch++;
            }
        }
        return countOfSwitch;
    }

    public int candy(int[] ratings) {
//        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
//        for (int i = 0; i < ratings.length; i++) {
//            List<Integer> list = treeMap.getOrDefault(ratings[i], new ArrayList<>());
//            list.add(i);
//            treeMap.put(ratings[i], list);
//        }
//        int[] candies = new int[ratings.length];
//        for (Map.Entry<Integer, List<Integer>> entry : treeMap.entrySet()) {
//            List<Integer> list = entry.getValue();
//            for (Integer num : list) {
//                if((num>0 && ratings[num-1]<entry.getKey()) || (num< ratings.length-1 && ratings[num+1]<entry.getKey())){
//                    int max =  num>0 && ratings[num-1]<entry.getKey()?candies[num-1]:1;
//                    max = num< ratings.length-1 && ratings[num+1]<entry.getKey()?Math.max(candies[num+1], max):max;
//                    candies[num]  = max+1;
//                } else {
//                    candies[num] = 1;
//                }
//            }
//        }
//        int sum = 0;
//        for (int a : candies) {
//            sum+=a;
//        }
//        return sum;

        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < left.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] += left[i - 1];
            }
        }
        for (int i = right.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] += right[i + 1];
            }
        }
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(right[i], left[i]);
        }
        return sum;

    }

    public int disjointIntervals(ArrayList<ArrayList<Integer>> A) {
        A.sort(Comparator.comparingInt(o -> o.get(1)));
        int lastMin = Integer.MIN_VALUE;
        int count = 0;
        for (List<Integer> list : A) {
            if (lastMin >= list.get(0)) continue;
            count++;
            lastMin = list.get(1);
        }
        return count;
    }

    public int maxSubArray(final List<Integer> A) {
        int max = A.get(0);
        int sum = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            sum += A.get(i);
            if (A.get(i) > sum) sum = A.get(i);
            max = Math.max(sum, max);
        }
        return max;
    }

}
