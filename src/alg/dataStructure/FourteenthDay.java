package alg.dataStructure;

import alg.domains.TreeNode;

import java.util.*;

public class FourteenthDay {
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val <= root.val && q.val >= root.val || p.val >= root.val && q.val <= root.val) {
            return root;
        } else if (p.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    static Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        return isFindTarget(root, k);
    }

    private boolean isFindTarget(TreeNode node, int val) {
        System.out.println(set);
        if (node != null) {
            if (set.contains(node.val)) return true;
            set.add(val - node.val);
            return isFindTarget(node.left, val) || isFindTarget(node.right, val);
        }
        return false;
    }


    public boolean isValidBST(TreeNode root) {
        return isValid(root,null,null);
    }
    private boolean isValid(TreeNode node,Integer min, Integer max){
        if(node==null) return true;
        if((min!=null && min>=node.val) || (max!=null && max<=node.val)){
            return false;
        }
        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }
}
