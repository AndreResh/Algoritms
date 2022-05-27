package alg.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElevenDay {
    public static void main(String[] args) {
//        System.out.println(new ElevenDay().combine(4, 3));
//        System.out.println(new ElevenDay().permute(new int[]{1, 2, 3,4}));
//        System.out.println(new ElevenDay().letterCasePermutation("RwR"));
        System.out.println(new ElevenDay().combine(4, 3));
    }

//    static List<List<Integer>> listList;
//
//    public List<List<Integer>> permute(int[] nums) {
//        listList = new ArrayList<>();
//        getAllPermutations(nums, 0);
//
//        return listList;
//    }
//
//    private void getAllPermutations(int[] nums, int i) {
//        if (i == nums.length - 1) {
//            List<Integer> list = Arrays.stream(nums).boxed().toList();
//            if(!listList.contains(list) && list.size()==nums.length){
//                listList.add(list);
//            }
//        }
//        for (int j = i; j < nums.length; j++) {
//            for (int k = 0; k < nums.length-j; k++) {
//                getAllPermutations(nums, j + 1);
//                rotate(nums, j);
//            }
//
//        }
//    }
//
//    private void rotate(int[] nums, int j) {
//        int z = nums[j];
//        for (int i = j + 1; i < nums.length; i++) {
//            nums[i - 1] = nums[i];
//        }
//        nums[nums.length - 1] = z;
//    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, nums, 0);
        return result;
    }

    public void backTrack(List<List<Integer>> result, int[] nums, int start) {
        if (start == nums.length) {
            result.add(toList(nums));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(i, start, nums);
            backTrack(result, nums, start + 1);
            swap(i, start, nums);
        }

    }

    public List<Integer> toList(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        for (int i : nums) {
            temp.add(i);
        }

        return temp;
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    List<String> list;

    public List<String> letterCasePermutation(String s) {
        list = new ArrayList<>();
        letterPermute(s, 0);
        return list;
    }

    private void letterPermute(String s, int i) {
        for (int j = i; j < s.length(); j++) {
            if (Character.isAlphabetic(s.charAt(j))) {
                char z = s.charAt(j);
                char[] first = s.toCharArray();
                if (Character.isUpperCase(z)) {
                    first[j] = Character.toLowerCase(z);
                    letterPermute(String.valueOf(first), j + 1);
                } else {
                    first[j] = Character.toUpperCase(z);
                    letterPermute(String.valueOf(first), j + 1);
                }
            }
        }
        list.add(s);
    }

    List<List<Integer>> listList;

    public List<List<Integer>> combine(int n, int k) {
        listList = new ArrayList<>();
        combineNumbers(n, k, 1, new ArrayList<>());
        return listList;
    }

    private void combineNumbers(int n, int k, int start, List<Integer> integerList) {
        System.out.println(integerList);
        if (k == integerList.size()) {
            List<Integer> newList = new ArrayList<>(integerList);
            listList.add(newList);
            return;
        }
        for (int j = start; j <= n; j++) {
            integerList.add(j);
            combineNumbers(n, k, j + 1, integerList);
            integerList.remove(integerList.size() - 1);
        }
    }

    public int reverse(int x) {
        try {
            StringBuilder builder;
            int res;
            if (x < 0) {
                builder = new StringBuilder(String.valueOf(Math.abs(x)));
                res = Integer.parseInt(builder.reverse().toString()) * -1;
            } else {
                builder = new StringBuilder(String.valueOf(x));
                res = Integer.parseInt(builder.reverse().toString());
            }
            return res;
        } catch (Exception e) {
            return 0;
        }

    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 1; i < nums.length; i+=2) {
            sum += Math.min(nums[i],nums[i-1] );
        }
        return sum;
    }


}
