//  Q48. Binary search (Recursive)

#include<stdio.h>

int binarySearch(int arr[], int low, int high, int key) {
    if (low > high) {
        return -1;
    }
    int mid = low + (high-low)/2;
    if (key == arr[mid]) {
        return mid;
    } else if (key < arr[mid]) {
        return binarySearch(arr, low, mid-1, key);
    } else {
        return binarySearch(arr, mid+1, high, key);
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
    
    int flag = binarySearch(arr, 0, n-1, 14);
    if(flag!=-1) printf("Found");
    else printf("Not found");

    return 0;
}