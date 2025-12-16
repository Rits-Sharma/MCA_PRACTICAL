//  Q52. Write a program to implement Selection Sort on an array of numbers.

#include<stdio.h>

int main(){
    int arr[5] = {1,22,4,8,-3};
    int n = sizeof(arr) / sizeof(arr[0]);
    for(int i = 0; i < n-1; i++) {
        int index = i;
        for (int j = i+1; j < n; j++) {
            if(arr[j] < arr[index]) index = j;
        }
        if(index != i) {
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
    for (int i = 0; i < 5; i++) printf("%d ", arr[i]);
    
    return 0;
}