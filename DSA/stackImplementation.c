// Q30. Write a program to implement a stack using an array.

#include<stdio.h>

#define MAX 10

int stack[MAX];
int top = -1;

void push(int n) {
    if(top == MAX - 1) {
        printf("Stack Overflow\n");
        return;
    }
    stack[++top] = n;
    printf("%d pushed into stack.\n", n);
}

int pop() {
    if (top == -1){
        printf("Stack is empty.\n");
    }
    int n = stack[top];
    printf("%d popped from stack.\n");
    top--;
    return n;
}

int peek() {
    if (top == -1){
        printf("Stack is empty.\n");
    }
    return stack[top];
}

void display(){
    for (int i = top; i >= 0; i--)
    {
        printf("%d ",stack[i]);
    } 
}

int main(){
    printf("Stack operations:\n");
    push(12);
    push(23);
    push(4);
    push(52);
    push(-9);
    push(23);
    pop();
    int n = peek();
    printf("%d\n",n);

    display();
    return 0;
}