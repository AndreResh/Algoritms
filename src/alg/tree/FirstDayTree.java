package alg.tree;

import alg.domains.ListNode;
import alg.domains.TreeNode;

import java.util.*;

public class FirstDayTree {
    Objects a;
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {

        return mathPathSum(root, 0, targetSum);
    }

    private boolean mathPathSum(TreeNode root, int current, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return current + root.val == targetSum;
        return mathPathSum(root.left, root.val + current, targetSum) || mathPathSum(root.right, root.val + current, targetSum);
    }

//    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//        List<List<Integer>> listList = new LinkedList<>();
//        mathPathSumOfBigList(root, listList, 0, new LinkedList<>(), targetSum);
//        return listList;
//    }
//
//    private void  mathPathSumOfBigList(TreeNode root, List<List<Integer>> listList, int currentSum, LinkedList<Integer> list, int targetSum) {
//        if(root==null) return;
//        list.add(root.val);
//        currentSum += root.val;
//        if(root.left==null && root.right==null){
//            if(currentSum==targetSum) {
//                listList.add(new ArrayList<>(list));
//            }
//            list.removeLast();
//            return;
//        }
//        mathPathSumOfBigList(root.left, listList, currentSum, list, targetSum);
//        mathPathSumOfBigList(root.right, listList, currentSum, list, targetSum);
//        list.removeLast();
//    }

    static int count;

    public int pathSum(TreeNode root, int targetSum) {
        count = 0;
        countPathSum(root, 0, targetSum, new LinkedList<Integer>());
        return count;
    }

    private void countPathSum(TreeNode root, int currentSum, int targetSum, LinkedList<Integer> list) {
        if (root == null) return;
        currentSum += root.val;
        list.add(root.val);

        LinkedList<Integer> linkedList = new LinkedList<>(list);
        int current = currentSum;
        while (linkedList.size() > 0) {
            if (current == targetSum) count++;
            current -= linkedList.removeFirst();
        }

        countPathSum(root.left, currentSum, targetSum, list);
        countPathSum(root.right, currentSum, targetSum, list);
        list.removeLast();
    }

    public int longestUnivaluePath(TreeNode root) {
        return getAllUnivaluePath(root, 0);
    }

    private int getAllUnivaluePath(TreeNode root, int number) {
        if (root == null) return number;
        int left;
        if (root.left != null && root.left.val == root.val) {
            left = getAllUnivaluePath(root.left, number + 1);
        } else {
            left = getAllUnivaluePath(root.left, 0);
        }
        int right;
        if (root.right != null && root.right.val == root.val) {
            right = getAllUnivaluePath(root.right, number + 1);
        } else {
            right = getAllUnivaluePath(root.right, 0);
        }
        return Math.max(number, Math.max(left, right));
    }

    public int diameterOfBinaryTree(TreeNode root) {

        int[] diameter = new int[1];

        diameterRec(root, diameter);

        return diameter[0];
    }

    private int diameterRec(TreeNode node, int[] diameter) {

        if (node == null) {

            return 0;
        }

        int leftHeight = diameterRec(node.left, diameter);
        int rightHeight = diameterRec(node.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (i == 0) {
                    list.add(current.val);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
            }
        }
        return list;
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode nodeLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode nodeRight = lowestCommonAncestor(root.right, p, q);
        if (nodeLeft != null && nodeRight != null) {
            return root;
        } else if (nodeLeft != null) {
            return nodeLeft;

        } else {
            return nodeRight;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return createTreeFromNums(nums, 0, nums.length - 1);
    }

    private TreeNode createTreeFromNums(int[] nums, int left, int right) {
        if (left > right) return null;
        int middle = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = createTreeFromNums(nums, left, middle - 1);
        node.right = createTreeFromNums(nums, middle + 1, right);
        return node;

    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        return createTreeFromList(head, last);
    }

    private TreeNode createTreeFromList(ListNode first, ListNode last) {
        if (first == null || last == null) return null;
        if (first == last) return new TreeNode(first.val);
        ListNode slow = first;
        ListNode fast = first;
        ListNode prev = null;
        while (fast.next != last.next && fast.next.next != last.next) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = createTreeFromList(first, prev);
        node.right = createTreeFromList(slow.next, last);
        return node;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    static int max;
    static int c;
    static Integer previous;

    public int[] findMode(TreeNode root) {
        max = 0;
        c = 1;
        previous = null;
        List<Integer> list = new ArrayList<>();
        inOrderTraverse(root, list);
        int[] ints = new int[list.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

    private void inOrderTraverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrderTraverse(root.left, list);
        if(previous!=null){
            if(previous==root.val){
                c++;
            } else {
                c = 1;
            }
        }
        if(c>max){
            max = c;
            list.clear();
            list.add(root.val);
        } else if (c==max) {
            list.add(root.val);
        }

        previous = root.val;
        inOrderTraverse(root.right, list);
    }


}

class BSTIterator {
    private Stack<Integer> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        fullStack(root);
    }

    private void fullStack(TreeNode root) {
        if (root == null) return;
        fullStack(root.right);
        stack.push(root.val);
        fullStack(root.left);
    }

    public int next() {
        return stack.pop();
    }

    public boolean hasNext() {
        return stack.isEmpty();
    }
}
