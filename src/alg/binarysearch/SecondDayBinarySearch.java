package alg.binarysearch;

import java.util.*;

public class SecondDayBinarySearch {
    public static void main(String[] args) {
//        System.out.println(new SecondDayBinarySearch().solve(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11)), 12));
//        System.out.println(new SecondDayBinarySearch().sqrt(857030232));
        System.out.println(1.0/6);
    }

    public int sqrt(int A) {
        if (A < 2) return A;
        long start = 1, end = A, ans = 0;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == A)   return (int) mid;
            if (mid * mid < A) {
                start = mid + 1;
                ans = mid;
            } else {
                end = mid - 1;
            }
        }
        return (int) ans;
    }

    public int solve(ArrayList<Integer> A, int B) {
        int left = 0;
        int right = A.size() - 1;
        int middle;
        while (left < right) {
            middle = left + (right - left) / 2;
            if (A.get(middle) == B) {
                return middle;
            } else if (A.get(middle) > A.get(middle + 1)) {
                right = left;
            } else if (A.get(middle) < A.get(middle + 1)) {
                left = middle + 1;
            }

        }
        int a = findInArrayNormal(A, 0, left, B);
        if (a == -1) return findInArrayRotated(A, left + 1, A.size() - 1, B);
        return a;
    }

    private int findInArrayNormal(ArrayList<Integer> A, int left, int right, int value) {
        int middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (A.get(middle) == value) {
                return middle;
            } else if (A.get(middle) < value) {
                left = middle + 1;

            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    private int findInArrayRotated(ArrayList<Integer> A, int left, int right, int value) {
        int middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (A.get(middle) == value) {
                return middle;
            } else if (A.get(middle) > value) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }


    public int search(final List<Integer> A, int B) {
        int left = 0;
        int right = A.size() - 1;

        while (left < right) {
            int middle = left + (right - left) / 2;
            if (A.get(middle) < A.get(middle + 1) && A.get(middle) >= A.get(0)) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        if (A.get(0) <= B) {
            return binarySearch(A, 0, left, B);
        } else {
            return binarySearch(A, left + 1, A.size() - 1, B);
        }
    }

    private int binarySearch(List<Integer> A, int left, int right, int value) {
        int middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (A.get(middle) == value) {
                return middle;
            } else if (A.get(middle) < value) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        int left = 0;
        int right = A.size();
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (A.get(middle) == B) {
                int l = middle;
                int r = middle;
                while (l > 0 && A.get(l - 1) == B) l--;
                while (r < A.size() - 1 && A.get(r + 1) == B) r++;
                return new ArrayList<>(Arrays.asList(l, r));
            } else if (A.get(middle) < B) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return new ArrayList<>(Arrays.asList(-1, -1));
    }


}
