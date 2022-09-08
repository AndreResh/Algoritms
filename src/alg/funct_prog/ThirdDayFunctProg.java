package alg.funct_prog;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class ThirdDayFunctProg {


    public static void main(String[] args) {
        UnaryOperator<Integer> operator = x -> x * 2 + 1;
        int result = operator.compose(operator).apply(10);
        System.out.println(result);
    }

    private static <T> T[] toArr(Class<T> stringClass, List<T> list) {
        T[] ts = (T[]) Array.newInstance(stringClass, list.size());
        for (int i = 0; i < list.size(); i++) {
            ts[i] = list.get(i);
        }
        return ts;
    }
}
class CombiningPredicates {

    /**
     * The method represents the conjunction operator for a list of predicates.
     * For an empty list it returns the always true predicate.
     */
    public static IntPredicate conjunctAll(List<IntPredicate> predicates) {
        return predicates.stream().reduce(IntPredicate::and).orElse(n -> true);
    }

    // Don't change the code below
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split("\\s+");

        List<Boolean> values;
        if (strings[0].trim().length() == 0) {
            values = List.of();
        } else {
            values = Arrays.stream(strings)
                    .map(Boolean::parseBoolean)
                    .collect(Collectors.toList());
        }

        List<IntPredicate> predicates = new ArrayList<>();
        values.forEach(v -> predicates.add(x -> v));

        System.out.println(conjunctAll(predicates).test(0));
    }
    public static <T> Predicate<T> xor(Predicate<T> predicate1, Predicate<T> predicate2) {
        return predicate1.or(predicate2).and((predicate2.and(predicate1)).negate()); // write your code here
    }
}
