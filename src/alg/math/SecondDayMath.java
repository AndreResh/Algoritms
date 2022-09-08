package alg.math;

import alg.sorting_array.FirstDaySorting;

import java.util.ArrayList;
import java.util.List;

public class SecondDayMath {
    public static void main(String[] args) {
//        System.out.println(new FirstDaySorting().solve("218765"));
//        System.out.println(new SecondDayMath().gcd(6, 9));
        new SecondDayMath().arrange(new ArrayList<>(List.of( 4, 0, 2, 1, 3)));
    }
    public void arrange(ArrayList<Integer> A) {
        int n = A.size();
        for (int i = 0; i < n; i++) A.set(i, A.get(i) + (A.get(A.get(i)) % n) * n );
        System.out.println(A);
        for (int i = 0; i < n; i++) A.set(i, A.get(i) / n);
        System.out.println(A);
    }


    public int reverse(int A) {
        long result = 0;
        while (A != 0) {
            int suffix = A % 10;
            result = result * 10 + suffix;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
            A /= 10;
        }
        return (int) result;
    }

    public int solve(int A, int B) {
        int count = 0;
        A--;
        B--;
        count += Math.min(A, B);
//        System.out.println(count);
        count += Math.min(A, 7 - B);
//        System.out.println(count);
        count += Math.min(7 - A, B);
//        System.out.println(count);
        count += Math.min(7 - A, 7 - B);
//        System.out.println(count);

        return count;
    }

    public boolean checkPowersOfThree(int n) {
        if (n == 1) return true;
        if (n % 3 != 0 && (n - 1) % 3 != 0) {
            return false;
        }
        return checkPowersOfThree(n % 3 == 0 ? n / 3 : (n - 1) / 3);
    }

    public int gcd(int A, int B) {
        System.out.println(A + " " + B);
        if (B == 0) return A;
        return gcd(B, A % B);
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        while (columnNumber != 0) {
            if (columnNumber > 26) {
                builder.append((char) (columnNumber % 26 + 'A'));
                columnNumber /= 26;
            } else {
                builder.append((char) (columnNumber % 26 + 'A'));
                break;
            }
        }
        return builder.reverse().toString();
    }

    public String solve(String A) {
        char[] chars = A.toCharArray();
        for (int i = chars.length - 2; i >= 0; i--) {
            if (chars[i] < chars[i + 1]) {
                changeMin(chars, i);
                int k = i + 1;
                for (int j = k + 1; j < chars.length; j++) {
                    char ch = chars[j];
                    int l = j;
                    while (l > k && chars[l - 1] > ch) {
                        chars[l] = chars[l - 1];
                        l--;
                    }
                    chars[l] = ch;
                }
                return new String(chars);
            }
        }
        return "-1";
    }

    private void changeMin(char[] chars, int k) {
        int i = chars.length - 1;
        while (k < i) {
            if (chars[i] > chars[k]) break;
            i--;
        }
        char ch = chars[k];
        chars[k] = chars[i];
        chars[i] = ch;
    }
}
