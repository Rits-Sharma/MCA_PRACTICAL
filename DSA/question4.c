// Q4: Write a C program that takes input from the user and performs the following operations in one program:
// Subtract AND assignment (-=)
// Multiply AND assignment (*=)
// Divide AND assignment (/=)
// Modulus AND assignment (%=)
// Bitwise AND assignment (&=)
// Bitwise OR assignment (|=)
// Bitwise XOR assignment (^=)
// Right shift assignment (>>=)
// Left shift assignment (<<=)
// Logical AND (&&)
// Logical OR (||)

#include <stdio.h>

int main() {
    int a, b;
    printf("Enter two integers: ");
    scanf("%d %d", &a, &b);

    // Subtract AND assignment
    a -= b;
    printf("After a -= b: %d\n", a);

    // Reset a for next operation
    a += b;

    // Multiply AND assignment
    a *= b;
    printf("After a *= b: %d\n", a);

    // Reset a for next operation
    a /= b;

    // Divide AND assignment
    a /= b;
    printf("After a /= b: %d\n", a);

    // Reset a for next operation
    a *= b;

    // Modulus AND assignment
    a %= b;
    printf("After a %%= b: %d\n", a);

    // Reset a for next operation
    a += b;

    // Bitwise AND assignment
    a &= b;
    printf("After a &= b: %d\n", a);

    // Reset a for next operation
    a |= b;

    // Bitwise OR assignment
    a |= b;
    printf("After a |= b: %d\n", a);

    // Reset a for next operation
    a ^= b;

    // Bitwise XOR assignment
    a ^= b;
    printf("After a ^= b: %d\n", a);

    // Reset a for next operation
    a <<= 1;

    // Left shift assignment
    a <<= 1;
    printf("After a <<= 1: %d\n", a);

    // Reset a for next operation
    a >>= 1;

    // Right shift assignment
    a >>= 1;
    printf("After a >>= 1: %d\n", a);

    // Logical AND
    int logical_and = (a && b);
    printf("Logical AND (a && b): %d\n", logical_and);

    // Logical OR
    int logical_or = (a || b);
    printf("Logical OR (a || b): %d\n", logical_or);

    return 0;
}