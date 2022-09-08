package alg.graph_theory_1;

import alg.domains.Node;

import java.util.*;

public class FirstDayGraph {
    public static void main(String[] args) {

    }

    //    public Node cloneGraph(Node node) {
//        Map<Integer, Node> map = new HashMap<>();
//        return cloneOfGraph(node, map);
//    }
//
//    private Node cloneOfGraph(Node node,  Map<Integer, Node> map) {
//        if(map.containsKey(node.val)) return node;
//        Node current = new Node(node.val);
//        List<Node> list = new ArrayList<>();
//        map.put(node.val, current);
//        for (Node node1: node.neighbors){
//            if(map.containsKey(node1.val)){
//                list.add(map.get(node1.val));
//            } else {
//                list.add(cloneOfGraph(node1, map));
//            }
//
//        }
//        current.neighbors = list;
//        return current;
//    }
    public void solve(char[][] board) {
        boolean[][] booleans = new boolean[board.length][board[0].length];
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                forNotChanged(board, 0, i, booleans);
            }
        }
        for (int i = 0; i < board[board.length - 1].length; i++) {
            if (board[board.length - 1][i] == 'O') {
                forNotChanged(board, board.length - 1, i, booleans);
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                forNotChanged(board, i, 0, booleans);
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][board[0].length - 1] == 'O') {
                forNotChanged(board, i, board[0].length - 1, booleans);
            }
        }
        System.out.println(Arrays.deepToString(booleans));
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    changeIt(board, i, j, booleans);
                }
            }
        }
    }

    private void changeIt(char[][] board, int i, int j, boolean[][] booleans) {
        if (booleans[i][j] || board[i][j] == 'X') return;
        board[i][j] = 'X';
        booleans[i][j] = true;
        if (i > 0) {
            forNotChanged(board, i - 1, j, booleans);
        }
        if (i < board.length - 1) {
            forNotChanged(board, i + 1, j, booleans);
        }
        if (j > 0) {
            forNotChanged(board, i, j - 1, booleans);
        }
        if (i < board[0].length - 1) {
            forNotChanged(board, i, j + 1, booleans);
        }
    }

    private void forNotChanged(char[][] board, int i, int j, boolean[][] booleans) {
        if (booleans[i][j] || board[i][j] == 'X') return;
        booleans[i][j] = true;
        if (i > 0) {
            forNotChanged(board, i - 1, j, booleans);
        }
        if (i < board.length - 1) {
            forNotChanged(board, i + 1, j, booleans);
        }
        if (j > 0) {
            forNotChanged(board, i, j - 1, booleans);
        }
        if (i < board[0].length - 1) {
            forNotChanged(board, i, j + 1, booleans);
        }
    }

    //    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//
//    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] booleans = new boolean[rooms.size()];
        visitRooms(rooms, 0, booleans);
        for (int i = 0; i < booleans.length; i++) {
            if (!booleans[i]) return false;
        }
        return true;
    }

    private void visitRooms(List<List<Integer>> rooms, int current, boolean[] booleans) {
        if (booleans[current]) return;
        booleans[current] = true;
        List<Integer> list = rooms.get(current);
        for (int i = 0; i < list.size(); i++) {
            visitRooms(rooms, list.get(i), booleans);
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> listList = new ArrayList<>();
        visitFromStartToEnd(graph, 0, listList, new ArrayList<Integer>());
        return listList;
    }

    private void visitFromStartToEnd(int[][] graph, int current, List<List<Integer>> listList, ArrayList<Integer> list) {
        list.add(current);
        if (current == graph.length - 1) {
            listList.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < graph[current].length; i++) {
            visitFromStartToEnd(graph, graph[current][i], listList, list);
            list.remove(list.size() - 1);
        }
    }

    public boolean isBipartite(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == graph.length - 1) return false;
        }
        return true;
    }

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }
        for (List<Integer> list : edges) {
            set.remove(list.get(1));
        }
        return new ArrayList<>(set);
    }

    public int maximalNetworkRank(int n, int[][] roads) {
        int[] counts = new int[n];
        int[][] graph = new int[n][n];
        for (int[] ints : roads) {
            counts[ints[0]]++;
            counts[ints[1]]++;
            graph[ints[0]][ints[1]] = 1;
            graph[ints[1]][ints[0]] = 1;
        }
        Arrays.stream(graph).forEach((o) -> System.out.println(Arrays.toString(o)));
        int max = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = i + 1; j < graph[i].length; j++) {
                max = Math.max(max, counts[i] + counts[j] - graph[i][j]);
            }
        }
        return max;
//        Map<Integer,Set<Integer>> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            map.put(i, new HashSet<>());
//        }
//
//        for (int i = 0; i < roads.length; i++) {
//            map.get(roads[i][0]).add(roads[i][1]);
//            map.get(roads[i][1]).add(roads[i][0]);
//        }
//        int max = 0;
//        for (int i = 0; i < n; i++) {
//            Set<Integer> fromI = map.get(i);
//            for (int j = i+1; j < n; j++) {
//                Set<Integer> fromJ = map.get(j);
//                int current;
//                if(fromJ.contains(i)){
//                    current = fromI.size()+ fromJ.size()-1;
//                } else {
//                    current = fromI.size()+fromJ.size();
//                }
//                max=Math.max(max, current);
//            }
//        }
//        return max;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < numCourses; i++) {
//            map.put(i, new ArrayList<>());
//        }
//        createGraph(prerequisites, 0, map);
//        boolean[] booleans = new boolean[numCourses];
//        int index = 0;
//        Set<Integer> seem = new HashSet<>();
//        for (boolean a : booleans) {
//            if (!a) {
//                canFinish(map, booleans, index, seem);
//            }
//            index++;
//        }
//        return seem.size()==numCourses;


        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new HashSet<>());
        }
        int[] needs = new int[numCourses];
        for (int[] ints : prerequisites) {
            map.get(ints[0]).add(ints[1]);
            needs[ints[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < needs.length; i++) {
            if (needs[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;
            for (int num : map.get(current)) {
                needs[num]--;
                if(needs[num]==0){
                    queue.offer(num);
                }
            }
        }
        return count == numCourses;
    }

    public void canFinish(Map<Integer, List<Integer>> map, boolean[] booleans, int index, Set<Integer> seem) {
        if (booleans[index]) return;
        booleans[index] = true;
        if (map.get(index).isEmpty()) {
            seem.add(index);
            return;
        }
        List<Integer> child = map.get(index);
        for (int i = 0; i < child.size(); i++) {
            canFinish(map, booleans, child.get(i), seem);
        }
        child.removeIf(seem::contains);
        if (child.isEmpty()) {
            seem.add(index);
        }
    }

    private void createGraph(int[][] prerequisites, int start, Map<Integer, List<Integer>> map) {
        if (start == prerequisites.length) return;
        map.get(prerequisites[start][0]).add(prerequisites[start][1]);
        createGraph(prerequisites, start + 1, map);
    }


}

class MyNode {
    public int val;
    public Set<MyNode> neighbors;

    public MyNode() {
        val = 0;
        neighbors = new HashSet<>();
    }

    public MyNode(int _val) {
        val = _val;
        neighbors = new HashSet<>();
    }

    public MyNode(int _val, HashSet<MyNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

}