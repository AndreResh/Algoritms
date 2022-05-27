package alg.explore.stack_queue;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        MyCircularQueue myCircularQueue = new MyCircularQueue(2);
//        myCircularQueue.enQueue(3);
//        myCircularQueue.enQueue(9);
////        myCircularQueue.enQueue(5);
////        myCircularQueue.enQueue(0);
////        System.out.println(myCircularQueue);
//        System.out.println(myCircularQueue);
//        myCircularQueue.deQueue();
////        myCircularQueue.deQueue();
//        System.out.println(myCircularQueue.Front());
////        System.out.println(myCircularQueue.Front());

    }

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    checkIsland(grid, i, j);
                }
            }
        }
        return count;
    }

    private void checkIsland(char[][] grid, int i, int j) {
        if (grid[i][j] != '1') return;
        grid[i][j] = '0';
        if (i > 0) checkIsland(grid, i - 1, j);
        if (i < grid.length - 1) checkIsland(grid, i + 1, j);
        if (j > 0) checkIsland(grid, i, j - 1);
        if (j < grid[0].length - 1) checkIsland(grid, i, j + 1);
    }

    public int numSquares(int n) {
        return getSquare(n, 0,0);
    }

    private int getSquare(int target, int current, int step) {
        if(current==target) return step;
        while (true){

        }
    }
}

class MyCircularQueue {
    private int head;
    private int tail;
    private int size;
    private final int[] queue;

    public MyCircularQueue(int k) {
        this.queue = new int[k];
    }

    public boolean enQueue(int value) {
        if (size == queue.length) return false;
        if (tail == queue.length) tail = 0;
        queue[tail++] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (size == 0) return false;
        queue[head++] = -1;
        if (head == queue.length) head = 0;
        size--;
        return true;
    }

    public int Front() {
        return size == 0 ? -1 : queue[head];
    }

    public int Rear() {
        if (size == 0) return -1;
        if (tail == 0) return queue[queue.length - 1];
        return queue[tail - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }
}