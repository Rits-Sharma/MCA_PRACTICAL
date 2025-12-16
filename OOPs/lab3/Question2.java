// 2. Create a method that accepts an array of integers and returns the maximum and minimum values found in the array.

public class Question2 {
    public static void main(String[] args) {
        int[] arr = {12,5,-32,5,6};
        int n = arr.length;
        int[] result = findMinMax(arr, n);
        System.out.println("Minimum: " + result[0] + ", Maximum: " + result[1]);
    }

    public static int[] findMinMax(int[] arr, int n) {
        int[] ans = new int[2];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if(arr[i] > max) max = arr[i];
            if(arr[i] < min) min = arr[i];
        }
        ans[0] = min; ans[1] = max;
        return ans;
    }
}
