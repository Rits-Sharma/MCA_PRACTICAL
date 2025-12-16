#include <stdio.h>

// Recursive function
int knapsack(int i, int *val, int *wt, int capacity, int n) {
    if (i == n) return 0; // base case: no items left
    // Skip current item
    int skip = knapsack(i + 1, val, wt, capacity, n);
    // If current item can't fit, return skip
    if (wt[i] > capacity) return skip;
    // Pick current item
    int pick = val[i] + knapsack(i + 1, val, wt, capacity - wt[i], n);
    // Return max of pick and skip
    return (pick > skip) ? pick : skip;
}

int main() {
    int wt[] = {2,3,4,5};
    int val[] = {3,4,5,6};
    int C = 5;
    int n = sizeof(val) / sizeof(val[0]);

    int maxProfit = knapsack(0, val, wt, C, n);

    printf("Maximum Profit: %d\n", maxProfit);

    return 0;
}
