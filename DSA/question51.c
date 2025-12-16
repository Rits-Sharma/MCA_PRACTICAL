//  Q51. Write a program to count the number of swaps and comparisons made during Bubble Sort.

#include<stdio.h>

int main(){
    int arr[5] = {12,52,-9,3,45};
    int n = 5;
    int swap = 0;
    for (int i = 0; i < n-1; i++) {
        for (int j = 0; j < n-i-1; j++) {
            if (arr[j] < arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                swap++;
            }
        }        
    }
    printf("Sorted array in descending order: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }

    printf("\nNumber of swaps : %d", swap);
    return 0;
}