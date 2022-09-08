package alg;

import java.util.Scanner;

public class YandexStag1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            char[] charsA = new char[26];
            char[] result = new char[a.length()];
            for (int i = 0; i < a.length(); i++) {
                if(a.charAt(i)==b.charAt(i)){
                    result[i]='P';
                } else {
                    charsA[a.charAt(i)-'A']++;
                }
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < a.length(); i++) {
                if(a.charAt(i)==b.charAt(i)) continue;
                int ch = b.charAt(i) - 'A';
                if(charsA[ch] >0){
                    charsA[ch]--;
                    result[i] = 'S';
                } else {
                    result[i]= 'I';
                }
            }
            System.out.println(new String(result));
        }

    }

}
