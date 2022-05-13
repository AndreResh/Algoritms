package alg.algorithm;

import java.util.Arrays;

public class FourthDay {
    public static void main(String[] args) {
//        char[] chars={'h','e','l','l','o','L'};
//        new FourthDay().reverseString(chars);
//        System.out.println(Arrays.toString(chars));
        System.out.println(new FourthDay().reverseWords("Let's take LeetCode contest"));
    }
//    344. Reverse String
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        char k;
        while(left<right){
            k = s[left];
            s[left++]=s[right];
            s[right--]=k;
        }
    }

//    557. Reverse Words in a String III
    public String reverseWords(String s) {
        String[] strings=s.split(" ");
        for (int i = 0; i < strings.length; i++) {
            char[] chars=strings[i].toCharArray();
            int k = 0;
            int j = chars.length - 1;
            char z;
            while (k<=j){
                z= chars[k];
                chars[k]=chars[j];
                chars[j]= z;
                k++;
                j--;
            }
            strings[i]=String.valueOf(chars);
        }
        return String.join(" ",strings);
    }
}
