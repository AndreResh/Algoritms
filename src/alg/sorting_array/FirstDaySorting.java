package alg.sorting_array;

import java.util.*;

public class FirstDaySorting {
    public static void main(String[] args) {
//        System.out.println(new FirstDaySorting().solve(new ArrayList<>(List.of("1.660952", "2.201339", "2.244956", "2.312240", "0.453388", "0.759609", "0.348647", "1.877379"))));

    }




    public int maximumGap(int[] nums) {
//        Arrays.sort(nums);
//        int count = 0;
//        for (int i = 1; i < nums.length; i++) {
//            count = Math.max(count, nums[i]-nums[i-1]);
//        }
//        return count;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int n : nums) {
            int index = n == max ? nums.length - 2 : (Math.abs(min - n) * (nums.length - 1)) / (max - min);
            map.put(index, new ArrayList<>());
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                list.add(Collections.min(map.get(nums[i])), Collections.max(map.get(nums[i])));
            }
        }
        int result = 0;
        for (int i = 1; i < list.size(); i++) {
            result = Math.max(result, list.get(i) - list.get(i - 1));
        }
        return result;
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        int[] sortingArr = nums.clone();
        Arrays.sort(sortingArr);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sortingArr.length; i++) {
            if (map.containsKey(sortingArr[i])) {
                continue;
            } else {
                map.put(sortingArr[i], i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = map.get(nums[i]);
        }
        return result;
    }

    public int perfectPeak(ArrayList<Integer> A) {
        int[] min = new int[A.size()];
        int[] max = new int[A.size()];
        min[0] = A.get(0);
        for (int i = 1; i < min.length; i++) {
            min[i] = Math.max(A.get(i), min[i - 1]);
        }
        max[max.length - 1] = A.get(max.length - 1);
        for (int i = max.length - 2; i >= 0; i--) {
            max[i] = Math.min(A.get(i), max[i + 1]);
        }
        for (int i = 1; i < A.size() - 1; i++) {
            if (A.get(i) > min[i - 1] && A.get(i) < max[i + 1]) return 1;
        }
        return 0;
    }

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        Set<Integer> lines = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                if (a.get(i).get(j) == 0) {
                    lines.add(i);
                    columns.add(j);
                }
            }
        }
        for (Integer line : lines) {
            List<Integer> list = a.get(line);
            for (int j = 0; j < list.size(); j++) {
                list.set(j, 0);
            }
        }
        for (Integer column : columns) {
            for (int j = 0; j < a.size(); j++) {
                a.get(j).set(column, 0);
            }
        }

    }

    public int solve(ArrayList<String> A) {
        double[] doubles = new double[A.size()];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = Double.parseDouble(A.get(i));
        }
        Arrays.sort(doubles);
        int left = 0;
        int right = doubles.length - 1;
        while (left < right) {
            double current = doubles[left] + doubles[right];
            if (current >= 2.0) {
                right--;
                continue;
            }
            int l = left + 1;
            int r = right - 1;
            while (l <= r) {
                int middle = l + (r - l) / 2;
                if (doubles[middle] + current > 1.0 && doubles[middle] + current < 2.0) {
                    return 1;
                } else if (doubles[middle] + current < 1) {
                    l = middle + 1;
                } else {
                    r = middle - 1;
                }
            }
            if (current + doubles[l] >= 2.0) {
                right--;
            } else {
                left++;
            }
        }
        return 0;
    }




}
