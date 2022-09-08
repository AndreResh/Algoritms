package alg;

import java.io.IOException;
import java.util.*;

public class Stepic {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            int countOfPowers = Integer.parseInt(scanner.nextLine());
            Map<Integer, Set<Integer>> map = new LinkedHashMap<>();
            int[][] ints = new int[countOfPowers][];
            for (int i = 0; i < countOfPowers; i++) {
                String[] stringsInp = scanner.nextLine().split(" ");
                ints[i] = new int[]{Integer.parseInt(stringsInp[0]), Integer.parseInt(stringsInp[1])};
                map.put(Integer.parseInt(stringsInp[0]), new HashSet<>());
                map.put(Integer.parseInt(stringsInp[1]), new HashSet<>());
            }
            Arrays.sort(ints, (Comparator.comparingInt(o -> o[0])));
            for (int[] a : ints) {
                map.get(a[0]).add(a[1]);
            }

            System.out.println(getCount(map, 0, 0));
        }
    }

    public static int getCount(Map<Integer, Set<Integer>> map, int current, int sum) {
        Set<Integer> set = map.get(current);
        for (Integer a : set) {
            if (a == current) {
                sum++;
            } else {
                sum = Math.max(sum, getCount(map, a, sum + 1));
            }
        }
        return sum;
    }
//    public static void main(String[] args) {
//        try (Scanner scanner = new Scanner(System.in)) {
//            Map<String, Integer> map = new HashMap<>();
//            while (scanner.hasNextLine()) {
//                String[] currentString = scanner.nextLine().split("=");
//                if (currentString[0].equals("{")) {
//                    readBlock(scanner, new HashMap<>(map));
//                } else {
//                    int number;
//                    try {
//                        number = Integer.parseInt(currentString[1]);
//                    } catch (NumberFormatException e) {
//                        number = map.getOrDefault(currentString[1], 0);
//                    }
//                    map.put(currentString[0], number);
//                    System.out.println(number);
//                }
//
//            }
//        }
//    }
//
//    private static void readBlock(Scanner scanner, Map<String, Integer> map) {
//        while (true) {
//            String[] currentString = scanner.nextLine().split("=");
//            if (currentString[0].equals("}")) {
//                return;
//            } else if (currentString[0].equals("{")) {
//                readBlock(scanner, new HashMap<>(map));
//            } else {
//                int number;
//                try {
//                    number = Integer.parseInt(currentString[1]);
//                } catch (NumberFormatException e) {
//                    number = map.getOrDefault(currentString[1], 0);
//                }
//                map.put(currentString[0], number);
//                System.out.println(number);
//            }
//        }
//    }
//    public static void main(String[] args) {
//        try (Scanner scanner = new Scanner(System.in)) {
//            String mainString = scanner.nextLine();
//
//            int c = Integer.parseInt(scanner.nextLine());
//            for (int i = 0; i < c; i++) {
//                String[] str = scanner.nextLine().split(" ");
//                int start = Integer.parseInt(str[0]) - 1;
//                int end = Integer.parseInt(str[1]);
//                char[] mainChars = mainString.substring(start, end).toCharArray();
//                char[] copyChars = mainChars.clone();
//                Arrays.sort(copyChars);
//                System.out.println(getCount(mainChars, copyChars));
//            }
//        }
//    }

    private static int getCount(char[] main, char[] copy) {
        int indexForCopy = 0;
        int count = 0;
        while (indexForCopy < copy.length) {
            int lastIndex = 0;
            for (int i = 0; i < main.length; i++) {
                if (main[i] == copy[indexForCopy]) {
                    count += i - lastIndex;
                    lastIndex = i;
                    indexForCopy++;
                }
            }
            if (indexForCopy == copy.length) break;
            lastIndex = main.length - 1;
            for (int i = main.length - 1; i >= 0; i--) {
                if (main[i] == copy[indexForCopy]) {
                    count += lastIndex - i;
                    lastIndex = i;
                    indexForCopy++;
                }
            }

        }

        return count;
    }
//    public static void main(String[] args) {
//        try(Scanner scanner = new Scanner(System.in)) {
//            String[] strings = scanner.nextLine().split(" ");
//            List<String> stringList = new ArrayList<>();
//            for (int i = 0; i < Integer.parseInt(strings[0]); i++) {
//                stringList.add(scanner.nextLine());
//            }
//            for (int i = 0; i < Integer.parseInt(strings[1]); i++) {
//                String[] str = scanner.nextLine().split(" ");
//                System.out.println(getCount(str[0], str[1], stringList));
//            }
//        }
//    }
//
//    private static int getCount(String start, String end, List<String> stringList) {
//        int count = 0;
//        for (int i = 0; i < stringList.size(); i++) {
//            if(stringList.get(i).startsWith(start) && stringList.get(i).endsWith(end)) count++;
//        }
//        return count;
//    }
//    public static void main(String[] args) {
//        try (Scanner scanner = new Scanner(System.in)) {
//            String[] strings1= scanner.nextLine().split(" ");
//            int x1Old = Integer.parseInt(strings1[0]);
//            int y1Old = Integer.parseInt(strings1[1]);
//            int x2Old = Integer.parseInt(strings1[2]);
//            int y2Old = Integer.parseInt(strings1[3]);
//            String[] strings2 = scanner.nextLine().split(" ");
//            int x1New = Integer.parseInt(strings2[0]);
//            int y1New = Integer.parseInt(strings2[1]);
//            int x2New = Integer.parseInt(strings2[2]);
//            int y2new = Integer.parseInt(strings2[3]);
//            int first = x2Old-x1New;
//            int second = y2Old-y1New;
//            if(first>second){
//                System.out.println(first*first);
//            } else {
//                System.out.println(second*second);
//            }
//        }
//
//    }
//    public static void main(String[] args) {
//        try(Scanner scanner = new Scanner(System.in)) {
//            String[] strings = scanner.nextLine().split( " ");
//            List<String> stringList = new ArrayList<>();
//            for (int i = 0; i < Integer.parseInt(strings[0]); i++) {
//                stringList.add(scanner.nextLine().trim());
//            }
//            Collections.sort(stringList);
//            for (int i = 0; i < Integer.parseInt(strings[1]); i++) {
//                String[] s = scanner.nextLine().split(" ");
//                System.out.println(foundPerson(Integer.parseInt(s[0]), s[1], stringList));
//            }
//        }
//    }

    private static int foundPerson(int index, String prefix, List<String> list) {
        int i = -1;
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j).startsWith(prefix)) {
                i = j;
                break;
            }
        }


        if (i == -1) return -1;
        if (i + index - 1 < list.size() && list.get(i + index - 1).startsWith(prefix))
            return index != 1 ? i + index + 1 : i + index;
        return -1;
    }

    //    public static void main(String[] args) {
//        try(Scanner scanner = new Scanner(System.in);) {
//            int count = Integer.parseInt(scanner.nextLine().trim());
//            int result = 0;
//            Map<String,Integer> map = new HashMap<>();
//            for (int i = 0; i < count; i++) {
//                String[] strings = scanner.nextLine().trim().split(" ");
//                Arrays.sort(strings);
//                String res = String.join("", strings);
//                int current = map.getOrDefault(res, 0)+1;
//                result = Math.max(current, result);
//                map.put(res, current);
//            }
//            System.out.println(result);
//        }
//
//
//    }
//    public static void main(String[] args) {
//        try (Scanner scanner = new Scanner(System.in);) {
//            int count = Integer.parseInt(scanner.nextLine().trim());
//            int[] ints = new int[count];
//            int sum = 0;
//            Integer forPlus = null;
//            Integer forMinus = null;
//            String[] strings = scanner.nextLine().split(" ");
//            for (int i = 0; i < strings.length; i++) {
//                int current = Integer.parseInt(strings[i]);
//                ints[i] = current;
//                if (i % 2 == 0) {
//                    sum += current;
//
//                    if(forMinus==null){
//                        forMinus = i;
//                    } else if (ints[forMinus]>current) {
//                        forMinus = i;
//                    }
//                } else {
//                    sum -= current;
//                    if(forPlus==null){
//                        forPlus = i;
//                    } else if (ints[forPlus]<current) {
//                        forPlus = i;
//                    }
//                }
//            }
//            int newSum = 0;
//            if(forPlus!=null && forMinus!=null){
//                int a =ints[forPlus];
//                ints[forPlus] = ints[forMinus];
//                ints[forMinus] = a;
//                for (int i = 0; i < ints.length; i++) {
//                    if(i%2==0){
//                        newSum +=ints[i];
//                    } else {
//                        newSum -=ints[i];
//                    }
//                }
//                System.out.println(Math.max(newSum, sum));
//            } else {
//                System.out.println(sum);
//            }
//        }
//    }
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        LinkedList<Integer> list = new LinkedList<>();
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int a = 0;
        while (i >= 0 || j >= 0) {
            int current = a;
            if (i >= 0) {
                current += arr1[i--];
            }
            if (j >= 0) {
                current += arr2[j--];
            }
            list.addFirst(current % 2);
            a = current > 1 ? 1 : 0;
        }
        int[] ints = new int[list.size()];
        for (int k = 0; k < ints.length; k++) {
            ints[k] = list.get(k);
        }
        return ints;
    }


}

class Person {
    private int a;
    private int b;

    public Person(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Person(int a) {
        this.a = a;
    }

}