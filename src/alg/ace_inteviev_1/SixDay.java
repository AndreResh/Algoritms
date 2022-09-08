package alg.ace_inteviev_1;

import alg.domains.Node;
import alg.domains.TreeNode;

import java.util.*;

public class SixDay {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }
    public void preOrder(Node node, List<Integer> list){

        if(node==null) return;
        list.add(node.val);
        List<Node> listNodes = node.children;
        for(int i = 0; i < listNodes.size(); i++){
            preOrder(listNodes.get(i), list);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return Collections.emptyList();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> listList = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left !=null){
                    queue.offer(node.left);
                }
                if(node.right !=null){
                    queue.offer(node.right);
                }
                list.add(node.val);
            }
            listList.add(list);
        }
        return listList;
    }
}
