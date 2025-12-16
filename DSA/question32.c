// Q32. Write a program to evaluate a postfix expression using a stack.

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

#define MAX 50

int stack[MAX];
int top = -1;

int isEmpty() {
    return (top == -1);
}

int isFull() {
    return (top == MAX - 1);
}

void push(int value) {
    if (isFull()) {
        printf("Stack overflow!\n");
        exit(1);
    } else {
        stack[++top] = value;
    }
}

int pop() {
    if (isEmpty()) {
        printf("Wrong expression is given!\n");
        exit(1);
    } else {
        return stack[top--];
    }
}

int evaluatePostfix(char *exp) {
    for (int i = 0; exp[i] != '\0'; i++) {
        char ch = exp[i];

        if (isdigit(ch)) {
            push(ch - '0');  // convert char digit to int
        } else if (ch == ' ') {
            continue;        // ignore spaces
        } else {
            int val2 = pop();
            int val1 = pop();

            switch (ch) {
                case '+': push(val1 + val2); break;
                case '-': push(val1 - val2); break;
                case '*': push(val1 * val2); break;
                case '/':
                    if (val2 == 0) {
                        printf("Division by zero error!\n");
                        exit(1);
                    }
                    push(val1 / val2);
                    break;
                default:
                    printf("Invalid operator: %c\n", ch);
                    exit(1);
            }
        }
    }
    return pop();
}

int main() {
    char exp[] = "23*54*+9-";  // postfix expression

    int ans = evaluatePostfix(exp);
    printf("The result of the postfix expression %s is: %d\n", exp, ans);

    return 0;
}