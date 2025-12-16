// 4. Create a method that merges two sorted integer arrays into a single sorted array.

public class Question4 {
    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7};
        int[] arr2 = {1,2,4,6};
        int[] merged = merged(arr1, arr2);
        for (int i : merged)
            System.out.print(i + " ");
    }
    
    public static int[] merged(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length+arr2.length];
        int i = 0, j = 0, k = 0;
        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] <= arr2[j]) {
                merged[k] = arr1[i];
                i++; k++;
            }else {
                merged[k] = arr2[j];
                j++; k++;
            }
        }
        while (i < arr1.length) {
            merged[k] = arr1[i];
            i++; k++;
        }
        while (j < arr2.length) {
            merged[k] = arr2[j];
            j++; k++;
        }
        return merged;
    }
}
