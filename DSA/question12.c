//  Q12: Write a program to check whether a given number is prime or not.

#include<stdio.h>
#include<math.h>
/*
void isPrime(int n){
    if(n <= 1) {
        printf("Not prime\n");
        return;
    }
    for (int i = 2; i <= (n/2); i++)
    {
        if (n % i == 0)
        {
            printf("Not prime\n");
            return;
        }
    }
    printf("Prime\n");
}
*/
void isPrime(int n){
    if(n <= 1) {
        printf("Not prime\n");
        return;
    }
    for (int i = 2; i <= sqrt(n); i++)
    {
        if (n % i == 0)
        {
            printf("Not prime\n");
            return;
        }
    }
    printf("Prime\n");
}

int main(){
    int n;
    printf("Enter a number : ");
    scanf("%d",&n);

    isPrime(n);

    return 0;
}