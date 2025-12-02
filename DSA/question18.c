// Q18: Write a program to calculate the frequency of each character in a given string.

#include<stdio.h>
#include<string.h>

int main(){
    int freqData[256] = {0};
    char str[100];
    printf("Enter a string :");
    gets(str);
    int length = strlen(str);
    for (int i = 0; i < length; i++)
    {
        freqData[(int) str[i]]++;
    }
    for (int i=0;i<256;i++) {
        if (freqData[i]>0) {
            printf("%c occurs %d times\n", i, freqData[i]);
        }
    }
    
    return 0;
}