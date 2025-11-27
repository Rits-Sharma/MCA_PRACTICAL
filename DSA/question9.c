// Q9: Write a program to reverse the digits of a given number.

#include<stdio.h>

void reverse(int n) {
    int temp, rev = 0, copy = n;
    while (n != 0) {
        temp = n % 10;
        rev = rev * 10 + temp;
        n = n / 10;
    }
    printf("%d\n",rev);
}

int main(){
    int n;
    printf("Enter a number: ");
    scanf("%d", &n);
    reverse(n);
    return 0;
}