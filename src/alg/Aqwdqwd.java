package alg;

import alg.domains.ListNode;
import alg.domains.TreeNode;

import java.util.*;

public class Aqwdqwd {
    public static void main(String[] args) {
        System.out.println(new Aqwdqwd().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int sum = 0;
        int i = 0;
        int j = people.length - 1;

        return boats;
    }

    static int k = 1;

    public int maxDepth(TreeNode root) {
        inOder(root, k);
        return k;
    }

    public void inOder(TreeNode treeNode, int max) {
        if (treeNode != null) {
            inOder(treeNode.left, max + 1);
            inOder(treeNode.right, max + 1);
        } else {
            if (max > k) {
                k = max;
            }
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean res = inOrderSame(p, q);
        return res;
    }

    private boolean inOrderSame(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            boolean a = inOrderSame(p.left, q.left);
            boolean b = inOrderSame(p.right, q.right);
            return a && b;
        } else if (q == null && p == null) {
            return true;
        } else {
            return false;
        }
    }

    static List<Integer> list;

    public int kthSmallest(TreeNode root, int k) {
        list = new ArrayList<>();
        inOrder(root);
        Collections.sort(list);
        return list.get(k - 1);
    }

    public void inOrder(TreeNode node) {
        if (node != null) {
            list.add(node.val);
            inOrder(node.left);
            inOrder(node.right);
        }
    }

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("C")) {
                stack.pop();
            } else if (ops[i].equals("D")) {
                stack.add(stack.peek() * 2);
            } else if (ops[i].equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(b);
                stack.add(a);
                stack.add(a + b);
            } else {
                stack.add(Integer.parseInt(ops[i]));
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    //[1,0,0,0,0,0,0,2,2]   8
    // 1,8,6,2,5,4,8,3,7    49
    public int maxArea(int[] height) {
        int indexL = 0;
        int indexR = 1;
        int water = Math.min(height[0], height[1]);
        ;
        for (int i = 2; i < height.length; i++) {
            int first = (i - indexL) * Math.min(height[indexL], height[i]);
            int second = (i - indexR) * Math.min(height[indexR], height[i]);
            System.out.println(first);
            System.out.println(second);
            if (first < water && second < water) {
            } else if (first > second) {
                indexR = i;
                water = first;
            } else {
                indexL = indexR;
                indexR = i;
                water = second;
            }
        }
        return water;
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int cur;
        for (int i = 1; i < prices.length; i++) {
            cur = prices[i] - prices[i - 1];
            if (cur > 0) {
                profit += cur;
            }
        }
        return profit;
    }


}
