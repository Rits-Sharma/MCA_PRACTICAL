#include<stdio.h>

void reverse(int n) {
    int temp, rev = 0, copy = n;
    while (n != 0) {
        temp = n % 10;
        rev = rev * 10 + temp;
        n = n / 10;
    }
    printf("%d\n",rev);
    printf("%s\n",(rev == copy) ? "Palindrome" : "Not Palindrome");
}




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


int main(){
    int n;
    printf("Enter a number : ");
    scanf("%d",&n);

    reverse(n);
    isPrime(n);

    // int a = 9, b = 4, sum = 0;
    // (a<b) ? printf("%d\n",a) : printf("%d\n",b);

    // for (int i = 0; i <= 10; i++)
    // {
    //     sum += i;
    // }
    // printf("%d\n",sum);
    // switch (n)
    // {
    // case 1:
    //     printf("One");
    //     break;
    // case 2:
    //     printf("Two");
    //     break;
    // default:
    //     printf("default");
    //     break;
    // }
    return 0;
}