// Q31. Write a program to reverse a string using a stack.

#include<stdio.h>
#include<string.h>

#define MAX 100
char stack[MAX];
int top = -1;

void push(char value) {
    if(top!=MAX-1) {
        stack[++top] = value;
    }
    else{
        printf("Stack is full.\n");
    }
}
char pop() {
    if(top!=-1) {
        char c = stack[top--];
        return c;
    }
    else{
        printf("Stack is empty.\n");
        return '\0';
    }
}

void reverse(char str[], int n) {
    int i = 0;
    while (i<n) {
        push(str[i]);
        i++;
    }
    while(top!=-1) printf("%c",pop());
}

int main(){
    char str[MAX];
    printf("Enter a string: ");
    fgets(str, MAX, stdin);
    str[strcspn(str, "\n")] = '\0';
    int n = strlen(str);
    reverse(str,n);

    return 0;
}