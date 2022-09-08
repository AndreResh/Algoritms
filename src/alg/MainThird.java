package alg;

import alg.domains.ListNode;
import alg.domains.Node;
import alg.domains.TreeNode;

import java.util.*;

public class MainThird {
    public static void main(String[] args) {
//        System.out.println(new MainThird().solveNQueens(4));
        System.out.println(new MainThird().subsets(new int[]{1, 2, 3}));
    }

    private List<List<String>> listList;

    public List<List<String>> solveNQueens(int n) {
        listList = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            builder.append(".");
        }
        for (int i = 0; i < n; i++) {
            stringList.add(builder.toString());
        }
        getNQueens(0, n, stringList);
        return listList;
    }

    private void getNQueens(int i, int queens, List<String> list) {
        if (i == list.size()) {
            if (queens == 0) {
                listList.add(new ArrayList<>(list));
            }
            return;
        }
        String str = list.get(i);
        for (int k = 0; k < str.length(); k++) {
            if (isNormalQueen(list, i, k)) {
                char[] chars = str.toCharArray();
                chars[k] = 'Q';
                list.set(i, String.valueOf(chars));
                getNQueens(i + 1, queens - 1, list);
                chars[k] = '.';
                list.set(i, String.valueOf(chars));
            }
        }
    }

    private boolean isNormalQueen(List<String> list, int i, int j) {
        for (int k = 0; k < list.size(); k++) {
            if (list.get(k).charAt(j) == 'Q') return false;
        }
        int k = i - 1;
        int l = j - 1;
        while (k >= 0 && l >= 0) {
            if (list.get(k).charAt(l) == 'Q') return false;
            k--;
            l--;
        }
        k = i - 1;
        l = j + 1;
        while (k >= 0 && l < list.get(k).length()) {
            if (list.get(k).charAt(l) == 'Q') return false;
            k--;
            l++;
        }
        return true;
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        List<ListNode> nodesLess = new ArrayList<>();
        List<ListNode> nodesMore = new ArrayList<>();
        while (head != null) {
            if (head.val < x) {
                nodesLess.add(head);
            } else {
                nodesMore.add(head);
            }
            head = head.next;
        }
        nodesLess.addAll(nodesMore);
        ListNode first = nodesLess.get(0);
        for (int i = 1; i < nodesLess.size(); i++) {
            nodesLess.get(i - 1).next = nodesLess.get(i);
        }
        nodesLess.get(nodesLess.size() - 1).next = null;
        return first;
    }

    List<List<Integer>> listListInteger;

    public List<List<Integer>> subsets(int[] nums) {
        listListInteger = new ArrayList<>();
        getAllSubSets(nums, 0, new LinkedList<>());
        return listListInteger;

    }

    private void getAllSubSets(int[] nums, int start, LinkedList<Integer> list) {
        listListInteger.add(new ArrayList<>(list));
        if (start == nums.length) {
            return;
        }
        for (int j = start; j < nums.length; j++) {
            list.add(nums[j]);
            getAllSubSets(nums, j + 1, list);
            list.removeLast();
        }
    }

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; i += 3) {
            if (nums[i] != nums[i - 2]) {
                return nums[i - 2];
            }
        }
        return nums[nums.length - 1];
    }

    static int countQueens;

    public int totalNQueens(int n) {
        countQueens = 0;
        int[][] ints = new int[n][n];
        for (int i = 0; i < ints.length; i++) {
            Arrays.fill(ints[i], -1);
        }
        getAllQueens(ints, 0, n);
        return countQueens;
    }

    private void getAllQueens(int[][] ints, int start, int queens) {
        if (queens == 0) {
            countQueens++;
            return;
        }
        for (int i = 0; i < ints[start].length; i++) {
            if (isNormalQueen(ints, start, i)) {
                ints[start][i] = 6;
                getAllQueens(ints, start + 1, queens - 1);
                ints[start][i] = -1;
            }
            System.out.println(Arrays.deepToString(ints));
        }
    }

    private boolean isNormalQueen(int[][] ints, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (ints[k][j] == 6) return false;
        }
        int k = i - 1;
        int l = j - 1;
        while (k >= 0 && l >= 0) {
            if (ints[k][l] == 6) return false;
            k--;
            l--;
        }
        k = i - 1;
        l = j + 1;
        while (k >= 0 && l < ints[0].length) {
            if (ints[k][l] == 6) return false;
            k--;
            l++;
        }
        return true;
    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> listList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> integerList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                integerList.add(node.val);
                queue.addAll(node.children);
            }
            listList.add(integerList);
        }
        return listList;
    }

    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    count++;
                    deleteBoards(board, i, j);
                    // System.out.println(Arrays.deepToString(board));
                }

            }

        }
        return count;
    }

    private void deleteBoards(char[][] board, int i, int j) {

        if (board[i][j] != 'X') return;
        board[i][j] = '.';
        if (j > 0) deleteBoards(board, i, j - 1);
        if (j < board[0].length - 1) deleteBoards(board, i, j + 1);
        if (i > 0) deleteBoards(board, i - 1, j);
        if (i < board.length - 1) deleteBoards(board, i + 1, j);
    }

    public int minMaxGame(int[] nums) {
        if (nums.length == 1) return nums[0];
        int l = getMin(nums, 0, nums.length / 2 - 1);
        int r = getMax(nums, nums.length / 2, nums.length);
        return Math.min(l, r);
    }

    private int getMax(int[] nums, int start, int end) {
        System.out.println(end);
        if (start == end - 1) {
            return Math.max(nums[start], nums[end]);
        }
        int l = getMin(nums, start, end / 2 - 1);
        int r = getMax(nums, end / 2, end);
        return Math.max(l, r);
    }

    private int getMin(int[] nums, int start, int end) {
        System.out.println(end);
        if (start == end - 1) {
            return Math.min(nums[start], nums[end]);
        }
        int l = getMin(nums, start, end / 2 - 1);
        int r = getMax(nums, end / 2, end);
        return Math.min(l, r);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<ListNode> listNodes1 = new ArrayList<>();
        List<ListNode> listNodes2 = new ArrayList<>();
        while (headA != null) {
            listNodes1.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            listNodes2.add(headB);
            headB = headB.next;
        }
        for (int i = listNodes1.size() - 1, j = listNodes2.size() - 1; i >= 0 && j >= 0; i--, j--) {
            if (listNodes1.get(i) == listNodes2.get(j)) {
                if (i == listNodes1.size() - 1) {
                    return null;
                } else {
                    return listNodes1.get(i);
                }
            }
        }
        if (listNodes1.size() < listNodes2.size()) {
            return listNodes1.get(0);
        } else {
            return listNodes2.get(0);
        }
    }

    public int search(int[] nums, int target) {
        int z = (nums.length + 1) / 2;
        while (z > 0 && z < nums.length - 1 && nums[z] > nums[z - 1]) {
            z++;
        }
        int leftMin = 0;
        int rightMin = z;
        int leftMax = z + 1;
        int rightMax = nums.length - 1;
        int a = binarySearch(nums, leftMin, rightMin, target);
        if (a == -1) {
            a = binarySearch(nums, leftMax, rightMax, target);
        }
        return a;

    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        int middle;
        while (left <= right) {
            middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }

    public int rob(TreeNode root) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        orderTree(root, 0, map);
        List<Integer> list = new LinkedList<>(map.values());
        if (list.size() == 1) return list.get(0);
        int[] ints = new int[list.size()];
        ints[0] = list.get(0);
        ints[1] = Math.max(ints[0], list.get(1));
        for (int i = 2; i < list.size(); i++) {
            ints[i] = Math.max(list.get(i) + ints[i - 2], ints[i - 1]);
        }

        return ints[ints.length - 1];
    }

    private void orderTree(TreeNode root, int depth, Map<Integer, Integer> map) {
        if (root == null) return;
        map.put(depth, map.getOrDefault(depth, 0) + root.val);
        orderTree(root.left, depth + 1, map);
        orderTree(root.right, depth + 1, map);
    }

    public int pairSum(ListNode head) {
        int i = 0;
        int size = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (head != null) {
            map.put(i++, head.val);
            size++;
            head = head.next;
        }
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < size; j++) {
            int twins = size-1-j;
            if(map.containsKey(twins)){
                max = Math.max(map.get(j)+map.get(twins), max);
            } else {
                break;
            }
        }
        return max;
    }

    public ListNode rotateRight(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        while (head!=null){
            list.add(head);
            head = head.next;
        }
        k %= list.size();
        Collections.reverse(list);
        rotateList(list, 0, k-1);
        rotateList(list, k, list.size()-1);
        for (int i = 1; i < list.size(); i++) {
            list.get(i-1).next = list.get(i);
        }
        list.get(list.size()-1).next = null;
        return list.get(0);
    }

    private void rotateList(List<ListNode> list, int start, int end) {
        while (start<end){
            ListNode a = list.get(start);
            list.set(start, list.get(end));
            list.set(end, a);
            start++;
            end--;

        }

    }


}

class Solution {

    private List<Integer> list;
    private Random random;

    public Solution(ListNode head) {
        random = new Random();
        list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

    }

    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}
