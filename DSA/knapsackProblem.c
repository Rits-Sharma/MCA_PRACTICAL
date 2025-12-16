#include<stdio.h>

int max(int a, int b) { return a>b ? a : b; }
#define n 4

int main(){
    int weight[n] = {1,2,8,10};
    int val[n] = {5,3,7,14};
    int capacity = 8;
    
    int dp[n+1][capacity+1];
    for (int i = 0; i <= n; i++) {
        for(int j = 0; j <= capacity; j++) {
            if(i==0 || j==0) dp[i][j] = 0;
            else if(j < weight[i-1]) dp[i][j] = dp[i-1][j];
            else dp[i][j] = max(dp[i-1][j], val[i-1] + dp[i-1][j-weight[i-1]]);
        }
    }
    printf("Optimal solution : %d", dp[n][capacity]);

    printf("\nDP Table : ");
    for (int i = 0; i <= n; i++) {
        if( i!= 0) printf("           ");
        for (int j = 0; j <= capacity; j++) printf("%d   ", dp[i][j]);
        printf("\n");
    }

    int selected[n];
    for (int i = 0; i < n; i++) selected[i] = 0;
    int w = capacity;
    for (int i = n; i > 0; i--) {
        if (dp[i][w] != dp[i - 1][w]) {
            selected[i - 1] = 1;          // Mark item as selected
            w -= weight[i - 1];          // Reduce capacity by item's weight
        }
    }    
    printf("Selected items (1 = selected, 0 = not selected):\n");
    for (int i = 0; i < n; i++) printf("Item %d: %d\n", i + 1, selected[i]);
    return 0;
}