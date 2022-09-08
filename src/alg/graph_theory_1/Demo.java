package alg.graph_theory_1;

import java.util.*;
import java.util.function.Function;


class Car {
    private final int a;
    private final List<Integer> list;

    public Car(int a, List<Integer> list) {
        this.a = a;
        this.list = new ArrayList<>(list);
    }

    public int getA() {
        return a;
    }

    public List<Integer> getList() {
        return new ArrayList<>(list);
    }
}

public class Demo {
    public static void main(String[] args) {
    }


    public static Integer array_max(Integer data[], int n) {
        return max(data);
    }

    public static Double array_max(Double data[], int n) {
        return max(data);
    }

    public static <T extends Number & Comparable<T>> T max(T[] arr) {
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = max.compareTo(arr[i]) > 0 ? max : arr[i];
        }
        return max;
    }
}





