// 5. Write a method that rotates an array to the right by a given number of steps.

public class Question5 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7};
        int k = 2;
        int[] res = rotateRight(arr, k);
        for (int i : res) System.out.print(i + " ");
    }

    public static int[] rotateRight(int[] arr, int k) {
        int n = arr.length;
        k = k % n;      // for maintaining k within bounds
        int[] result = new int[n];
        for (int i = 0; i < n; i++)
            result[(i + k) % n] = arr[i];
        return result;
    }

    public static void rotateRight2(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }
    private static int[] reverse(int[] arr, int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++; end--;
        }
        return arr;
    }
}
