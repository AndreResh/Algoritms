package alg.queue;

import java.util.*;
import java.util.concurrent.DelayQueue;

public class FirstDayQueue {
    public static void main(String[] args) {
//        System.out.println(new FirstDayQueue().search(new ArrayList<>(List.of(194, 195, 196, 197, 198, 199, 201, 203, 204, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 20, 21, 22, 23, 24, 25, 26, 27, 29, 30, 31, 32, 33, 34, 35, 36, 37, 39, 40, 42, 43, 44, 45, 47, 48, 49, 50, 51, 52, 53, 54, 55, 57, 58, 59, 60, 61, 63, 65, 66, 68, 69, 70, 71, 73, 74, 76, 77, 79, 80, 81, 82, 83, 84, 86, 87, 88, 89, 91, 92, 93, 94, 95, 97, 98, 99, 101, 103, 104, 105, 106, 107, 108, 109, 110, 113, 114, 115, 117, 118, 120, 121, 122, 123, 124, 127, 128, 130, 131, 133, 134, 135, 136, 137, 139, 140, 141, 142, 143, 144, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 158, 159, 160, 161, 162, 163, 164, 166, 167, 169, 170, 171, 172, 174, 175, 177, 178, 179, 181, 182, 184, 185, 187, 189, 190, 192, 193)), 1));
        System.out.println(new FirstDayQueue().res("(()((("));
    }

    public int res(String s) {
        int result = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                result++;
            } else {
                result--;
            }
        }
        return result;
    }

    public String solve(String A) {
        StringBuilder builder = new StringBuilder();
        int[] ints = new int[26];
        Queue<Character> queue = new LinkedList<>();
        ints[A.charAt(0) - 'a']++;
        queue.offer(A.charAt(0));
        builder.append(A.charAt(0));
        for (int i = 1; i < A.length(); i++) {
            char ch = A.charAt(i);
            ints[ch - 'a']++;
            if (ints[ch - 'a'] < 2) {
                queue.add(ch);
            }
            while (!queue.isEmpty() && ints[queue.peek() - 'a'] > 1) {
                queue.poll();
            }
            if (queue.isEmpty()) {
                builder.append('#');
            } else {
                builder.append(queue.peek());
            }
        }
        return builder.toString();
    }

    public int search(final List<Integer> A, int B) {
        int left = 0;
        int right = A.size() - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (A.get(middle) > A.get(0)) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        System.out.println(left);
        if (B >= A.get(0)) {
            return search(A, 0, left - 1, B);

        } else {
            return search(A, left, A.size() - 1, B);
        }
    }

    public int search(final List<Integer> A, int left, int right, int B) {
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (A.get(middle) == B) {
                return middle;
            } else if (A.get(middle) < B) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }
}
