#include<stdio.h>

int max(int a, int b) { return a>b ? a : b; }
#define n 4

int main(){
    int weight[n] = {3, 4, 6, 5};
    int val[n] = {2,3,1,4};
    int capacity = 8;

    int dp[n+1][capacity+1];
    for (int i = 0; i <= n; i++) {
        for(int j = 0; j <= capacity; j++) {
            if(i==0 || j==0) dp[i][j] = 0;
            else if(j < weight[i-1]) dp[i][j] = dp[i-1][j];
            else dp[i][j] = max(dp[i-1][j], val[i-1] + dp[i-1][j - weight[i-1]]);
        }
    }
    printf("Optimal solution : %d", dp[n][capacity]);

    return 0;
}