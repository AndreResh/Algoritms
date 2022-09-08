package alg.algorithm;

import alg.domains.TreeNode;
import alg.domains.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EightDay {
    public static void main(String[] args) {

    }
//    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
//        if (root1 == null) {
//            return root2;
//        }
//        if (root2 == null) {
//            return root1;
//        }
//        root1.val+=root2.val;
//        root1.left=mergeTrees(root1.left, root2.left);
//        root1.right=mergeTrees(root1.right, root2.right);
//        return root1;
//    }
//    public Node connect(Node root) {
//
//        if(root.next!=null) {
//            root.left = connect(root.left);
//            root.right = connect(root.right);
//            root.left.next = root.right;
//            root.right.next=root.next;
//        }
//        return root;
//    }

//Merge Two Binary Trees
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
//        return  mergeOrderTrees(root1, root2);

        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

//    private TreeNode mergeOrderTrees(TreeNode root1, TreeNode root2) {
//        if (root1 == null && root2 == null) return null;
//        TreeNode node = new TreeNode();
//        if (root1 != null && root2 != null) {
//            node.val = root1.val + root2.val;
//            node.left = mergeOrderTrees(root1.left, root2.left);
//            node.right = mergeOrderTrees(root1.left, root2.left);
//        } else if (root1 != null) {
//            node.val = root1.val;
//            node.left = mergeOrderTrees(root1.left, null);
//            node.right = mergeTrees(root1.right, null);
//        } else {
//            node.val = root2.val;
//            node.left = mergeOrderTrees(root2.left, null);
//            node.right = mergeTrees(root2.right, null);
//        }
//        return node;
//    }

//    public Node connect(Node root) {
//        Map<Integer, List<Node>> map = new HashMap<>();
//        inOrderDepth(root, map, 0);
//        return root;
//    }
//
//    private void inOrderDepth(Node root, Map<Integer, List<Node>> map, int depth) {
//        List<Node> list;
//        if (root != null) {
//            if (!map.containsKey(depth)) {
//                list = new ArrayList<>();
//            } else {
//                list = map.get(depth);
//            }
//            root.next = null;
//            list.add(root);
//            if (list.size() > 1) {
//                list.get(list.size() - 2).next = root;
//            }
//            map.put(depth, list);
//            inOrderDepth(root.left, map, depth + 1);
//            inOrderDepth(root.right, map, depth + 1);
//        }
//    }

//    116. Populating Next Right Pointers in Eac
//    public Node connect(Node root) {
//        setNextAttr(root, null);
//
//        return root;
//    }

//    private void setNextAttr(Node root, Node rightNode){
//        if(root == null){
//            return;
//        }
//
//        // Set the right node
//        root.next = rightNode;
//
//        // Calculate the right node for the right child
//        Node temp = null;
//        if(root.next != null){
//            temp = root.next.left;
//        }
//
//        // Set next attribute for right child
//        setNextAttr(root.right, temp);
//
//        // Set next attribute for left child
//        setNextAttr(root.left, root.right);
//    }

}
