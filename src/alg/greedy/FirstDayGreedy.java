package alg.greedy;

import java.lang.reflect.Proxy;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class FirstDayGreedy {
    public static void main(String[] args) {
//        System.out.println(Arrays.deepToString(new FirstDayGreedy().reconstructQueue(new int[][]{{6, 0}, {5, 0}, {4, 0}, {3, 2}, {2, 2}, {1, 4}})));
        List<Integer> list = List.of(3, 1, 2);
//        Integer a = 2;
//        Integer b = 3;
//        System.out.println(a.longValue()*a.longValue()*b.longValue()*b.longValue());
//        long a = list.stream().collect(Collectors.reducing(1l,Integer::longValue, (x, y) -> x*(y*y)));
        System.out.println(0 % 3);
    }

    public int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Integer> integerList = new ArrayList<>(map.values());
        integerList.sort(((o1, o2) -> o2 - o1));
        int result = 0;
        int canBe = integerList.get(0) - 1;
        for (int i = 1; i < integerList.size(); i++) {
            if (canBe < integerList.get(i)) {
                result += integerList.get(i) - canBe;
                if (canBe > 0) canBe--;
            } else {
                canBe = Math.min(canBe, integerList.get(i)) - 1;
            }

        }
        return result;
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        System.out.println(Arrays.deepToString(people));
        List<int[]> ordered = new LinkedList<>();
        for (int[] p : people) {
            ordered.add(p[1], p);
            System.out.println(Arrays.toString(p) + " " + p[1]);
            ordered.forEach((o) -> System.out.println(Arrays.toString(o)));
        }
        System.out.println();


        return null;
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, ((o1, o2) -> o2[1] - o1[1]));
        int sum = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            if (boxTypes[i][0] < truckSize) {
                sum += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            } else {

                sum += truckSize * boxTypes[i][1];
                break;
            }
        }
        return sum;
    }

    public int candy(int[] ratings) {
        int[] arr = new int[ratings.length];
        Arrays.fill(arr, 1);
        for (int i = 1; i < arr.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        int sum = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            arr[i] = Math.max(arr[i + 1] + 1, arr[i]);
            sum += arr[i];
        }
        return sum;
    }

    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        int result = 0;
        boolean canAdd = true;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            if (entry.getKey().charAt(0) == entry.getKey().charAt(1)) {
                result += entry.getValue() / 2 * 4;
                if (canAdd && entry.getValue() % 2 != 0) {
                    canAdd = false;
                    result += 2;
                }
            } else {
                StringBuilder builder = new StringBuilder(entry.getKey());
                builder.reverse();
                if (map.containsKey(builder.toString())) {
                    result += Math.min(entry.getValue(), map.get(builder.toString())) * 4;
                    map.remove(entry.getKey());
                    map.remove(builder.toString());
                }
            }

        }
        return result;
    }

    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        StringBuilder builder = new StringBuilder();
        int i = 0;
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>((o1, o2) -> o2.count - o1.count);
        map.forEach((key, value) -> queue.add(new Pair(key, value)));
        Pair f = queue.poll();
        builder.append(f.ch);
        f.count--;
        queue.add(f);
        while (i < s.length() - 1) {
            Pair pair = queue.poll();
            if (pair.ch == builder.charAt(builder.length() - 1) && !queue.isEmpty()) {
                Pair pair2 = queue.poll();
                queue.add(pair);
                pair = pair2;
            }
            if (pair.count == 0 || builder.charAt(builder.length() - 1) == pair.ch) return "";
            builder.append(pair.ch);
            pair.count--;
            queue.add(pair);
            i++;
        }
        return builder.toString();
    }

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : tasks) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int countOfSteps = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int current = entry.getValue();
            if (current == 1) {
                return -1;
            } else if (current == 2 || current == 3) {
                countOfSteps++;
            } else if (current % 3 == 0) {
                countOfSteps += current / 3;
            } else if (current % 3 == 2) {
                countOfSteps += current / 3 + 1;
            } else if (current % 3 == 1) {
                countOfSteps += current / 3 - 1 + 2;
            }
        }
        return countOfSteps;
    }

    public int maxNonOverlapping(int[] nums, int target) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int normal = 0;
        map.put(0, 0);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int index = map.getOrDefault(sum - target, -1);
            if (index >= normal) {
                count++;
                normal = i + 1;
            }
            map.put(sum, i + 1);
        }

        return count;
    }

    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 3 != 0) return false;
        int main = sum / 3;
        int current = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            current += arr[i];
            if (main == current) {
                count++;
                current = 0;
            }
        }
        return count == 3;
    }

    public int findMiddleIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum - leftSum - nums[i] == leftSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }

    public int waysToSplitArray(int[] nums) {
        long[] ints = new long[nums.length];
        ints[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ints[i] = ints[i - 1] + nums[i];
        }
        int count = 0;
        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i] >= ints[ints.length - 1] - ints[i]) {
                count++;
            }
        }
        return count;
    }

    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
           if(nums[i]<=min){
               min = nums[i];
           } else if (nums[i]<=middle) {
               middle = nums[i];
           } else {
               return true;
           }
        }
        return false;
    }
}

class Pair {
    char ch;
    int count;

    public Pair(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}
