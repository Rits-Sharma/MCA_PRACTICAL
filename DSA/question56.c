//  Q56. You are given n songs with durations d₁, d₂, …, dₙ. You want to create a playlist whose total duration is exactly D by selecting any combination of these songs. Write a program that determines whether such a playlist is possible.

#include <stdio.h>
// ------------------------ Subset (Dynamic Programming) -----------------------
int subsetDP(int arr[], int n, int D) {
    int dp[D + 1];

    for (int i = 0; i <= D; i++) dp[i] = 0;
    dp[0] = 1;

    for (int i = 0; i < n; i++) {
        for (int j = D; j >= arr[i]; j--) {
            if (dp[j - arr[i]])
                dp[j] = 1;
        }
    }
    return dp[D];
}
// ------------------------ Exhaustive Search (Backtracking) -----------------------
int exhaustiveSearch(int arr[], int n, int D, int index) {
    if (D == 0) return 1;
    if (index == n || D < 0) return 0;
    if (exhaustiveSearch(arr, n, D - arr[index], index + 1))
        return 1;
    return exhaustiveSearch(arr, n, D, index + 1);
}

int main() {
    int n, D;
    printf("Enter number of songs: ");
    scanf("%d", &n);
    int d[n];
    printf("Enter durations of %d songs:\n", n);
    for (int i = 0; i < n; i++) scanf("%d", &d[i]);
    printf("Enter required total duration D: ");
    scanf("%d", &D);
    // Using DP method
    if (subsetDP(d, n, D))
        printf("\n[DP] Playlist with total duration %d IS possible.\n", D);
    else
        printf("\n[DP] Playlist with total duration %d is NOT possible.\n", D);
    // Using Exhaustive Search
    if (exhaustiveSearch(d, n, D, 0))
        printf("[Exhaustive Search] Playlist with total duration %d IS possible.\n", D);
    else
        printf("[Exhaustive Search] Playlist with total duration %d is NOT possible.\n", D);
    /*
    // ----------------------------- PRINTING ALGORITHMS -----------------------------
    printf("\n\n===== ALGORITHM: SUBSET SUM (Dynamic Programming) =====\n");
    printf("INPUT: Number of songs n.\n");
    printf("        Song durations d1, d2, â€¦, dn\n");
    printf("        Target duration D\n");
    printf("OUTPUT: Playlist with total duration D is possible or Not\n");
    printf("\n===== STEPS =====\n");
    printf("1. Create an array dp[] of size D+1 and initialize all entries to 0.\n");
    printf("2. Set dp[0] = 1 because sum 0 is always achievable.\n");
    printf("3. For each song duration di:\n");
    printf("      For j from D down to di:\n");
    printf("          If dp[j - di] is 1, set dp[j] = 1.\n");
    printf("4. If dp[D] == 1, a playlist with exact duration D exists.\n");

    printf("\nTime Complexity (DP): O(n * D)\n");
    printf("Space Complexity (DP): O(D)\n");

    printf("\n===== ALGORITHM: EXHAUSTIVE SEARCH (Backtracking) =====\n");
    printf("INPUT: Number of songs n.\n");
    printf("        Song durations d1, d2, â€¦, dn\n");
    printf("        Target duration D\n");
    printf("OUTPUT: Playlist with total duration D is possible or Not\n");
    printf("\n===== STEPS =====\n");
    printf("1. Define a recursive function solve(index, remainingSum).\n");
    printf("2. If remainingSum == 0, return TRUE (solution found).\n");
    printf("3. If index == n OR remainingSum < 0, return FALSE.\n");
    printf("4. Recursively try two possibilities:\n");
    printf("      a. Include current song\n");
    printf("      b. Exclude current song\n");
    printf("5. If any recursive call returns TRUE, playlist exists.\n");

    printf("\nTime Complexity (Exhaustive Search): O(2^n)\n");
    printf("Space Complexity (Exhaustive Search): O(n) due to recursion stack\n");
    */
    return 0;
}