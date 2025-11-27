// Q46. Linear search

#include<stdio.h>

int linearSearch(int arr[], int n, int value) {
    for (int i = 0; i < n; i++) {
        if (value == arr[i]) {
            return i;
        }
    }
    return -1;
}

int main(){
    int n, val;
    printf("Enter the number of elements: ");
    scanf("%d", &n);
    int arr[n];
    
    printf("Enter the elements: ");
    for(int i = 0;i < n;i++) {
        scanf("%d", &arr[i]);
    }

    printf("Enter number to be search: ");
    scanf("%d", &val);
    int ans = linearSearch(arr, n, val);
    if(ans != -1) {
        printf("%d found at %d", val, ans);
    } else {
        printf("%d not found!", val);
    }

    return 0;
}