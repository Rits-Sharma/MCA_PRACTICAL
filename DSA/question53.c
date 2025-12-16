//  Q53. Write a program to implement Insertion Sort.

#include<stdio.h>

int main(){
    int arr[5] = {12,52,-9,3,45};
    int n = 5;

    for (int i = 1; i < n; i++) {
        for(int j = i; j > 0; j--) {
            if(arr[j] < arr[j-1]) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
    }
    /*
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;

        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
    */

    for (int i = 0; i < n; i++) printf("%d ",arr[i]);

    return 0;
}