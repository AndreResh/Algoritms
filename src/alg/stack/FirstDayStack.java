package alg.stack;

import alg.domains.ListNode;
import alg.domains.TreeNode;
import alg.sliding_window.FistDaySlidingWindow;

import java.util.*;

public class FirstDayStack {
    public static void main(String[] args) {
//        ListNode node4 = new ListNode(4);
//        ListNode node3 = new ListNode(3, node4);
//        ListNode node2 = new ListNode(2, node3);
//        ListNode node1 = new ListNode(1, node2);
//
//        System.out.println(node1.next.next.next.next.next);
        System.out.println(0 - 2147483647);

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root!=null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;

        }
        return list;
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> mainStack = new Stack<>();
        mainStack.push(root);
        while (!mainStack.isEmpty()) {
            TreeNode node = mainStack.pop();
            if (node.right != null) {
                mainStack.push(node.right);

            }
            if (node.left != null) {
                mainStack.push(node.left);
            }
            if (!mainStack.isEmpty()) {
                node.left = null;
                node.right = mainStack.peek();
            }
        }
    }

    public String decodeString(String s) {
        Stack<String> strings = new Stack<>();
        Stack<Integer> integers = new Stack<>();
        int i = 0;
        StringBuilder result = new StringBuilder();
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                StringBuilder number = new StringBuilder();
                while (Character.isDigit(s.charAt(i))) {
                    number.append(s.charAt(i++));
                }
                integers.push(Integer.parseInt(number.toString()));
            } else if (s.charAt(i) == '[') {
                strings.push(result.toString());
                result = new StringBuilder();
                i++;
            } else if (s.charAt(i) == ']') {
                int count = integers.pop();
                StringBuilder builder = new StringBuilder(strings.pop());
                for (int j = 0; j < count; j++) {
                    builder.append(result);
                }
                result = builder;
                i++;
            } else {
                result.append(s.charAt(i++));
            }
        }
        return result.toString();
    }

    public int countCharacters(String[] words, String chars) {
        int[] main = new int[26];
        for (char ch : chars.toCharArray()) {
            main[ch - 'a']++;
        }
        int sum = 0;
        LOOP:
        for (String s : words) {
            int[] current = new int[26];
            for (char a : s.toCharArray()) {
                current[a - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (current[i] > main[i]) continue LOOP;
            }
            sum += s.length();
        }
        return sum;
    }

    public int rearrangeCharacters(String s, String target) {

        int[] main = new int[26];
        for (char ch : target.toCharArray()) {
            main[ch - 'a']++;
        }
        int[] notMain = new int[26];
        for (char ch : s.toCharArray()) {
            notMain[ch - 'a']++;
        }
        int count = 0;
        LOOP:
        while (true) {
            for (int i = 0; i < 26; i++) {
                if (notMain[i] >= main[i]) {
                    notMain[i] -= main[i];
                } else {
                    break LOOP;
                }
            }
            count++;
        }
        return count;
    }

    public int solve(String A) {
        Stack<Character> stack = new Stack<>();
        for (char ch : A.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return 0;
                stack.pop();
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public int evalRPN(ArrayList<String> A) {
        Set<String> characters = new HashSet<>(Arrays.asList("+", "-", "/", "*"));
        Stack<String> stack = new Stack<>();
        for (String s : A) {
            if (characters.contains(s)) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int result = 0;
                switch (s) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = b - a;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = b / a;
                        break;
                }
                stack.push(String.valueOf(result));
            } else {
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> resultList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.size(); i++) {
            while (!stack.isEmpty() && stack.peek() >= A.get(i)) {
                stack.pop();
            }
            resultList.add(stack.isEmpty() ? -1 : stack.peek());
            stack.push(A.get(i));
        }
        return resultList;
    }

    public int braces(String A) {
        Set<Character> set = new HashSet<>(Arrays.asList('*', '/', '+', '-'));
        Stack<Character> stack = new Stack<>();
        for (char ch : A.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.peek() == '(') {
                    return 1;
                }
                stack.pop();
                stack.pop();
            } else if (set.contains(ch)) {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.push(ch);
                }
            }
        }
        return 0;
    }


}
