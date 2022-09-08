package alg.string;

import java.util.*;

public class FirstDayString {
    public static void main(String[] args) {
//        System.out.println(new FirstDayString().getHint("2962", "7236"));
        System.out.println(34 % 10);
    }

    public String discountPrices(String sentence, int discount) {
        String[] strings = sentence.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (validString(strings[i])) {
                strings[i] = newString(strings[i], discount);
            }
        }
        return String.join(" ", strings);
    }

    private boolean validString(String string) {
        char[] chars = string.toCharArray();
        if (chars.length < 2 || chars[0] != '$') return false;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') return false;
        }
        return true;
    }

    private String newString(String string, int discount) {
        long number = Long.parseLong(string.substring(1));
        return String.format("$%.2f", number - ((number * discount) / 100.0));
    }

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] secretChars = new int[10];
        int[] guessChars = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if (s == g) {
                bulls++;
                continue;
            }
            if (secretChars[g] > 0) {
                cows++;
                secretChars[g]--;
            } else {
                guessChars[g]++;
            }
            if (guessChars[s] > 0) {
                cows++;
                guessChars[s]--;
            } else {
                secretChars[s]++;
            }

        }
        return String.format("%dA%dB", bulls, cows);
    }

    public String longestCommonPrefix(String[] strs) {
        String main = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(main) != 0) {
                main = main.substring(0, main.length() - 1);
                if (main.isEmpty()) return "";
            }
        }
        return main;
    }


    public String multiply(String num1, String num2) {
        Stack<String> stack = new Stack<>();
        for (int j = num2.length() - 1; j >= 0; j--) {
            stack.push(multiplyStringByNumber(num1, Character.getNumericValue(num2.charAt(j)), num2.length() - j - 1));
        }
        while (stack.size() > 1) {
            String s1 = stack.pop();
            String s2 = stack.pop();
            stack.add(addStrings(s1, s2));
        }

        String result = stack.pop();
        int i = 0;
        while (i < result.length() - 1 && result.charAt(i) == '0') {
            i++;
        }
        return result.substring(i);
    }

    private String multiplyStringByNumber(String num, int number, int countOfZeroes) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < countOfZeroes; i++) {
            builder.append("0");
        }
        int current = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int result = Character.getNumericValue(num.charAt(i)) * number + current;
            builder.append(result % 10);
            int count = 0;
            while (result > 9) {
                count++;
                result -= 10;
            }
            current = count;
        }
        if (current != 0) builder.append(current);
        return builder.reverse().toString();
    }

    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int current = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            int result = current;
            if (i >= 0) {
                result += Character.getNumericValue(num1.charAt(i--));
            }
            if (j >= 0) {
                result += Character.getNumericValue(num2.charAt(j--));
            }
            builder.append(result % 10);
            current = result > 9 ? 1 : 0;
        }
        if (current != 0) builder.append(1);

        return builder.reverse().toString();
    }

    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> list = new ArrayList<>();
        String s = String.valueOf(k);
        int i = num.length - 1;
        int j = s.length() - 1;
        int current = 0;
        while (i >= 0 || j >= 0) {
            int res = current;
            res += i >= 0 ? num[i--] : 0;
            res += j >= 0 ? Character.getNumericValue(s.charAt(j--)) : 0;
            list.add(0, res % 10);
            current = res > 9 ? 1 : 0;
        }
        if (current > 0) list.add(0, current);
        return list;
    }

    public String digitSum(String s, int k) {
        if (s.length() <= k) return s;
        List<String> strings = new ArrayList<>();
        for (int i = 0, j = k; i < s.length(); i += k, j += k) {
            strings.add(j > s.length() ? s.substring(i) : s.substring(i, j));
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strings.size(); i++) {
            int current = 0;
            for (int j = 0; j < strings.get(i).length(); j++) {
                current += Character.getNumericValue(strings.get(i).charAt(j));
            }
            builder.append(current);
        }
        return digitSum(builder.toString(), k);
    }

    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        while (i < name.length() && j < typed.length()) {
            if (typed.charAt(j) == name.charAt(i)) {
                i++;
                j++;
            } else {
                if (i > 0 && typed.charAt(j) == name.charAt(i - 1)) {
                    while (j < typed.length() && typed.charAt(j) == name.charAt(i - 1)) {
                        j++;
                    }
                } else {
                    return false;
                }
            }
        }
        while (j < typed.length()) {
            if (typed.charAt(j) != typed.charAt(j - 1)) return false;
            j++;
        }
        return i == name.length();
    }

    public String longestPalindrome(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            String a = palindromeOfString(s, 0, 0);
            String b = palindromeOfString(s, 0, 1);
//            if(a.length()>b.length()){
//                if(max.length()<a.length()){
//                    max = a;
//                }
//            } else {
//                if(max.length()<b.length()){
//                    max = b;
//                }
//            }
            max = a.length() > b.length() ? max.length() < a.length() ? a : max : max.length() < b.length() ? b : max;
        }
        return max;
    }

    private String palindromeOfString(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;

        }
        return s.substring(left + 1, right);
    }
}