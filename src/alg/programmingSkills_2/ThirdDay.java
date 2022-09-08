package alg.programmingSkills_2;

import alg.domains.ListNode;
import alg.domains.TreeNode;

import java.util.*;

public class ThirdDay {
    public boolean isSubPath(ListNode head, TreeNode root) {
         return inOrder(root, head);
    }

    private boolean isContainPath(TreeNode node, ListNode head) {
        if(head==null) return true;
        if(node==null || node.val!=head.val) return false;
        return isContainPath(node.right, head.next) || isContainPath(node.left, head.next);
    }

    private boolean inOrder(TreeNode root, ListNode head) {
        if(root==null) return false;
        if(isContainPath(root, head)) return true;
        return inOrder(root.left, head) || inOrder(root.right, head);
    }
}
