//  Q50. Write a program to sort elements in ascending and descending order using Bubble Sort.

#include<stdio.h>

int main(){
    int arr[5] = {12,52,-9,3,45};
    int n = 5;
    
    for (int i = 0; i < n-1; i++) {
        for (int j = 0; j < n-i-1; j++) {
            if (arr[j] < arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }        
    }
    printf("Sorted array in descending order: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    return 0;
}