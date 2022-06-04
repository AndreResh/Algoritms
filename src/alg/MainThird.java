package alg;

import alg.domains.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
        for (int i = 2; i < nums.length; i+= 3) {
            if (nums[i] != nums[i - 2]){
                return nums[i-2];
            }
        }
        return nums[nums.length-1];
    }
}
