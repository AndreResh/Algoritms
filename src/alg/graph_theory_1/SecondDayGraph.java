package alg.graph_theory_1;

import alg.domains.TreeNode;

import java.util.*;

public class SecondDayGraph {
    public static void main(String[] args) {
        System.out.println(Math.pow(2, 12));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new HashSet<>());
        }
        int[] needs = new int[numCourses];
        for (int[] ints : prerequisites) {
            map.get(ints[0]).add(ints[1]);
            needs[ints[1]]++;
        }
        int[] result = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < needs.length; i++) {
            if (needs[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            result[count++] = num;
            for (int a : map.get(num)) {
                needs[a]--;
                if (needs[a] == 0) {
                    queue.offer(a);
                }
            }

        }
        return count == numCourses ? result : new int[]{};
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[i].length; j++) {
                if (grid2[i][j] == 1) {
                    if (isSubIsland(grid1, grid2, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean isSubIsland(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || i == grid2.length || j < 0 || j == grid2[0].length) return true;
        if (grid2[i][j] == 0) return true;
        boolean current = false;
        if (grid1[i][j] == grid2[i][j] && grid2[i][j] == 1) {
            current = true;
        }
        grid2[i][j] = 0;
        boolean f1 = isSubIsland(grid1, grid2, i - 1, j);
        boolean f2 = isSubIsland(grid1, grid2, i + 1, j);
        boolean f3 = isSubIsland(grid1, grid2, i, j - 1);
        boolean f4 = isSubIsland(grid1, grid2, i, j + 1);
        return current && f1 && f2 && f3 && f4;
    }

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length);
        for (int[] a : edges) {
            if (unionFind.union(a[0] - 1, a[1] - 1)) {
                return a;
            }
        }
        return new int[]{};
    }


    public List<Integer> eventualSafeNodes(int[][] graph) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            map.put(i, new HashSet<>());
        }
        int[] deep = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                map.get(i).add(graph[i][j]);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < deep.length; i++) {
            if (deep[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        int count = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;
            list.add(current);
            for (int a : map.get(current)) {
                deep[a]--;
                if (deep[a] == 0) {
                    queue.add(a);
                }
            }
        }
        return list;
    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> seem = new HashSet<>();
        for (ArrayList<Integer> list : B) {
            List<Integer> current = map.getOrDefault(list.get(0), new ArrayList<>());
            current.add(list.get(1));
            map.put(list.get(0), current);
        }
        return isPathExistGraph(map, 1, A, seem) ? 1 : 0;
    }

    private boolean isPathExistGraph(Map<Integer, List<Integer>> map, int current, int value, Set<Integer> seem) {
        if (!map.containsKey(current) || seem.contains(current)) return false;
        seem.add(current);
        List<Integer> list = map.get(current);
        for (Integer a : list) {
            if (a == value) return true;
            if (isPathExistGraph(map, a, value, seem)) return true;
        }
        return false;
    }

    public int solve(ArrayList<ArrayList<Integer>> A) {
        A.sort(Comparator.comparingInt(o -> o.get(1)));
        int count = 1;
        int last = A.get(0).get(1);
        for (List<Integer> list : A) {
            if (list.get(0) > last) {
                count++;
                last = list.get(1);
            }
        }
        return count;
    }

    int count = 0;

    public int solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B, int C) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= A.size(); i++) {
            map.put(i, new ArrayList<>());
        }
        for (ArrayList<Integer> list : B) {
            List<Integer> current = map.get(list.get(0));
            current.add(list.get(1));
            map.put(list.get(0), current);
            List<Integer> current2 = map.get(list.get(1));
            current2.add(list.get(0));
            map.put(list.get(1), current2);
        }
        boolean[] booleans = new boolean[A.size()];
        countGoodNodes(map, A, 1, A.get(0), C, booleans);
        return count;
    }

    private void countGoodNodes(
            Map<Integer, List<Integer>> map,
            ArrayList<Integer> list,
            int currentNumber,
            int currentCount,
            int maxCount,
            boolean[] booleans
    ) {
        if (booleans[currentNumber - 1]) return;
        List<Integer> children = map.get(currentNumber);
        if (children.size() == 1) {
            if (currentCount <= maxCount) {
                count++;
            }
            return;
        }
        booleans[currentNumber - 1] = true;
        for (Integer num : children) {
            countGoodNodes(map, list, num, list.get(num - 1) + currentCount, maxCount, booleans);
        }
    }



//[3,9,20,null,null,15,7]
//        [1,2,3,4,5,6,7]
//        [3,1,4,0,2,2]
}



class Graph {
    int value;
    List<Graph> children;

    public Graph(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }
}

class MyCalendar {
    TreeMap<Integer, Integer> calendar;

    MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}

class UnionFind {
    private int[] root;
    private int[] rank;

    UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (x == root[x])
            return x;
        return find(root[x]);
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return true;
        if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            root[rootX] = rootY;
        } else {
            root[rootY] = rootX;
            rank[rootX] += 1;
        }
        return false;
    }
}