// Q5: Write a C program that takes an integer input from the user and displays the corresponding day of the week using a switch statement.

#include<stdio.h>

int main(){
    int n;
    printf("Enter a no. (e.g.- 1-Sunday, 2-Monday..) : ");
    scanf("%d",&n);

    switch (n)
    {
    case 1:
        printf("Sunday");
        break;
    case 2:
        printf("Monday");
        break;
    case 3:
        printf("Tuesday");
        break;
    case 4:
        printf("Wednesday");
        break;
    case 5:
        printf("Thursday");
        break;
    case 6:
        printf("Friday");
        break;
    case 7:
        printf("Saturday");
        break;
    default:
        printf("Invalid Input");
        break;
    }
    return 0;
}