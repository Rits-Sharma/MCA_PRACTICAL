// Q3: Write a C program to calculate the area and volume of a sphere, where the radius is entered by the user.

#include<stdio.h>

void areaVolume(int radius){
    printf("Area of sphere is %.2f \nVolume is %.2f\n",(4*3.14*radius*radius), ((4/3)*(3.14*radius*radius*radius)));
}

int main(){
    areaVolume(7);
    return 0;
}