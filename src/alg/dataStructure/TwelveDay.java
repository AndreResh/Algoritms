package alg.dataStructure;

import alg.domains.TreeNode;

public class TwelveDay {
    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        return invertRoot(root);
    }

    private TreeNode invertRoot(TreeNode root) {
        if(root!=null){
            TreeNode left = root.left;
            root.left = invertRoot(root.right);
            root.right = invertRoot(left);
        }
        return root;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        return isSumNormal(root, 0, targetSum);
    }

    private boolean isSumNormal(TreeNode root, int val, int targetSum) {
        if(root!=null){
            if (root.right==null && root.left==null){
                return root.val+val == targetSum;
            } else {
                return isSumNormal(root.right,  root.val+val , targetSum) || isSumNormal(root.left,  root.val+val , targetSum);
            }
        }
        return false;
    }
}
