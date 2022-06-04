package alg.programming_skills;

public class SecondDay {
    public int subtractProductAndSum(int n) {
        String s = String.valueOf(n);
        int sum = 0;
        int mult = 1;
        for (int i = 0; i < s.length(); i++) {
            int number = Character.getNumericValue(s.charAt(i));
            sum += number;
            mult *= number;
        }
        return Math.abs(mult-sum);
    }
}
