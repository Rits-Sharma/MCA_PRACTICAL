// Q33. Write a program to convert an infix expression to postfix expression.

#include <stdio.h>
#include <string.h>
#include <ctype.h>   // for isalnum()

#define MAX 20

char stack[MAX];
int top = -1;

void push(char n) {
    stack[++top] = n;
}

char pop() {
    if (top == -1) return -1;
    else return stack[top--];
}

int priority(char x) {
    if (x == '(') return 0;
    if (x == '+' || x == '-') return 1;
    if (x == '*' || x == '/') return 2;
    return -1;
}

int main() {
    char exp[MAX], x;
    printf("Enter the expression: ");
    scanf("%s", exp);

    char *e = exp;

    printf("Postfix expression: ");
    while (*e != '\0') {
        if (isalnum(*e)) {
            // Operand → directly print
            printf("%c", *e);
        } else if (*e == '(') {
            push(*e);
        } else if (*e == ')') {
            // Pop until '('
            while ((x = pop()) != '(') {
                printf("%c", x);
            }
        } else {
            // Operator → pop higher/equal priority operators
            while (top != -1 && priority(stack[top]) >= priority(*e)) {
                printf("%c", pop());
            }
            push(*e);
        }
        e++;
    }

    // Pop remaining operators
    while (top != -1) {
        printf("%c", pop());
    }

    printf("\n");
    return 0;
}