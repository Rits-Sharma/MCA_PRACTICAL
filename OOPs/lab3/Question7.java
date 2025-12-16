//  7. Create a method that counts the number of vowels and consonants in a given string.

import java.util.Scanner;

public class Question7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        System.out.print("Enter a string: ");
        str = sc.nextLine();
        char[] ch = str.toLowerCase().toCharArray();
        int[] count = count(ch);
        System.out.printf("Vowel: %d, Consonant: %d", count[0], count[1]);
        sc.close();
    }

    public static int[] count(char[] ch) {
        int[] count = new int[2];
        int vowel = 0, consonant = 0;
        for (int i = 0; i < ch.length; i++) {
            if(ch[i] >= 'a' && ch[i] <= 'z') {
                if(ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u') vowel++;
                else consonant++;
            }
        }
        count[0] = vowel; count[1] = consonant;
        return count;
    }
}
