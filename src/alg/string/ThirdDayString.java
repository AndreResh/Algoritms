package alg.string;

import alg.domains.TreeNode;

import java.util.*;

public class ThirdDayString {
    public static void main(String[] args) {
//        System.out.println(new ThirdDayString().solve(new ArrayList<>(List.of(-533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322)), 369));
//        System.out.println(new ThirdDayString().reverse(" hello world "));
    }

    public String tree2str(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        tree2str(root, builder);
        return builder.substring(1, builder.length() - 2);
    }

    public void tree2str(TreeNode node, StringBuilder builder) {
        if (node == null) return;
        builder.append("(").append(node.val);
        if (node.left == null && node.right != null) {
            builder.append("()");
        }
        tree2str(node.left, builder);
        tree2str(node.right, builder);
        builder.append(")");
    }

    public int isPalindrome(String A) {
        char[] chars = A.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (!(Character.isAlphabetic(chars[left]) || Character.isDigit(chars[left]))) {
                left++;
            } else if (!(Character.isAlphabetic(chars[right]) || Character.isDigit(chars[right]))) {
                right--;
            } else if (Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])) {

                return 0;
            } else {
                left++;
                right--;
            }
        }
        return 1;
    }

    public int solve(String A) {
        Set<Character> set = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U'));
        int count = 0;
        for (int i = 0; i < A.length(); i++) {
            if (set.contains(Character.toUpperCase(A.charAt(i)))) {
                count += A.length() - i;
            }
        }
        return count % 10003;
    }

    public int solve(ArrayList<Integer> A, int B) {
//        Collections.sort(A);
//        int left = 0;
//        int right = A.size()-1;
//        while(left< right){
//            int current = A.get(right)-A.get(left);
//            System.out.println(current);
//            if(current==B){
//                return 1;
//            } else if(current<B){
//                left ++;
//            } else{
//                right--;
//            }
//        }
//        return 0;
        Set<Integer> set = new HashSet<>();
        for (Integer a : A) {
            int n1 = a - B;
            int n2 = a + B;
            if (set.contains(n2) || set.contains(n1)) return 1;
            set.add(a);
        }
        return 0;
    }

    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int i = 0;
        int j = 0;
        while (j < b.size()) {
            if (i == a.size()) break;
            if (a.get(i) > b.get(j)) {
                a.add(i, b.get(j));
                j++;
            }
            i++;
        }
        while (j < b.size()) {
            a.add(b.get(j));
            j++;
        }
    }

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        List<String> list = new ArrayList<>();
        int lastIndex = 0;
        for (int i = 1; i < indices.length; i++) {
            int j = i;
            int k = indices[i];
            String sour = sources[i];
            String targ = targets[i];
            while (j > 0 && indices[j - 1] > k) {
                indices[j] = indices[j - 1];
                sources[j] = sources[j - 1];
                targets[j] = targets[j - 1];
                j--;
            }
            indices[j] = k;
            sources[j] = sour;
            targets[j] = targ;
        }
        for (int i = 0; i < indices.length; i++) {
            list.add(s.substring(lastIndex, indices[i]));
            if (s.indexOf(sources[i], indices[i]) == indices[i]) {

                list.add(targets[i]);
                lastIndex = indices[i] + sources[i].length();
            } else {
                lastIndex = indices[i];
            }
        }
        if (lastIndex < s.length()) {
            list.add(s.substring(lastIndex));
        }
        return String.join("", list);
    }

    public String reverse(String A) {
        String[] strings = A.trim().split("\\s+");
        System.out.println(Arrays.toString(strings));
        int left = 0;
        int right = strings.length - 1;
        while (left < right) {
            String cur = strings[left];
            strings[left] = strings[right];
            strings[right] = cur;
            left++;
            right--;
        }
        return String.join(" ", strings);
    }


}
//"abcd"
//        [0, 2]
//        ["a", "cd"]
//        ["eee", "ffff"]
//        "abcd"
//        [0,2]
//        ["ab","ec"]
//        ["eee","ffff"]
//        "vmokgggqzp"
//        [3,5,1]
//        ["kg","ggq","mo"]
//        ["s","so","bfr"]