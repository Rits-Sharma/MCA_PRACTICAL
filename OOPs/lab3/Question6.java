// 6. Write a method that checks whether a given string is a palindrome (reads the same forwards and backwards).

public class Question6 {
    public static void main(String[] args) {
        String str = "hellleh";
        char[] ch = str.toCharArray();
        System.out.println(palindrome(ch));
    }

    public static boolean palindrome(char[] ch) {
        int len = ch.length;
        int i = 0, j = len-1;
        while (i < j) {
            if(ch[i] != ch[j]) return false;
            i++; j--;
        }
        return true;
    }
}
