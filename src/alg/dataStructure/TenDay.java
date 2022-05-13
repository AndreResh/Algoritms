package alg.dataStructure;

import alg.domains.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TenDay {
    public static void main(String[] args) {

    }

    static List<Integer> preOrderList;

    public List<Integer> preorderTraversal(TreeNode root) {
        preOrderList = new ArrayList<>();
        preOrder(root);
        return preOrderList;
    }

    private void preOrder(TreeNode node) {
        if (node != null) {
            preOrderList.add(node.val);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    static List<Integer> inOrderList;

    public List<Integer> inorderTraversal(TreeNode root) {
        inOrderList = new ArrayList<>();
        inOrder(root);
        return inOrderList;
    }

    private void inOrder(TreeNode node) {
        if (node != null) {
            preOrder(node.left);
            inOrderList.add(node.val);
            preOrder(node.right);
        }
    }

    static List<Integer> postOrderList;

    public List<Integer> postorderTraversal(TreeNode root) {
        postOrderList = new ArrayList<>();
        postOrder(root);
        return postOrderList;
    }

    private void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            postOrderList.add(node.val);
        }
    }
}
