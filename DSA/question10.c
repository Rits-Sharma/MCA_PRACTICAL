// Q10: Write a program to print the Fibonacci series up to N terms. 

#include<stdio.h>

int main(){
    int n;
    printf("Enter how many Fibonacci numbers to print: ");
    scanf("%d", &n);

    printf("Fibonacci Series: ");
    int first = 0, second = 1, next;
    for (int i = 1; i <= n; i++)
    {
        if (i == 1) printf("%d ",0);
        else if(i == 2) printf("%d ",1);
        else{
            next = first + second;
            printf("%d ",next);
            first = second;
            second = next;
        }
    }
    return 0;
}