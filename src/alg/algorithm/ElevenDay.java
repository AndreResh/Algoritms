package alg.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ElevenDay {
    public static void main(String[] args) {
//        System.out.println(new ElevenDay().combine(4, 3));

    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> listList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int z = i;
            int b = i;
            while (z + k - 1 <= n) {
                List<Integer> list = new ArrayList<>();
                for (int j = z; j <= n && list.size() < k; j++) {
                    if (z == j) {
                        list.add(b);
                    } else {
                        list.add(j);
                    }
                }
                if (!listList.contains(list) && list.size() == k) listList.add(list);
                z++;
            }

        }
        return listList;
    }






}
