//  8. Write a method that reverses the characters in a given string.

public class Question8 {
    public static void main(String[] args) {
        String str = "hello hi";
        char[] ch = str.toCharArray();
        String reversed = new String(reverse(ch));
        System.out.println(reversed);
    }

    public static char[] reverse(char[] ch) {
        int i = 0, j = ch.length-1;
        while (i < j) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++; j--;
        }
        return ch;
    }
}
