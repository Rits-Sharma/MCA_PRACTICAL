// Q9: Write a program to reverse the digits of a given number.

#include<stdio.h>

int reverse(int n) {
    int temp, rev = 0;
    while (n != 0) {
        temp = n % 10;
        rev = rev * 10 + temp;
        n = n / 10;
    }
    return rev;
}

int main(){
    int n;
    printf("Enter a number: ");
    scanf("%d", &n);
    n = reverse(n);
    printf("%d\n",n);
    return 0;
}