package alg.programming_skills;

import java.util.ArrayList;
import java.util.List;

public class ElevenDay {
    public static void main(String[] args) {

    }
    public int[] sortByBits(int[] arr) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(Integer.toBinaryString(arr[i]));
        }
        System.out.println(list);
        return null;
    }
}
