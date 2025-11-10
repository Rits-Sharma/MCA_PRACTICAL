#include<stdio.h>
#include <limits.h>

int main(){

    int n[] = {32,32,5,12,-65};
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
    if(secLar == INT_MIN) printf("There is no largest");
    else printf("%d",secLar);
    return 0;
}