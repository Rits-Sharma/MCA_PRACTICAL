#include<stdio.h>

int factorial(int num){
    if(num == 0 || num == 1) return 1;
    else{
        return num * factorial(num -1);
    }
}

int nCr (int rows, int a){
    return factorial(rows) / (factorial(a) * factorial(rows - a));
}

int main(){
    int n ;
    printf("Enter number of rows : ");
    scanf("%d",&n);

    printf("Pascal's Triangle : \n");
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n - i; j++)
        {
            printf("  ");
        }
        for (int j = 0; j <= i; j++)
        {
            printf("%4d",nCr(i,j));
        }
        printf("\n");
    }
    
    return 0;
}