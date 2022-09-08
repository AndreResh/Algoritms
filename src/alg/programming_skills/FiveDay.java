package alg.programming_skills;

import alg.domains.Node;

import java.util.*;

public class FiveDay {
    public static void main(String[] args) {

    }

    public List<Integer> preorder(Node root) {
        if (root == null) return Collections.emptyList();
        List<Integer> list = new ArrayList<>();
        getPreorderNodes(root, list);
        return list;
    }

    private void getPreorderNodes(Node root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            List<Node> nodeList = root.children;
            for (int i = 0; i < nodeList.size(); i++) {
                getPreorderNodes(nodeList.get(i), list);
            }
        }
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            if (stack.isEmpty()) {
                stack.add(nums2[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                    map.put(stack.pop(), nums2[i]);
                }
                stack.add(nums2[i]);
            }
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        int[] ints = new int[nums1.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = map.get(nums1[i]);
        }
        return ints;
    }

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length < 3) return true;
        for (int i = 2; i < coordinates.length; i++) {
            int x1 = (coordinates[i - 2][0] - coordinates[i - 1][0]);
            int x2 = (coordinates[i][0] - coordinates[i - 1][0]);
            int y1 = (coordinates[i - 2][1] - coordinates[i - 1][1]);
            int y2 = (coordinates[i][1] - coordinates[i - 1][1]);
            if (x1 * y2 != y1 * x2) return false;
        }
        return true;
    }
}
