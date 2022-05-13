package alg.algorithm;

public class TwelveDay {
    public static void main(String[] args) {
//        System.out.println(new ElevenDay().climbStairs(44));
    }
    static int count;
    public int climbStairs(int n) {
        count = 0;
        climb(0, n);
        return count;
    }

    private void climb(int number, int n) {
        if (number == n) {
            count++;
            return;
        } else if (number > n) {
            return;
        } else {
            climb(number+1, n);
            climb(number+2,n);
        }
    }
//    public int rob(int[] nums) {
//        int sum = 0;
//        int current = 0;
//        for (int i = 0; i < nums.length ; i++) {
//            current += nums[i];
//            if(current)
//        }
//        return Math.max(max1, max2);
//    }
}
