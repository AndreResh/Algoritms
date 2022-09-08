package alg.programming_skills;

import alg.domains.TreeNode;

public class TenDay {
    public static void main(String[] args) {

    }

    public int sumOfLeftLeaves(TreeNode root) {
        return sumLeftLeaves(root, false);
    }

    private int sumLeftLeaves(TreeNode root, boolean isLeft) {
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null && isLeft) return root.val;
        if(root.left==null && root.right==null && !isLeft) return 0;
        int l = sumLeftLeaves(root.left, true);
        int r = sumLeftLeaves(root.right, false);
        return r+l;
    }
}
