package alg.ace_inteviev_1;

public class TenDay {
    public int climbStairs(int n) {
        if(n==1) return 1;
        int[] ints = new int[n];
        ints[0] = 1;
        ints[1] = 2;
        for (int i = 2; i < ints.length; i++) {
            ints[i] = ints[i-2]+ints[i-1];
        }
        return ints[n-1];

    }
}
