//  Q14: Write a C program to check whether a given string is a palindrome or not.

#include<stdio.h>

int main(){
    char c[] = "hellolleh";
    int length = strlen(c);
    int i = 0, j = length - 1; // -2 to ignore null terminator
    int flag = 1;
    while(i < j){
        if(c[i] != c[j]){
            flag = 0;
            break;
        }
        i++; j--;
    }
    if(flag == 0) printf("Not palindrome\n");
    else printf("Palindrome");
    return 0;
}