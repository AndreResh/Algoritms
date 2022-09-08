package alg.priority_queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class SecondDayPriorityQueue {
    public int nchoc(int A, ArrayList<Integer> B) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int divi =(int)  Math.pow(10,9)+7;
        queue.addAll(B);
        int count = 0;
        while(A!=0){
            int max = queue.poll();
            count = (count + (max%divi))%divi;
            queue.add(max/2);
            A--;
        }
        return count;
    }
}
