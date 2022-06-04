package alg;

import alg.domains.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class MainSecond {
    public static void main(String[] args) {
//        System.out.println(new MainSecond().maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
//        System.out.println(new MainSecond().findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
//        for (int i = 0; i < 10; i++) {
//            if(i%2==0){
//                continue;
//            }
//            System.out.println(i);
//        }
        System.out.println(new MainSecond().countAndSay(4));
    }

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> mainList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<TreeNode> nodeList = new ArrayList<>();
            while (!queue.isEmpty()) {
                nodeList.add(queue.poll());
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nodeList.size(); i++) {
                if (nodeList.get(i).left != null) {
                    queue.add(nodeList.get(i).left);
                }
                if (nodeList.get(i).right != null) {
                    queue.add(nodeList.get(i).right);
                }
                if (nodeList.get(i).val > max) {
                    max = nodeList.get(i).val;
                }
            }
            mainList.add(max);
        }
        return mainList;
    }

    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }
            count++;
        }
        return count;
    }

    public int maxProduct(String[] words) {
        List<SetAndSize> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            list.add(getSetAndSize(words[i]));
        }
        int max = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getSet().stream().noneMatch(list.get(j).getSet()::contains)) {
                    max = Math.max(max, list.get(i).getSize() * list.get(j).getSize());
                }
            }
        }
        return max;
    }

    private SetAndSize getSetAndSize(String word) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            set.add(word.charAt(i));
        }
        return new SetAndSize(set, word.length());
    }

    public void gameOfLife(int[][] board) {
        int[][] ints = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                ints[i][j] = getNumberLifeOrDead(board, i, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ints[i][j];
            }
        }
    }

    private int getNumberLifeOrDead(int[][] board, int i, int j) {
        int neighbors = 0;
        if (i > 0 && board[i - 1][j] == 1) neighbors++;
        if (i < board.length - 1 && board[i + 1][j] == 1) neighbors++;

        if (j > 0 && board[i][j - 1] == 1) neighbors++;
        if (j < board[i].length - 1 && board[i][j + 1] == 1) neighbors++;

        if (i > 0 && j > 0 && board[i - 1][j - 1] == 1) neighbors++;
        if (i < board.length - 1 && j > 0 && board[i + 1][j - 1] == 1) neighbors++;

        if (i > 0 && j < board[i].length - 1 && board[i - 1][j + 1] == 1) neighbors++;
        if (i < board.length - 1 && j < board[i].length - 1 && board[i + 1][j + 1] == 1) neighbors++;

        if ((board[i][j] == 1 && (neighbors == 2 || neighbors == 3)) || (board[i][j] == 0 && neighbors == 3)) {
            return 1;
        } else {
            return 0;
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> listMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String result = getResultString(strs[i]);
            List<String> list;
            if (listMap.containsKey(result)) {
                list = listMap.get(result);
            } else {
                list = new ArrayList<>();
            }
            list.add(strs[i]);
            listMap.put(result, list);
        }
        return new ArrayList(listMap.values());
    }

    private String getResultString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    static List<List<Integer>> combinationSum2List;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        combinationSum2List = new ArrayList<>();
        Arrays.sort(candidates);
        getAllCombinations(candidates, 0, new ArrayList<>(), 0, target);
        return combinationSum2List;
    }

    private void getAllCombinations(int[] candidates, int start, ArrayList<Integer> list, int sum, int target) {
        if (sum == target) {
            combinationSum2List.add(new ArrayList<>(list));
            return;
        } else if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && (candidates[i] == candidates[i - 1])) {
                continue;
            }
            sum += candidates[i];
            list.add(candidates[i]);
            getAllCombinations(candidates, i + 1, list, sum, target);
            sum -= candidates[i];
            list.remove(list.size() - 1);
        }
    }

    public String countAndSay(int n) {
        return generateCountAndSay(n - 1, "1");
    }

    private String generateCountAndSay(int end, String s) {
        if (end == 0) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        int count = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) == s.charAt(i - 1)) {
                count++;
            }
            if (i > 0 && s.charAt(i) != s.charAt(i - 1)) {
                builder.append(count);
                builder.append(s.charAt(start));
                start = i;
                count = 1;
            }
        }
        builder.append(count);
        builder.append(s.charAt(start));
        return generateCountAndSay(end - 1, builder.toString());
    }

    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) return Collections.emptyList();
        Set<String> set = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (int i = 9, j = 0; i < s.length(); i++, j++) {
            String key = s.substring(j, i + 1);
            if (set.contains(key)) result.add(key);
            set.add(key);
        }
        return List.copyOf(result);
    }

    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        int count = 1;
        int left = 1;
        int right = 1;
        while (right < nums.length) {
            if (nums[right] == nums[right - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count == 3) {
                while (right < nums.length && nums[right] == nums[right - 1]) {
                    size--;
                    right++;
                }
                count = 1;

            }
            if (right < nums.length) nums[left++] = nums[right++];
        }
        return size;
    }

    boolean[][] booleans;

    public void setZeroes(int[][] matrix) {
        booleans = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!booleans[i][j] && matrix[i][j] == 0) {
                    setToZero(matrix, i, j);
                }
                booleans[i][j] = true;
            }
        }
    }

    private void setToZero(int[][] matrix, int i, int j) {
        for (int k = 0; k < matrix[i].length; k++) {
            if (matrix[i][k] == 0) {
                continue;
            }
            matrix[i][k] = 0;
            booleans[i][k] = true;
        }
        for (int k = 0; k < matrix.length; k++) {
            if (matrix[k][j] == 0) {
                continue;
            }
            matrix[k][j] = 0;
            booleans[k][j] = true;
        }
    }

    public int[] productExceptSelf(int[] nums) {
        int[] ints = new int[nums.length];
        multiplyOnEach(nums, ints, 0, 1);
        return ints;
    }

    private int multiplyOnEach(int[] nums, int[] ints, int index, int result) {
        if (index == nums.length - 1) {
            ints[index] = result;
            return result * nums[index];
        }
        int a = multiplyOnEach(nums, ints, index + 1, result * nums[index]);
        if(nums[index]!=0) {
            ints[index] = a / nums[index];
        } else {
            ints[index] = a;
        }
        return a;
    }

}

class SetAndSize {
    private Set<Character> set;
    private int size;

    public SetAndSize(Set<Character> set, int size) {
        this.set = set;
        this.size = size;
    }

    public Set<Character> getSet() {
        return set;
    }

    public void setSet(Set<Character> set) {
        this.set = set;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "SetAndSize{" +
                "set=" + set +
                ", size=" + size +
                '}';
    }
}

class NumMatrix {
//    private int[][] ints;
//
//    public NumMatrix(int[][] matrix) {
//        this.ints = matrix;
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        int sum = 0;
//        for (int i = row1; i <= row2; i++) {
//            for (int j = col1; j <= col2; j++) {
//                sum += ints[i][j];
//            }
//        }
//return sum;
//
//    }

    private int[][] dp;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        dp = new int[matrix.length][matrix[0].length + 1];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                dp[r][c + 1] = dp[r][c] + matrix[r][c];
            }
        }
        Arrays.stream(dp).forEach((o) -> System.out.println(Arrays.toString(o)));
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int row = row1; row <= row2; row++) {
            sum += dp[row][col2 + 1] - dp[row][col1];
        }
        return sum;
    }

    public int minSubArrayLen(int target, int[] nums) {
        int current = 0;
        int length = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            current += nums[i];
            while (current >= target) {
                if (length != 0) {
                    length = Math.min(length, i - j + 1);
                } else {
                    length = i - j + 1;
                }
                current -= nums[j++];
            }

        }
        return length;
    }


}

class NumArray {

    int[] ints;
    public NumArray(int[] nums) {
        ints = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            ints[i+1] = ints[i] + nums[i];
        }
        System.out.println(Arrays.toString(ints));
    }

    public int sumRange(int left, int right) {
        return ints[right+1]-ints[left];
    }
}











