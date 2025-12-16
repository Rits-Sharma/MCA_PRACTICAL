// 3. Write a method that checks if there are any duplicate elements in an integer array. Return true if duplicates exist, otherwise return false.

import java.util.HashSet;

public class Question3 {
    public static void main(String[] args) {
        int[] arr = {12,5,3,892};
        int[] arr1 = {12,5,3,12,892};
        System.out.println("Dublicate: " + dublicate(arr));
        System.out.println("Dublicate: " + hasDuplicates(arr1));
    }

    public static boolean dublicate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++)
                if(arr[i] == arr[j]) return true;
        }
        return false;
    }

    public static boolean hasDuplicates(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (!set.add(num)) return true;
        }
        return false;
    }
}
