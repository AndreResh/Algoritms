package alg.dynamicProgramming;

import java.util.*;

public class FirstDayDP {
    public static void main(String[] args) {

//        Integer[] strArray = nameList.toArray(new Integer[0]);
//        Iterator<Integer> iterator = delList.iterator();
//        while (iterator.hasNext()){
//            if(iterator.next()<10) iterator.remove();
//        }
//        //***
//        delList.removeIf((o)-> o <10);


//        Map<String, Integer> map = new TreeMap<>();
//        map.put("Gamma", 3);
//        map.put("Omega", 24);
//        map.put("Alpha", 1);
//
//        Iterator<Map.Entry<String, Integer>> entryIterator = map.entrySet().iterator();
//        while (entryIterator.hasNext()) {
//            if (entryIterator.next().getKey().equals("Alpha")) entryIterator.remove();
//        }
//        System.out.println(map);
        System.out.println(new FirstDayDP().findPaths(8,7,16,1,5));
    }

    public int[] findBall(int[][] grid) {
        int[] result = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            result[i] = findOurBall(grid, i, 0);
        }
        return result;
    }

    private int findOurBall(int[][] grid, int row, int column) {
        if (column == grid.length) {
            return row;
        }
        if ((row == 0 && grid[column][row] == -1) || (row == grid[0].length - 1 && grid[column][row] == 1)) return -1;
        if (grid[column][row] == 1) {
            if (row != grid[0].length - 1 && grid[column][row + 1] == -1) return -1;
            return findOurBall(grid, row + 1, column + 1);
        } else {
            if (row != 0 && grid[column][row - 1] == 1) return -1;
            return findOurBall(grid, row - 1, column + 1);
        }

    }

    public boolean canJump(int[] nums) {
        if (nums[0] == 0 && nums.length > 1) return false;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1] - 1, nums[i]);
            if (dp[i] == 0) return false;
        }
        return true;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return uniqPath(obstacleGrid, dp, 0, 0);
    }

    private int uniqPath(int[][] obstacleGrid, int[][] dp, int i, int j) {
        if (obstacleGrid[i][j] == 1) {
            dp[i][j] = 0;
            return 0;
        }
        if (dp[i][j] != -1) return dp[i][j];
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) return 1;

        int sum = 0;
        if (i < dp.length - 1) {
            sum += uniqPath(obstacleGrid, dp, i + 1, j);
        }
        if (j < dp[0].length - 1) {
            sum += uniqPath(obstacleGrid, dp, i, j + 1);
        }
        dp[i][j] = sum;
        return sum;
    }

    public int jump(int[] nums) {
//        int[] dp = new int[nums.length];
//        dp[nums.length - 1] = 0;
//        for (int i = nums.length - 2; i >= 0; i--) {
//            int a = nums[i]-1;
//            int j = i+1;
//            int min  =100000;
//            while (j<nums.length && a!=-1){
//                min = Math.min(min, dp[j]+1);
//                j++;
//                a--;
//            }
//
//            dp[i] = min;
//        }
//        return dp[0];

        int left = 0;
        int right = 0;
        int count = 0;
        while (right < nums.length - 1) {
            int current = 0;
            for (int i = left; i < right + 1; i++) {
                current = Math.max(current, nums[i] + i);
            }
            left = right + 1;
            right = current;
            count++;
        }
        return count;
    }

    public int maxResult(int[] nums, int k) {
        int max = nums[0];
        int left = 1;
        while (left < nums.length) {
            int current = Integer.MIN_VALUE;
            int size = Math.min(left + k, nums.length);
            int index = left;
            for (int i = left; i < size; i++) {
                if (nums[i] > current) {
                    current = nums[i];
                    index = i;
                }
//                current =Math.max(current, nums[i]);
            }
            left = index + 1;
            max += current;
//            System.out.println(left);
        }
        return max;
    }

    public int coinChange(int[] coins, int amount) {
        int count = 0;
        int i = coins.length - 1;
        while (i >= 0 && amount != 0) {
            if (amount == coins[i]) {
                return count + 1;
            } else if (amount % coins[i] >= 0) {
                count += amount / coins[i];
                amount -= coins[i] * (amount / coins[i]);
            }
            i--;
        }
        return amount == 0 ? count : -1;
    }

    public int deleteAndEarn(int[] nums) {

        if (nums.length == 1) return nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : nums) {
            map.put(a, map.getOrDefault(a, 0) + a);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        int[] dp = new int[list.size()];
        dp[0] = map.get(list.get(0));
        dp[1] = list.get(1) - 1 == list.get(0) ? Math.max(map.get(list.get(1)), dp[0]) : map.get(list.get(1)) + dp[0];
        for (int i = 2; i < list.size(); i++) {
            dp[i] = list.get(i) - 1 == list.get(i - 1) ? Math.max(map.get(list.get(i)) + dp[i - 2], dp[i - 1]) : dp[i - 1] + map.get(list.get(i));
        }

        return dp[dp.length - 1];
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][] dp = new int[m][n];
int a = findCountOfBoundaries(dp, maxMove, startRow, startColumn);
        System.out.println(Arrays.deepToString(dp));
        return a;
    }

    private int findCountOfBoundaries(int[][] dp, int maxMove, int i, int j) {
        if(i<0 || i>dp.length-1 || j<0 || j>dp[0].length-1){
            return 1;
        } else if (maxMove==0) {
            return 0;
        }
        int count = 0;
        count+=findCountOfBoundaries(dp, maxMove-1, i-1,j);
        count+=findCountOfBoundaries(dp, maxMove-1, i+1,j);
        count+=findCountOfBoundaries(dp, maxMove-1, i,j+1);
        count+=findCountOfBoundaries(dp, maxMove-1, i,j-1);
        dp[i][j] = count;
        return dp[i][j];
    }

}
