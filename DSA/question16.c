// Q16: Write a program to check whether a given character is a vowel or a consonant.

#include<stdio.h>

void check(char ch){
    if ((ch >= 'a' && ch <= 'z')  || (ch >= 'A' && ch <= 'Z')){
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
            printf("%c is vowel",ch);
        } else{
            printf("%c is consonant",ch);
        }
    } else printf("Not a character");
}

int main(){
    char ch;
    printf("Enter a character : ");
    scanf("%c", &ch);
    check(ch);

    return 0;
}