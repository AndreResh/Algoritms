package alg.dataStructure;

import alg.domains.TreeNode;

import java.util.*;

public class EleventhDay {
    //    [3,9,20,null,null,15,7]
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
//        System.out.println(new EleventhDay().levelOrder(root));


    }

    static List<List<Integer>> listList;
    static Map<Integer, List<Integer>> map;

    public List<List<Integer>> levelOrder(TreeNode root) {
//        if (root == null) return Collections.emptyList();
//        listList = new ArrayList<>();
//        map = new TreeMap<>();
//        levelRoot(root, 0);
//        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
//            listList.add(entry.getValue());
//        }
//        return listList;


        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (que.size() != 0) {
            int size = que.size();
            List<Integer> temp = new ArrayList<>();
            while (size > 0) {
                TreeNode rem = que.remove();
                if (rem == null) {
                    continue;
                }
                temp.add(rem.val);
                if (rem.left != null) {
                    que.add(rem.left);
                }
                if (rem.right != null) {
                    que.add(rem.right);
                }
                size--;
            }
            ans.add(temp);
        }
        return ans;
    }

    private void levelRoot(TreeNode root, int depth) {
        if (root != null) {
            levelRoot(root.left, depth + 1);
            levelRoot(root.right, depth + 1);
            if (map.get(depth) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                map.put(depth, list);
            } else {
                List<Integer> list = map.get(depth);
                list.add(root.val);
                map.put(depth, list);
            }

        }
    }


    public int maxDepth(TreeNode root) {
        return maxDepthOrder(root, 0);
    }

    private int maxDepthOrder(TreeNode root, int i) {
        if (root != null) {
            int a = maxDepthOrder(root.left, i + 1);
            int b = maxDepthOrder(root.right, i + 1);
            return Math.max(a, b);
        }
        return i;
    }


    public boolean isSymmetric(TreeNode root) {
        return (isSymmetricRoot(root.left, root.right));
    }

    private boolean isSymmetricRoot(TreeNode rootLeft, TreeNode rootRight) {
        if (rootLeft == null && rootRight == null) {
            return true;
        }
        if ((rootLeft != null && rootRight == null) || (rootLeft == null && rootRight != null)) {
            return false;
        }
        boolean isNormalNumbers = false;
        if (rootLeft.val == rootRight.val) {
            isNormalNumbers = true;
        }
        return isNormalNumbers && isSymmetricRoot(rootLeft.left, rootRight.right) && isSymmetricRoot(rootLeft.right, rootRight.left);
    }
}
