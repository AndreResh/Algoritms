package alg.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class SixDay {
    public static void main(String[] args) {

    }
    public int arrangeCoins(int n) {
        if(n==1) return 1;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int count = 0;
        for (int i = 2; i < n; i++) {
            int z = i+ list.get(list.size()-1);
            if(z==n){
                return count+1;
            } else if (z>n) {
                return count;
            } else {
                count++;
            }
        }
        return count;
    }
    public int findKthPositive(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        int z = 0;
        int i = 1;
        while (true){
            if(z<arr.length && arr[z]==i){
                z++;
            } else {
                list.add(i);
            }
            i++;
            if(list.size()==k) return list.get(list.size()-1);
        }
    }
}
