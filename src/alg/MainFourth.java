package alg;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MainFourth {
    public static void main(String[] args) {
//        System.out.println(new MainFourth().minDistance("leetcode", "etco"));
    }

    public int maximumUniqueSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                max = Math.max(sum, max);
                while (nums[j] != nums[i]) {
                    set.remove(nums[j]);
                    sum -= nums[j++];
                }
                sum -= nums[j++];
            }
            set.add(nums[i]);
            sum += nums[i];
        }
        return Math.max(sum, max);
    }

    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                map.put(nums[i][j], map.getOrDefault(nums[i][j], 0) + 1);
            }
        }
        List<Integer> list = new ArrayList<>(map.entrySet().stream().filter((o) -> o.getValue() == nums.length).map(Map.Entry::getKey).toList());
        Collections.sort(list);
        return list;
    }

    static int count;

    public int countVowelPermutation(int n) {
        count = 0;
        List<Character> characters = List.of('a', 'e', 'i', 'o', 'u');
        countOfPermutLetters(characters, 0, new StringBuilder(), n);
        return count;
    }

    private void countOfPermutLetters(List<Character> characters, int start, StringBuilder builder, int size) {
        if (builder.length() == size) {
            count++;
            return;
        }
        for (int i = start; i < characters.size(); i++) {
            builder.append(characters.get(i));
            countOfPermutLetters(characters, start, builder, size);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public int hammingDistance(int x, int y) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int k = ~x;
            count += k & y;
            x = x >> 1;
            y = y >> 1;
            System.out.println(x + " " + y);
        }
        return count;
    }

    public int uniquePaths(int m, int n) {
        int[][] ints = new int[m][n];
        return getAllPath(ints, 0, 0);
    }

    private int getAllPath(int[][] ints, int i, int j) {
        if (i == ints.length - 1 && j == ints[0].length - 1) {
            return 1;
        }
        if (ints[i][j] != 0) {
            return ints[i][j];
        }
        int z = 0;
        if (i + 1 <= ints.length - 1) {
            z += getAllPath(ints, i + 1, j);
        }
        if (j + 1 <= ints[0].length - 1) {
            z += getAllPath(ints, i, j + 1);
        }
        ints[i][j] = z;
        return z;
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int cur;
        for (int i = 1; i < prices.length; i++) {
            cur = prices[i] - prices[i - 1];
            if (cur > 0) {
                profit += cur;
                i++;
            }
        }
        return profit;
    }

    public int findCenter(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == edges[i + 1][0] || edges[i][0] == edges[i + 1][1]) {
                return edges[i][0];
            } else if (edges[i][1] == edges[i + 1][0] || edges[i][1] == edges[i + 1][1]) {
                return edges[i][1];
            }
        }
        return 1;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Graph graph = new Graph(n);
        for (int i = 0; i < edges.length; i++) {
            graph.union(edges[i][0], edges[i][1]);
        }
        return graph.isConnect(source, destination);

    }

    public int findJudge(int n, int[][] trust) {
        GraphQuickFind quickFind = new GraphQuickFind(n);
        for (int i = 0; i < trust.length; i++) {
            quickFind.union(trust[i][0], trust[i][1]);
        }
        return quickFind.findJudge();
    }

    public int minDistance(String word1, String word2) {

        Map<Character, Integer> map1 = new ConcurrentHashMap<>();
        for (char ch : word1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> map2 = new ConcurrentHashMap<>();
        for (char ch : word2.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        int count = 0;
        count += changeMaps(map1, map2);
        count += changeMaps(map2, map1);
        return count;
    }

    private int changeMaps(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        if (map1.isEmpty()) return 0;
        int count = 0;
        System.out.println(map1 + " " + map2);
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())) {
                int a1 = entry.getValue();
                int a2 = map2.get(entry.getKey());
                count += Math.max(a1, a2) - Math.min(a1, a2);
                map2.remove(entry.getKey());
            } else {
                count += entry.getValue();
            }

            map1.remove(entry.getKey());
        }
        return count;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(a + b);
            } else if (tokens[i].equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(b - a);
            } else if (tokens[i].equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(a * b);
            } else if (tokens[i].equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(b / a);
            } else {
                stack.add(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }


    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int a = map.get(nums[i]);
                count += a;
                map.put(nums[i], a + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        return count;
    }

    public int minimumDeletions(int[] nums) {
        int max = 0, min = 0;
        for (int i = 1; i < nums.length; i++) {
            max = nums[i] > nums[max] ? i : max;
            min = nums[i] < nums[min] ? i : min;
        }
        int front = Math.max(max, min) + 1;
        int back = nums.length - Math.min(max, min);
        int both = Math.min(max, min) + 1 + nums.length - Math.max(min, max);
        return Math.min(both, Math.min(front, back));
    }

}

class Graph {

    private int[] ints;

    public Graph(int a) {
        this.ints = new int[a];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }
    }

    public int find(int x) {
        while (x != ints[x]) {
            x = ints[x];
        }
        return x;
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            ints[rootY] = rootX;
        }
    }

    public boolean isConnect(int x, int y) {
        return find(x) == find(y);
    }

    public int[] getInts() {
        return ints;
    }
}

class GraphQuickFind {
    private int[] root;

    public GraphQuickFind(int size) {
        this.root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        return root[x];
    }

    public void union(int x, int y) {
        root[x - 1] = y - 1;
    }

    public int findJudge() {
        System.out.println(Arrays.toString(root));
        int j = -1;
        for (int i = 1; i < root.length; i++) {
            if (root[i] == root[i - 1]) {
                return -1;
            }
            if (root[i] == i) {
                j = root[i] + 1;
            }
        }
        return j;
    }
}

class MyCircularDeque {
    private final Integer[] root;

    private int size;
    private int front;
    private int back;

    public MyCircularDeque(int k) {
        this.root = new Integer[k];
        size = 0;
    }

    public boolean insertFront(int value) {
        if (size == root.length) return false;
        if (front == root.length) front = 0;
        root[front] = value;
        front++;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (size == root.length) return false;
        root[back] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if(root[front]==null) return false;
        root[front] = null;
        if(front-1==-1){
            front = root.length-1;
        } else {
            front--;
        }
        size--;
        return true;
    }

    public boolean deleteLast() {
        if(root[back]==null) return false;
        root[back] = null;
        if(back+1==root.length){
            back = 0;
        } else {
            back++;
        }
        size--;
        return true;

    }

    public int getFront() {
        if (root[front] == null) {
            return -1;
        } else {
            return root[front];
        }
    }

    public int getRear() {
        System.out.println(Arrays.toString(root));
        if (root[back] == null) {
            return -1;
        } else {
            return root[back];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == root.length;
    }
}