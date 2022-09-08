package alg.programmingSkills_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DaySix {
    public static void main(String[] args) {
        System.out.println(new DaySix().addToArrayForm(new int[]{1,2,3,}, 12));
    }

    public List<Integer> addToArrayForm(int[] num, int k) {
        StringBuilder builder = new StringBuilder();
        Arrays.stream(num).forEach(builder::append);
        long number = Long.parseLong(builder.toString());
        String res=String.valueOf(number+k);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < res.length(); i++) {
            list.add(Character.getNumericValue(res.charAt(i)));
        }
        return list;
    }


}
