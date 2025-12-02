// Q29. Write a C program to reverse a string using pointers.

#include<stdio.h>
#include<string.h>

void reverse(char *str, int n) {
    int i = 0, j = n-1;
    while (i < j)
    {
        char *a = &str[i];
        char *b = &str[j];
        int temp = *a;
        *a = *b;
        *b = temp;
        i++; j--;
    } 
}

int main(){
    char s[25];
    printf("Enter a string: ");
    fgets(s, sizeof(s), stdin);
    s[strcspn(s, "\n")] = '\0'; // Remove newline character
    int n = strlen(s);
    printf("Before reverse : %s\n",s);
    reverse(s, n);
    printf("After reverse : %s\n",s);

    return 0;
}