package alg.dataStructure;

import alg.domains.TreeNode;

public class ThirteenthDay {
    public static void main(String[] args) {

    }

    public TreeNode searchBST(TreeNode root, int val) {
        return searchTree(root, val);
    }

    private TreeNode searchTree(TreeNode root, int val) {
        if (root != null) {
            if (root.val == val) return root;
            if (root.val > val) return searchTree(root.left, val);
            return searchTree(root.right, val);
        }
        return null;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode main = root;
        while (true) {
            if (root.val > val) {
                if (root.left == null) {
                    root.left = new TreeNode(val);
                    break;
                }
                root = root.left;
            } else {
                if (root.right == null) {
                    root.right = new TreeNode(val);
                    break;
                }
                root = root.right;
            }
        }
        return main;
    }
}
