package alg.graph_theory_1;

import java.util.Arrays;
import java.util.Scanner;

public class Dem {


    //    public static void main(String[] args) {
//        try(Scanner scanner = new Scanner(System.in);){
//            int a = Integer.parseInt(scanner.nextLine());
//            Integer[] integers = Arrays.stream(scanner.nextLine().split(" "))
//                    .map(Integer::parseInt).toArray(Integer[]::new);
//            StringBuilder builder = new StringBuilder();
//            for (int i = 0; i < integers.length; i++) {
//                int num = i!=0?Math.abs(integers[i]-integers[i-1]):integers[i];
//                int pow = 0;
//                while (num!=0) {
//                    double z = Math.pow(2, pow);
//                    if (z > num) {
//                        pow--;
//                        break;
//                    } else if (z == num) {
//                        break;
//                    } else {
//                        pow++;
//                    }
//                }
//                if(pow==26){
//                    builder.append(" ");
//                } else {
//                    builder.append(((char) ('a' + pow)));
//                }
//            }
//            System.out.println(builder);
//
//        }
//
//    }
//    public static void main(String[] args) {
//        try (Scanner scanner = new Scanner(System.in)) {
//            String[] strings = scanner.nextLine().split(" ");
//            int i = Integer.parseInt(strings[0]);
//            int j = Integer.parseInt(strings[1]);
//            char[][] chars = new char[i][j];
//            for (int k = 0; k < chars.length; k++) {
//                chars[k] = scanner.nextLine().toCharArray();
//            }
//            for (int k = 0; k < chars.length; k++) {
//                for (int l = 0, m = chars[k].length - 1; l < chars[k].length / 2; l++, m--) {
//                    char ch = chars[k][l];
//                    if(ch=='\\'){
//                        ch = '/';
//                    } else if (ch=='/') {
//                        ch = '\\';
//                    }
//                    if(chars[k][m]=='\\'){
//                        chars[k][m] = '/';
//                    } else if (chars[k][m]=='/') {
//                        chars[k][m] = '\\';
//                    }
//                    chars[k][l] = chars[k][m];
//                    chars[k][m] = ch;
//                }
//            }
////            Arrays.stream(chars).forEach((o)->System.out.println(Arrays.toString(o)));
////            System.out.println();
//            for (int k = 0; k < chars[0].length; k++) {
//                for (int l = 0, m = chars.length - 1; l < chars.length / 2; l++, m--) {
//                    char ch = chars[l][k];
//                    if(ch=='\\'){
//                        ch = '/';
//                    } else if (ch=='/') {
//                        ch = '\\';
//                    }
//                    if(chars[m][k]=='\\'){
//                        chars[m][k] = '/';
//                    } else if (chars[m][k]=='/') {
//                        chars[m][k] = '\\';
//                    }
//                    chars[l][k] = chars[m][k];
//                    chars[m][k] = ch;
//                }
//
//            }
//            Arrays.stream(chars).forEach((o)->System.out.println(new String(o)));
//        }
//    }

    public static void main(String[] args) {


    }

    private static int getNOD(int min, int max) {
        int easy = 1;
        LOOP:
        for (int i = 2; i <= max; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) continue LOOP;
            }
            System.out.println(i);
//            if (i * min > max) {
//                break;
//            }
            easy = i;
        }
//        System.out.println(easy);
//        min*= easy;
//        while (max != 0) {
//            int tmp = min % max;
//            min = max;
//            max = tmp;
//        }
//        return min;
        return 1;
    }
}
//5 5
//        .....
//        .._..
//        ./X\.
//        .\_/.
//        .....
//8 13

//.............
//...._........
//.._/A\_..._..
//./B\_/D\_/F\.
//.\_/C\_/E\_/.
//...\_/G\_/...
//.....\_/.....
//.............