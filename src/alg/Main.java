package alg;

import alg.domains.ListNode;
import alg.domains.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        ListNode node11 = new ListNode(4);
//        ListNode node10 = new ListNode(3, node11);
//        ListNode node9 = new ListNode(1, node10);
//        ListNode node7 = new ListNode(4);
//        ListNode node6 = new ListNode(3, node7);
//        ListNode node5 = new ListNode(1, node6);
//        ListNode node4 = new ListNode(3);
//        ListNode node3 = new ListNode(1, node4);
//        ListNode node2 = new ListNode(7, node3);
//        ListNode node1 = new ListNode(4, node2);
//        ListNode node = new Main().sortList(node1);
//        while (node != null) {
//            System.out.println(node.val);
//            node = node.next;
//        }
//        System.out.println(36 % 24);
//        Scanner scanner = new Scanner(System.in);
//        int time = scanner.nextInt();
//        int hour = time / 3600 % 24;
//        int min = time / 60 % 60;
//        int sec = time % 60;
//        System.out.println(time * 3600);
//        System.out.println(hour);
//        System.out.println(sec);
//        System.out.println(String.format("%02d:%02d:%02d", hour, min, sec));
//        new Main().merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
//        System.out.println(new Main().minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        long f = (long) (Math.pow(2, ((a-1)/2))+ Math.pow(2, ((a-3)/2)));//   2**((n-1)/2)+2**((n-2)/2)
//        System.out.println(fib(a));
//        System.out.println(new Main().canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(new Main().generateParenthesis(6));

    }
//6
//int s[] =  {1, 3, 0, 5, 8, 5};
//    int f[] =  {2, 4, 6, 7, 9, 9};

    public static long fib(long n) {
        long[] arr = new long[(int) (n + 1)];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];

        }
        System.out.println(arr[(int) n]);
        System.out.println(arr[(int) (n - 1)]);
        System.out.println(arr[(int) (n - 2)]);
        return arr[(int) n] % 10;
    }


    //    public ListNode deleteDuplicates(ListNode head) {
//        if(head==null) return null ;
//        ListNode first = null;
//        ListNode main=null ;
//        int currentVal = head.val;
//        while (head != null) {
//            if(head.next!=null){
//                if(head.next.val!=currentVal){
//                    if(first==null){
//                        first=new ListNode(head.val);
//                        main=first;
//                    } else {
//                        first.next=new ListNode(head.val);
//                        first=first.next;
//                    }
//                    currentVal=head.next.val;
//                    head=head.next;
//                } else {
//                    while (head!=null && head.val==currentVal){
//                        head=head.next;
//                    }
//                    if(head!=null) {
//                        currentVal = head.val;
//                    }
//                }
//            } else {
//                if(first==null){
//                    first=new ListNode(head.val);
//                    main=first;
//                } else {
//                    first.next=new ListNode(head.val);
//                    first=first.next;
//                }
//                break;
//            }
//        }
//
//        return main;
//
//    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        int size = lists.length;
        int sizeFirst;
        int sizeSecond;
        if (size % 2 == 0) {
            sizeFirst = size / 2;
            sizeSecond = size / 2;
        } else {
            sizeFirst = size / 2;
            sizeSecond = size / 2 + 1;
        }
        ListNode[] first = new ListNode[sizeFirst];
        ListNode[] second = new ListNode[sizeSecond];
        int k = 0;
        for (int i = 0; i < first.length; i++) {
            first[i] = lists[k++];
        }

        for (int i = 0; i < second.length; i++) {
            second[i] = lists[k++];
        }
        return mergeTwoLists(mergeKLists(first), mergeKLists(second));
    }

    private ListNode mergeTwoLists(ListNode list, ListNode list1) {
        ListNode node = new ListNode();
        ListNode first = node;
        int min;
        while (list != null && list1 != null) {
            if (list.val < list1.val) {
                min = list.val;
                list = list.next;
            } else {
                min = list1.val;
                list1 = list1.next;
            }

            node.next = new ListNode(min);
            node = node.next;

        }
        while (list != null) {
            node.next = new ListNode(list.val);
            node = node.next;
            list = list.next;
        }
        while (list1 != null) {
            node.next = new ListNode(list1.val);
            node = node.next;
            list1 = list1.next;
        }
        return first.next;
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        if (list.size() == 0) return null;
        Collections.sort(list);
        ListNode node = new ListNode(list.get(0));
        ListNode first = node;
        for (int i = 1; i < list.size(); i++) {
            node.next = new ListNode(list.get(i));
            node = node.next;
        }
        return first;
    }

    public int[] beautifulArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        return a;
    }

    public int countGoodSubstrings(String s) {
        int count = 0;
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1) && s.charAt(i) != s.charAt(i - 2) && s.charAt(i - 1) != s.charAt(i - 2)) {
                count++;
            }
        }
        return count;
    }

    public int maxDepth(TreeNode root) {
        int k = 1;
        return inOder(root, k);
    }

    public int inOder(TreeNode treeNode, int max) {
        System.out.println(max);
        if (treeNode != null) {
            int a = inOder(treeNode.left, max + 1);
            int b = inOder(treeNode.right, max + 1);
            return Math.max(a, b);
        } else {
            return max;
        }
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        int[] numsChern = Arrays.copyOf(nums1, nums1.length);
        int i = 0;
        int j = 0;
        int k = 0;
        while (m > 0 && n > 0) {
            if (numsChern[i] < nums2[j]) {
                System.out.println(numsChern[i]);
                nums1[k++] = numsChern[i++];
                m--;
            } else {
                System.out.println(numsChern[j]);
                nums1[k++] = nums2[j++];
                n--;
            }
        }
//        System.out.println(m+" "+i);
//        System.out.println(n+" "+j);
        while (m > 0) {
            nums1[k++] = numsChern[i++];
            m--;
        }
        while (n > 0) {
            nums1[k++] = nums2[j++];
            n--;
        }
        System.out.println(Arrays.toString(nums1));
    }

    public int climbStairs(int n) {
        int[] ints = new int[n + 1];
        ints[0] = 0;
        ints[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            ints[i] = ints[i - 1] + ints[i - 2];
        }
        System.out.println(Arrays.toString(ints));
        return ints[ints.length - 1];
    }

    public int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            if (2 <= 2 * i && 2 * i <= n) {
                arr[2 * i] = arr[i];
                max = Math.max(max, arr[2 * i]);
            }
            if (2 <= 2 * i + 1 && 2 * i + 1 <= n) {
                arr[2 * i + 1] = arr[i] + arr[i + 1];
                max = Math.max(max, arr[2 * i + 1]);
            }
        }
        return max;
    }

    public int minCostClimbingStairs(int[] cost) {
        int sum = 0;
        for (int i = cost.length - 1; i >= 0; i -= 2) {
            try {
                sum += Math.min(cost[i - 1], cost[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
        return sum;
    }

    static TreeNode node;

    public TreeNode increasingBST(TreeNode root) {
        node = new TreeNode();
        TreeNode first = node;
        inOrder(root);
        return first.right;
    }

    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            node.right = root;
            node = node.right;
            inOrder(root.right);
        }
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = Math.min(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i += 2) {
            sum += Math.min(nums[i], nums[i + 1]);
        }
        return sum;
    }

    public int[] diStringMatch(String s) {
        int[] ints = new int[s.length() + 1];
        int countI = 0;
        int countD = s.length();
        for (int i = 0; i < ints.length - 1; i++) {
            if (s.charAt(i) == 'I') {
                ints[i] = countI++;
            } else {
                ints[i] = countD--;
            }
        }
        ints[ints.length - 1] = countD;
        return ints;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int start = 0;
        int length = gas.length;
        int current = 0;
        for (int i = 0; i < length; i++) {
            sum += gas[i] - cost[i];
            current += gas[i] - cost[i];
            if (current < 0) {
                start++;
                current = 0;
            }
        }
        return sum < 0 ? -1 : start;
    }

    //    public int longestPalindrome(String s) {
//        int[] chars = s.toCharArray();
//        Arrays.sort(chars);
//        System.out.println(Arrays.toString(chars));
//        int count = 1;
//        int current = chars[0];
//        boolean hasUniq = false;
//        int result = 0;
//        for (int i = 1; i < chars.length; i++) {
//            if (chars[i] == current) {
//                count++;
//                if (count == 2) {
//                    result += count;
//                }
//            } else {
//                if (count == 1) {
//                    hasUniq = true;
//                } else {
//                    result += count - 1;
//                }
//                count = 1;
//                current = chars[i];
//            }
//            System.out.println((char) current);
//        }
//        if (s.length()%2==0 || hasUniq) {
//            return result + 1;
//        } else {
//            return result;
//        }
//    }
    public int largestPerimeter(int[] nums) {
        int sum = nums[0] + nums[1];
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 2; i < nums.length; i++) {
            if (sum <= nums[i]) {
                return 0;
            }
            sum += nums[i];
        }
        return sum;
    }

    static List<Integer> list;

    public int kthSmallest(TreeNode root, int k) {
        list = new ArrayList<>();
        inBTS(root);
        return list.get(k - 1);
    }

    private void inBTS(TreeNode node) {
        if (node == null) return;
        inBTS(node.left);
        list.add(node.val);
        inBTS(node.right);
    }

    public int[] sortArrayByParity(int[] nums) {
        int[] ints = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[left] % 2 == 0) {
                ints[left++] = nums[i];
            } else {
                ints[right--] = nums[i];
            }
        }
        return ints;
    }

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int sum;
        int count = 0;
        while (left < right) {
            sum = nums[left] + nums[right];
            if (sum == k) {
                count++;
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }

        }
        return count;
    }

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!stackS.isEmpty()) stackS.pop();
            } else {
                stackS.add(s.charAt(i));
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                if (!stackT.isEmpty()) stackT.pop();
            } else {
                stackT.add(t.charAt(i));
            }
        }
        if (stackT.size() != stackS.size()) return false;
        while (!stackS.isEmpty()) {
            if (stackS.pop() != stackT.pop()) {
                return false;
            }
        }
        return true;
    }

    public int findUnsortedSubarray(int[] nums) {
        int[] cope = Arrays.copyOf(nums, nums.length);
        Arrays.sort(cope);
        int left = 0;
        int right = nums.length - 1;
        boolean isChangeLeft = false;
        boolean isChangeRight = false;
        while (left < right) {
            if (cope[left] == nums[left]) {
                left++;
            } else {
                isChangeLeft = true;
            }
            if (cope[right] == nums[right]) {
                right--;
            } else {
                isChangeRight = true;
            }
            if (isChangeLeft && isChangeRight) {
                return right - left + 1;
            }
        }
        return 0;
    }

    public String removeDuplicates(String s, int k) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        Stack<Character> stack = new Stack<>();
        int count = 1;
        stack.add(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
                stack.add(chars[i]);
            } else {
                count = 1;
                stack.add(chars[i]);
            }
            if (count == k) {
                int z = k;
                while (z > 1) {
                    stack.pop();
                    z--;
                }
            }
        }
        return stack.stream().map(Objects::toString).collect(Collectors.joining());
    }

    static List<String> stringList;

    public List<String> binaryTreePaths(TreeNode root) {
        stringList = new ArrayList<>();
        getStrings(root, String.valueOf(root.val));
        return stringList;
    }

    private void getStrings(TreeNode root, String s) {
        if (root != null) {
            if (s.length() > 0) {
                s += "->" + root.val;
            } else {
                s = String.valueOf(root.val);
            }
            if (root.left == null && root.right == null) {
                stringList.add(s);
            }
            getStrings(root.left, s);

            getStrings(root.right, s);

        }
    }

    public String longestCommonPrefix(String[] strs) {
        String current = strs[0];
        for (int i = 1; i < strs.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < strs[i].length(); j++) {
                if (current.charAt(i) == strs[i].charAt(i)) {
                    builder.append(current.charAt(i));
                } else {
                    break;
                }
            }
            if (builder.length() > 0) {
                current = builder.toString();
            } else {
                return "";
            }
        }
        return current;
    }

    List<String> strings;

    public List<String> generateParenthesis(int n) {
        strings = new ArrayList<>();
        generateString("(", n - 1, n);
        return strings;
    }

    private void generateString(String s, int countOpen, int countClose) {
        if (countOpen == 0 && countClose == 1) {
            s += ')';
            strings.add(s);
            return;
        }
        String s1 = s + '(';
        String s2 = s + ')';
        if (countOpen != countClose) {
            generateString(s2, countOpen, countClose - 1);
        }
        if (countOpen > 0) {
            generateString(s1, countOpen - 1, countClose);
        }
    }

    private TreeNode main;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        inOrderCopy(original, cloned, target);
        return main;

    }

    private void inOrderCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original != null && cloned != null) {
            if (cloned.val == original.val && original.val == target.val) {
                main = cloned;
                return;
            }
            ;
            inOrderCopy(original.left, cloned.left, target);
            inOrderCopy(original.right, cloned.right, target);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return Collections.emptyList();
        int ch = 0;
        int index;
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 2; i < 10; i++) {
            if (i == 7 || i == 9) {
                index = 4;
            } else {
                index = 3;
            }
            List<Character> list = new ArrayList<>();
            for (int j = 0; j < index; j++) {
                list.add((char) ('a' + ch++));
            }
            map.put(i, list);
        }
        System.out.println(map);
        List<String> stringList = new ArrayList<>();
        getAllCombinations(map, stringList, digits, 0, new StringBuilder());
        return stringList;
    }

    private void getAllCombinations(Map<Integer, List<Character>> map, List<String> stringList, String digits, int start, StringBuilder stringBuilder) {
        System.out.println(stringBuilder);
        if (start > digits.length() - 1) {
            stringList.add(stringBuilder.toString());
            return;
        }
        for (int i = start; i < map.get(Character.getNumericValue(digits.charAt(start))).size(); i++) {
            stringBuilder.append(map.get(Character.getNumericValue(digits.charAt(start))).get(i));
            getAllCombinations(map, stringList, digits, start + 1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listList = new ArrayList<>();
        getAllCombinationsSum(listList, candidates, new ArrayList<>(), target, 0, 0);
        return listList;
    }

    private void getAllCombinationsSum(List<List<Integer>> listList, int[] candidates, List<Integer> list, int target, int start, int sum) {
        if (sum == target) {
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) < list.get(i - 1)) {
                    return;
                }
            }
            listList.add(new ArrayList<>(list));
            return;
        } else if (sum > target) {
            return;
        }
        if (list.size() > 0) {
            start = list.get(list.size() - 1);
        }
        for (int j = start; j < candidates.length; j++) {
            if (list.size() > 0 && candidates[j] < list.get(list.size() - 1)) {
                list.remove(list.size() - 1);
                return;
            }
            list.add(candidates[j]);
            sum += candidates[j];
            getAllCombinationsSum(listList, candidates, list, target, start, sum);
            list.remove(list.size() - 1);
            sum -= candidates[j];
        }
    }

    List<List<Integer>> listList;

    public List<List<Integer>> permuteUnique(int[] nums) {
        listList = new ArrayList<>();
        getAllPermute(nums, 0);
        return listList;
    }

    private void getAllPermute(int[] nums, int start) {
        if (start == nums.length) {
            listList.add(toList(nums));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            getAllPermute(nums, start + 1);
            swap(nums, i, start);
        }

    }

    private List<Integer> toList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        return list;
    }

    private void swap(int[] nums, int i, int j) {
        int a = nums[i];
        nums[i] = nums[j];
        nums[j] = a;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return createTree(nums, 0, nums.length - 1);
    }

    private TreeNode createTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = (left + right) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = createTree(nums, left, middle - 1);
        node.right = createTree(nums, middle + 1, right);
        return node;
    }

    boolean norm;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        norm = true;
        int a = isBal(root.left);
        int b = isBal(root.right);
        return norm && (a == b || a + 1 == b || a - 1 == b);
    }

    private int isBal(TreeNode node) {
        if (node == null) {
            return 1;
        }
        int a = isBal(node.left);
        int b = isBal(node.right);
        if (!(a == b || a - 1 == b || a + 1 == b)) {
            norm = false;
            return -1;
        }
        return Math.max(a, b) + 1;
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);
    }


    Map<Integer, String> mapOfRomans1 = Map.of(1, "I", 5, "V", 10, "X", 50, "L", 100, "C", 500, "D", 1000, "M",
            4, "IV", 9, "IX", 40, "XL");
    Map<Integer, String> mapOfRomans2 = Map.of(90, "XC", 400, "CD", 900, "CM");
    static int num;

    public String intToRoman(int num) {
        this.num = num;
        String s = "";
        while (this.num != 0) {
            if (num % 1000 > 0) {
                s = getNewString(s, 1000);
            } else if (num % 900 > 0) {
                s = getNewString(s, 900);
            } else if (num % 500 > 0) {
                s = getNewString(s, 500);
            } else if (num % 400 > 0) {
                s = getNewString(s, 400);
            } else if (num % 100 > 0) {
                s = getNewString(s, 100);
            } else if (num % 90 > 0) {
                s = getNewString(s, 90);
            } else if (num % 50 > 0) {
                s = getNewString(s, 50);
            } else if (num % 40 > 0) {
                s = getNewString(s, 40);
            } else if (num % 10 > 0) {
                s = getNewString(s, 10);
            } else if (num % 9 > 0) {
                s = getNewString(s, 9);
            }else if (num % 5 > 0) {
                s = getNewString(s, 5);
            }else if (num % 4 > 0) {
                s = getNewString(s, 4);
            }else {
                s = getNewString(s, 1);
            }
        }
        return s;
    }

    public String getNewString(String s, int current) {
        if (num % current > 0) {
            int a = num / current;
            for (int i = 0; i < a; i++) {
                if (mapOfRomans1.containsKey(current)) {
                    s += mapOfRomans1.get(current);
                } else {
                    s += mapOfRomans2.get(current);
                }

            }
            num -= a * current;
        }
        return s;
    }
}



