package alg.dataStructure2;

import java.util.*;

public class SecondDay {
    public static void main(String[] args) {
//        [1,3],[2,6],[8,10],[15,18]
    }


}

class Interval {
    private final int min;
    private final int max;

    public Interval(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "min=" + min +
                ", max=" + max +
                '}';
    }
}