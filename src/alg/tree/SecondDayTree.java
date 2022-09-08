package alg.tree;

import alg.domains.ListNode;
import alg.domains.TreeNode;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SecondDayTree {
    public static void main(String[] args) {

    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) return false;
        if(root.val==subRoot.val){
            if(isEqualsNodes(root, subRoot)) return true;
        }
        return  isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)  ;
    }
    private boolean isEqualsNodes(TreeNode node1, TreeNode node2){
        if(node1==null && node2==null) return true;
        if(node1==null || node2==null || node1.val!=node2.val) return false;
        return isEqualsNodes(node1.left, node2.left) && isEqualsNodes(node1.right, node2.right) ;

    }
    public TreeNode pruneTree(TreeNode root) {
return !isPruneTree(root)?null: root;
    }
    public boolean isPruneTree(TreeNode node){
        if(node.left==null && node.right==null){
            return node.val==1;
        }
        if(node.left!=null){
            if (!isPruneTree(node.left)) node.left=null;
        }
        if(node.right!=null){
            if (!isPruneTree(node.right)) node.right=null;
        }
        return (node.left!=null || node.right!=null || node.val==1);
    }


    public int goodNodes(TreeNode root) {

        return traverseGoodNodes(root, null);
    }

    private int traverseGoodNodes(TreeNode node, Integer max) {
        if(node==null) return 0;
        max = max==null?node.val:Math.max(node.val, max);
        int num = node.val>=max?1:0;
        num += traverseGoodNodes(node.left, max);
        num += traverseGoodNodes(node.right, max);
        return num;

    }

    int count = 0;
    public int kthsmallest(TreeNode A, int B) {
        if(A==null) return -1;
        if(A.left==null && A.right==null){
            count++;
            if(count==B) return A.val;
        }
        int current = -1;
        if(A.left!=null){
             current = kthsmallest(A.left, B);
        }
        if(current!=-1) return current;
        count++;
        if(count==B) return A.val;
        return kthsmallest(A.right, B);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        List<TreeNodeVertical> list = new ArrayList<>();
        inOrderTraversal(root, 0, 0, list);
        list.sort((Comparator
                .comparingInt(TreeNodeVertical::getColumn))
                .thenComparing(TreeNodeVertical::getRow)
                .thenComparing(TreeNodeVertical::getVal));
        int i = 0;
        while (i<list.size()){
            List<Integer> current = new ArrayList<>();
            int currentColum = list.get(i).getColumn();
            while (i<list.size() && currentColum==list.get(i).getColumn()){
                current.add(list.get(i++).getVal());
            }
            if(!current.isEmpty()) listList.add(current);
        }

        return listList;
    }

    private void inOrderTraversal(TreeNode root, int row, int column, List<TreeNodeVertical> list) {
        if (root == null) return;
        list.add(new TreeNodeVertical(row, column, root.val));
        inOrderTraversal(root.left, row + 1, column - 1, list);
        inOrderTraversal(root.right, row + 1, column + 1, list);
    }
    public TreeNode sortedListToBST(ListNode a) {
        return sortedListToBST(a, null);
    }
    public  TreeNode sortedListToBST(ListNode left, ListNode right){
        if(left==right) return null;
        ListNode slow = left;
        ListNode fast = left;
        while (fast!=right && fast.next!=right){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode treeNode = new TreeNode(slow.val);
        treeNode.left = sortedListToBST(left, slow);
        treeNode.right = sortedListToBST(slow.next, right);
        return treeNode;
    }
}
class TreeNodeVertical {
    private final int row;
    private final int column;
    private final int val;

    public TreeNodeVertical(int row, int column, int val) {
        this.row = row;
        this.column = column;
        this.val = val;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getVal() {
        return val;
    }

    @Override
    public String toString() {
        return "TreeNodeVertical{" +
                "row=" + row +
                ", column=" + column +
                ", val=" + val +
                '}';
    }
}