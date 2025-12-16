// Q17: Write a program to find the second largest number from a given list of input numbers.

#include<stdio.h>
#include <limits.h>

int main(){

    int n[5] = {0};
    printf("Enter 5 numbers: ");
    for (int i = 0; i < 5; i++){
        scanf("%d",&n[i]);
    }
    
    int lar = n[0];
    int secLar = INT_MIN;

    for (int i = 1; i < 5; i++)
    {
        if (n[i]>lar)
        {
            secLar = lar;
            lar = n[i];
        }
        else if (n[i] > secLar && n[i] != lar) {
            secLar = n[i];
        }
    }
    if(secLar == INT_MIN) printf("There is no largest, all are equal to %d", n[0]);
    else printf("Second largest element in inpur numbers: %d",secLar);
    return 0;
}