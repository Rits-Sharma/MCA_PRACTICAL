// Q28. Write a C program to sort an array using pointers.

#include<stdio.h>

void sort(int *arr, int n){
    for (int i = 0; i < n-1; i++){
        for (int j = 0; j < n-i-1; j++){
            int *a = arr + j;
            int *b = arr + j + 1;
            if (*a > *b){
                int temp = *a;
                *a = *b;
                *b = temp;
            }   
        }
    }
}

int main(){
    int arr[] = {1,5,4,6,-8};
    int n = sizeof(arr) / sizeof(arr[0]);
    printf("Array before sorting: ");
    for (int i = 0; i < n; i++){
        printf("%d ", arr[i]);
    }
    printf("\n");
    sort(arr,n);
    printf("Array after sorting: ");
    for (int i = 0; i < n; i++){
        printf("%d ", arr[i]);
    }

    return 0;
}