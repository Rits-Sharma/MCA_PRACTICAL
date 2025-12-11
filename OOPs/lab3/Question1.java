public class Question1 {
    public static void main(String[] args) {
        int[] arr = {12,5,32,5,6};
        int n = arr.length;
        int i = 0, j = n-1;
        while(i <= j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }
}
