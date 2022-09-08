package alg.backtracing;

import java.util.*;

public class FirstDayBackTracking {
    public static void main(String[] args) {
        System.out.println(new FirstDayBackTracking().partition("a"));
    }
    public List<List<String>> partition(String s) {
        List<List<String>> listList = new ArrayList<>();
        partition(s, 0, listList, new ArrayList<String>());
        return listList;
    }
    public void partition(String s, int start, List<List<String>> listList, List<String> list) {
        if(start==s.length()){
            listList.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String current = s.substring(start, i+1);
            if(isPalindrome(current)){
                list.add(current);
                partition(s, i+1, listList, list);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isPalindrome(String current) {
        int left = 0;
        int right = current.length()-1;
        while (left<right){
            if(current.charAt(left)!=current.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public int colorful(int A) {
        Set<Integer> set = new HashSet<>();
        String number = String.valueOf(A);
        for (int i = 0; i < number.length(); i++) {
            int current = Character.getNumericValue(number.charAt(i));
            if (set.contains(current)) return 0;
            set.add(current);
            for (int j = i + 1; j < number.length(); j++) {
                current *= Character.getNumericValue(number.charAt(j));
                if (set.contains(current)) return 0;
                set.add(current);

            }
        }
        return 1;
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int count = 0;
        int i = 0;
        int fuel = startFuel;
        int indexStations = 0;
        while (i < target) {
            if (indexStations < stations.length) {
                if (stations[indexStations][0] == i) {
                    queue.add(stations[indexStations][i]);
                    indexStations++;
                }
            }
            if (fuel == 0) {
                if (!queue.isEmpty()) {
                    fuel += queue.poll();
                    count++;
                } else {
                    return -1;
                }
            }

            i++;
            startFuel--;
        }
        return count;
    }

    public int solve(String A, String B) {
        int[][] dp = new int[B.length() + 1][A.length() + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (A.charAt(j - 1) == B.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
//        Arrays.stream(dp).forEach((o)-> System.out.println(Arrays.toString(o)));
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public int maxp3(ArrayList<Integer> A) {

        Collections.sort(A);
        if (A.get(A.size() - 1) < 0) return A.get(A.size() - 1) * A.get(A.size() - 2) * A.get(A.size() - 3);
        int result = Integer.MIN_VALUE;
        int last = A.get(0) * A.get(1);
        for (int i = 2; i < A.size(); i++) {
            result = Math.max(result, A.get(i) * last);
            last = Math.max(last, A.get(i) * A.get(i - 1));
        }

        return result;
    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> listList = new ArrayList<>();
        getAllSubsets(A, listList, 0, new ArrayList<>());
        return listList;
    }

    private void getAllSubsets(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> listList, int start, ArrayList<Integer> list) {
        listList.add(new ArrayList<>(list));
        if (start == a.size()) return;
        for (int i = start; i < a.size(); i++) {
            list.add(a.get(i));
            getAllSubsets(a, listList, i + 1, list);
            list.remove(list.size() - 1);
        }

    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> listList = new ArrayList<>();
        getAllPermutations(A, listList, 0);
        return listList;
    }

    private void getAllPermutations(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> listList, int start) {
        if (start == a.size()) {
            listList.add(new ArrayList<>(a));
        }

        for (int i = start; i < a.size(); i++) {
            Collections.swap(a, i, start);
            getAllPermutations(a, listList, start + 1);
            Collections.swap(a, i, start);
        }
    }

    public void swap(List<Integer> list, int i, int j) {
        int a = list.get(i);
        list.set(i, list.get(j));
        list.set(j, a);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        Arrays.sort(nums);
        getAllSubsets(nums, 0, listList, new ArrayList<>());
        return new ArrayList<>(listList);
    }

    private void getAllSubsets(int[] nums, int start, List<List<Integer>> listList, List<Integer> list) {
        listList.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            getAllSubsets(nums, i + 1, listList, list);
            list.remove(list.size() - 1);
        }
    }

    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<=9;i++){
            numsSameConsecDiff(n, k, list, i);
        }

        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

    public void numsSameConsecDiff(int n, int k, List<Integer> list, int current) {
        if(current==0) return;
        if (String.valueOf(current).length() == n) {
            list.add(current);
            return;
        }
        for (int i = 0; i < 10; i++) {
            int lastDigit = current % 10;
            if (i+ k == lastDigit) {
                numsSameConsecDiff(n, k, list, current*10+i);
            } else if (i- k == lastDigit) {
                numsSameConsecDiff(n, k, list, current*10+i);
            }
        }
    }


}
