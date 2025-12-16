//  Q54. Write a program to implement Quick Sort.

#include<stdio.h>

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

int partition(int arr[], int low, int high) {
    int pivot = arr[low];
    int start = low, end = high;
    while(start < end) {
        while(arr[start] <= pivot) start++;
        while(arr[end] > pivot) end--;
        if(start < end) swap(&arr[start], &arr[end]);
    }
    swap(&arr[low], &arr[end]);
    return end;
}


void quickSort(int arr[], int low, int high) {
    if(low < high) {
        int pivot = partition(arr, low, high);
        quickSort(arr, low, pivot-1);
        quickSort(arr, pivot+1, high);
    }
}

int main(){
    int n;
    printf("Enter the number of elements: ");
    scanf("%d", &n);
    int arr[n];
    printf("Enter the value of array: ");
    for (int i = 0; i < n; i++) scanf("%d", &arr[i]);
    
    quickSort(arr, 0, n-1);

    printf("Sorted Array: ");
    for (int i = 0; i < n; i++) printf("%d ", arr[i]);

    return 0;
}