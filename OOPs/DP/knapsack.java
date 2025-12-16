public class knapsack {

    public static int profit(int i, int[] val, int[] wt, int capacity, int[][] dp) {
        if(i == val.length) return 0;
        if(dp[i][capacity] != -1) return dp[i][capacity];
        int skip = profit(i+1, val, wt, capacity, dp);
        if(wt[i] > capacity) return dp[i][capacity] = skip;
        int pick = val[i] + profit(i + 1, val, wt, capacity - wt[i], dp);
        return dp[i][capacity] = Math.max(pick, skip);
    }
    public static void main(String[] args) {
        int[] val = {5,3,9,16};
        int[] wt = {1,2,8,10};
        int C = 8;
        int n = val.length;
        // i = 0 to n-1, capacity = c to 0
        int[][] dp = new int[n][C+1];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++) dp[i][j] = -1;
        System.out.println(profit(0, val, wt, C, dp));
    }
}
