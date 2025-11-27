// Q11: Write a C program to print the Fibonacci series up to N terms using recursion.

#include <stdio.h>

// Function to compute the nth Fibonacci number
int fibo(int n) {
    if (n == 0)
        return 0;
    else if (n == 1)
        return 1;
    else
        return fibo(n - 1) + fibo(n - 2);
}

int main() {
    int n;
    printf("Enter how many Fibonacci numbers to print: ");
    scanf("%d", &n);

    printf("Fibonacci Series: ");
    // using recursion -->
    for (int i = 0; i < n; i++) {
        printf("%d ", fibo(i));
    }

    printf("\n");
    return 0;
}
