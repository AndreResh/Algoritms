package alg.ace_inteviev_1;

import alg.domains.TreeNode;

import java.math.BigInteger;

public class EightDay {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {

            return lowestCommonAncestor(root.left, p, q);

        } else if (p.val > root.val && q.val > root.val) {

            return lowestCommonAncestor(root.right, p, q);

        } else {
            return root;
        }
    }




}
