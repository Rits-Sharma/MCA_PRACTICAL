#include<stdio.h>


//function to find factorial
int fact(int n){
    if(n == 0 || n == 1) return 1;
    else return n * fact(n-1);
}

int main(){   
    int n;
    printf("Enter number to find factorial : ");
    scanf("%d", &n);
    printf("Factorial of n is %d", fact(n));
    return 0;
}