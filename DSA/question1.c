// Q1: Write a C program that displays your details such as name, mobile number, course, and department.

#include<stdio.h>

int main(){
    char name[20], mobile[10], course[15], department[20];
    printf("Enter your name : ");
    gets(name);
    printf("Enter your mobile no. : ");
    gets(mobile);
    printf("Enter your course : ");
    gets(course);
    printf("Enter your department : ");
    gets(department);
    printf("Welcome %s, you enrolled with %s in %s department and your mobile no. is %s",name, course, department, mobile);
    return 0;
}