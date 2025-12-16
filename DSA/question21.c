// Q21: Write a C program to swap two numbers using a call-by-reference function.

#include<stdio.h>

// swap is done by Call by value  --> if only made changes inside the function, works only on copied value

// swap is done here by Call by reference  --> if made changes outside the function, works on original value
void swap(int *x, int *y){
    int temp = *x;
    *x = *y;
    *y = temp;
    printf("During swapping: a = %d, b = %d\n", *x, *y);
}

int main(){
    int a, b;
    printf("Enter two numbers for swapping: ");
    scanf("%d %d", &a, &b);
    printf("Before swapping: a = %d, b = %d\n",a,b);
    swap(&a, &b);
    printf("After swapping: a = %d, b = %d\n",a,b);

    return 0;
}