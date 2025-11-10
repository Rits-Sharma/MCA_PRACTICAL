#include<stdio.h>

void areaR(int length, int width){
    printf("Area of rectangle is %d\n", length * width);
}

void areaVolume(int radius){
    printf("Area of sphere is %.2f and volume is %.2f\n",(4*3.14*radius*radius), ((4/3)*(3.14*radius*radius*radius)));
}

int main(){
    areaR(12,10);
    areaVolume(7);

    

    return 0;
}