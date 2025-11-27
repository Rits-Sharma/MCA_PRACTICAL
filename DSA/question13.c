//  Q13: Write a C program to check whether a given number is a palindrome or not.

#include<stdio.h>

void palindrome(int n) {
    int temp, rev = 0, copy = n;
    while (copy != 0) {
        temp = copy % 10;
        rev = rev * 10 + temp;
        copy = copy / 10;
    }
    printf("%s\n",(rev == n) ? "Palindrome" : "Not Palindrome");
}

int main(){
    int n;
    printf("Enter a number : ");
    scanf("%d",&n);
    palindrome(n);
    return 0;
}