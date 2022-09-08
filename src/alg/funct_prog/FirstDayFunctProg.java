package alg.funct_prog;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.DoubleToLongFunction;

public class FirstDayFunctProg {
    public static void main(String[] args) {

    }
}
@FunctionalInterface
interface BiFunc<T, U, R> {
    R apply(T t, U u);
}

class Operator {
    static BiFunction<Integer, Integer, Integer> function = Math::min;
}

@FunctionalInterface
interface Retry {
    void run(Runnable action, int maxAttempts, long delayBeforeRetryMs);
}

final class RetryUtils {
    public static Retry retry = (RetryUtils::retryAction);// assign the retryAction method to this variable

    private RetryUtils() {
    }

    public static int retryAction(Runnable action, int maxAttempts, long delayBeforeRetryMs) {

        int fails = 0;
        while (fails < maxAttempts) {
            try {
                action.run();
                return fails;
            } catch (Exception e) {
                System.out.println("Something goes wrong");
                fails++;
                try {
                    Thread.sleep(delayBeforeRetryMs);
                } catch (InterruptedException interruptedException) {
                    throw new RuntimeException(interruptedException);
                }
            }
        }
        return fails;
    }
}

class Retrying {
    private static final int MAX_ATTEMPTS = 10;
    private static final long DELAY_MS = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RetryUtils.retry.run(() -> System.out.println(scanner.nextLine()), MAX_ATTEMPTS, DELAY_MS);
    }
}