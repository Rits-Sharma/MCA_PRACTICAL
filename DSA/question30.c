// Q30. Write a program to implement a stack using an array.

#include<stdio.h>
#include<limits.h>

#define MAX 10

int stack[MAX];
int top = -1;

int isEmpty(){
    return (top == -1);
}

int isFull(){
    return (top == MAX-1);
}

void push(int value) {
    if(!isFull()) {
        stack[++top] = value;
        printf("%d pushed into stack.\n", value);
    }
    else{
        printf("Stack is full.\n");
    }
}

int pop() {
    if(!isEmpty()) {
        int n = stack[top--];
        printf("%d popped from stack.\n", n);
        return n;
    }
    else{
        printf("Stack is empty.\n");
        return -1;
    }
}

int peek() {
    if (!isEmpty()) {
        printf("Top element: %d\n", stack[top]);
        return stack[top];
    }
    else {
        printf("Stack is empty.\n");
        return INT_MIN;
    }
}

int main(){
    push(10);
    push(30);
    push(1);
    push(0);
    push(15);
    peek();
    pop();
    peek();
    return 0;
}