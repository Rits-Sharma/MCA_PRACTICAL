// Q6: Write a C program to find the greater of two numbers without using if statement.

#include<stdio.h>

int main(){
    int a, b;
    printf("Enter two numbers: ");
    scanf("%d %d", &a, &b);

    a > b ? printf("%d is greater then %d", a, b) : printf("%d is greater then %d", b, a);

    return 0;
}