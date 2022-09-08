package alg.sorting;

import java.util.*;

public class QuickSort {
    public static void main(String[] args) {


//        int[] ints = {4, 2, 9, 1, 98, 6, 3, 8, 1, 1, 5, 9, 4, 7, 1, 76, 54, 32, 12, 43, 56};
//        QuickSort.quickSort(ints);
//        System.out.println(Arrays.toString(ints));
//        System.out.println(QuickSort.findKthLargest(ints, 3));
//        System.out.println("llpbugcswlidtcahvvyctgyxoqe".length());
        System.out.println(new QuickSort().solve(new ArrayList<>(List.of(new ArrayList<>(List.of(468, 0)), new ArrayList<>(List.of(335, 501))))));
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (right - left <= 0) return;
        int pivot = arr[right];
        int indexWall = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, indexWall);
                indexWall++;
            }
        }
        swap(arr, indexWall, right);
        quickSort(arr, left, indexWall - 1);
        quickSort(arr, indexWall + 1, right);

    }

    public static int findKthLargest(int[] nums, int k) {
        int indexPivot = nums.length - k;
        return findKthLargest(nums, indexPivot, 0, nums.length - 1);
    }

    private static int findKthLargest(int[] nums, int indexPivot, int left, int right) {
        if (left == right) return nums[left];
        int wallIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < nums[right]) {
                swap(nums, i, wallIndex);
                wallIndex++;
            }
        }
        swap(nums, wallIndex, right);
        if (wallIndex == indexPivot) {
            return nums[wallIndex];
        } else if (wallIndex < indexPivot) {
            return findKthLargest(nums, indexPivot, wallIndex + 1, right);
        } else {
            return findKthLargest(nums, indexPivot, left, wallIndex - 1);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int a = arr[i];
        arr[i] = arr[j];
        arr[j] = a;

    }

    public int solve(ArrayList<ArrayList<Integer>> A) {
        for(int i = A.size()-2; i>=0; i--){
            for(int j = 0; i<A.get(i).size()-1; j++){
//                System.out.println(i+" "+j+" "+A.get(i).size());
                A.get(i).set(j, Math.min(A.get(i+1).get(j), A.get(i+1).get(j+1))+A.get(i).get(j));
            }
        }
        return A.get(0).get(0);
    }



}
