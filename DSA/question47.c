//  Q47. Binary search (iterative)

#include<stdio.h>

int binarySearch(int arr[], int n, int key) {
    int low = 0, high = n-1;
    while(low <= high) {
        int mid = low + (high-low)/2;
        if(key == arr[mid]) return mid;
        else if (key > arr[mid]) {
            low = mid+1;
        } else
            high = mid-1;
    }
    return -1;
}

int main(){
    int n;
    printf("Enter the number of elements: ");
    scanf("%d", &n);

    int arr[n];
    printf("Enter the elements in array in ascending order: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }
    
    int flag = binarySearch(arr, n, 23);
    if(flag!=-1) printf("Found");
    else printf("Not found");

    return 0;
}