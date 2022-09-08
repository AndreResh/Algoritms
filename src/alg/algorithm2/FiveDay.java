package alg.algorithm2;

import java.util.*;

public class FiveDay {
    public List<Integer> findAnagrams(String s, String p) {
        String pattern = getPattern(p.toCharArray());
        List<Integer> list = new ArrayList<>();
        for (int i = p.length()-1, j = 0; i < s.length(); i++, j++) {
            if(getPattern(s.substring(j, i).toCharArray()).equals(pattern)){
                list.add(j);
            }
        }
        return list;

    }
    private String getPattern(char[] chars){
        Arrays.sort(chars);
        return new String(chars);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int[] ints = new int[nums.length+1];
        ints[0] = 1;
        int count = 0;
        for (int i = 0, j = 1; i < nums.length; i++, j++) {
            ints[j] = ints[j-1] * nums[i];
            int l = j - 1;
            while (l>=0){
                if(ints[j]/ints[l]<k){
                    count++;
                }
                l--;
            }
        }
        return count;
    }
}
