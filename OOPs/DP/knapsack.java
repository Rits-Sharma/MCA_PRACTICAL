public class knapsack {

    public static int profit(int i, int[] val, int[] wt, int capacity) {
        if(i == val.length) return 0;
        int skip = profit(i+1, val, wt, capacity);
        if(wt[i] > capacity) return skip;
        int pick = val[i] + profit(i + 1, val, wt, capacity - wt[i]);
        return Math.max(pick, skip);
    }

    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int C = 50;
        System.out.println(profit(0, val, wt, C));
    }
}
