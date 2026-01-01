//  10. Write a method that checks whether two strings are anagrams of each other (contain the same characters in a different order).

public class Question10 {
    public static void main(String[] args) {
        String str1 = "aabb";
        String str2 = "baBa";
        System.out.println(isAnagram(str1, str2));
    }

    public static boolean isAnagram(String str1, String str2) {
        if(str1.length() != str2.length()) return false;
        int[] str1data = new int[26];
        int[] str2data = new int[26];
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for (int i = 0; i < str1.length(); i++) {
            str1data[(int)str1.charAt(i) - 'a'] += 1;
            str2data[(int)str2.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if(str1data[i] != str2data[i]) return false;
        }
        return true;
    }
}
