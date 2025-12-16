//  Q55. Write a C program to solve the 0/1 Knapsack Problem using Dynamic Programming. The program should print the DP table and the selected items.

#include <stdio.h>

int max(int a, int b) { return (a > b) ? a : b; }

int main() {
    int n, capacity;
    printf("Enter number of items: ");
    scanf("%d", &n);
    int weight[n], value[n];
    printf("Enter weights of items: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &weight[i]);
    printf("Enter values of items: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &value[i]);
    printf("Enter Knapsack Capacity: ");
    scanf("%d", &capacity);
    int dp[n + 1][capacity + 1];

    for (int i = 0; i <= n; i++) {
        for (int w = 0; w <= capacity; w++) {
            if (i == 0 || w == 0) dp[i][w] = 0;
            else if (weight[i - 1] <= w)
                dp[i][w] = max(dp[i - 1][w], value[i - 1] + dp[i - 1][w - weight[i - 1]]);
            else
                dp[i][w] = dp[i - 1][w];
        }
    }

    printf("\nDP Table:\n");
    for (int i = 0; i <= n; i++) {
        for (int w = 0; w <= capacity; w++)
            printf("%4d ", dp[i][w]);
        printf("\n");
    }

    int selected[n];
    
    for (int i = 0; i < n; i++)
        selected[i] = 0;

    int w = capacity;
    for (int i = n; i > 0; i--) {
        if (dp[i][w] != dp[i - 1][w]) {
            selected[i - 1] = 1;          // Mark item as selected
            w -= weight[i - 1];          // Reduce capacity by item's weight
        }
    }
    printf("\nMaximum value: %d\n", dp[n][capacity]);
    
    printf("Selected items (1 = selected, 0 = not selected):\n");
    for (int i = 0; i < n; i++)
        printf("Item %d: %d\n", i + 1, selected[i]);
    return 0;
}