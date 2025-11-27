// Q20: Write a C program to swap two numbers using a call-by-value function.

#include<stdio.h>

void swap(int x, int y){
    int temp = x;
    x = y;
    y = temp;
    printf("During swapping : a = %d, b = %d\n", x, y);
}

int main(){
    int a, b;
    printf("Enter two numbers for swapping: ");
    scanf("%d %d", &a, &b);
    printf("Before swapping: a = %d, b = %d\n",a,b);
    swap(a, b) ;
    printf("After swapping: a = %d, b = %d\n",a,b);
    
    return 0;
}

