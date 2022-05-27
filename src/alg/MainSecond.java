package alg;

import alg.domains.TreeNode;

import java.util.*;

public class MainSecond {
    public static void main(String[] args) {

    }
    public List<Integer> largestValues(TreeNode root) {
        if(root==null) return Collections.emptyList();
        List<Integer> mainList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<TreeNode> nodeList = new ArrayList<>();
            while (!queue.isEmpty()){
                nodeList.add(queue.poll());
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nodeList.size(); i++) {
                if(nodeList.get(i).left!=null){
                    queue.add(nodeList.get(i).left);
                }
                if(nodeList.get(i).right!=null){
                    queue.add(nodeList.get(i).right);
                }
                if(nodeList.get(i).val>max){
                    max = nodeList.get(i).val;
                }
            }
            mainList.add(max);
        }
        return mainList;
    }
    public int numberOfSteps(int num) {
        int count = 0;
        while (num!=0){
            if(num%2==0){
                num /= 2;
            } else {
                num --;
            }
            count++;
        }
        return count;
    }
}
