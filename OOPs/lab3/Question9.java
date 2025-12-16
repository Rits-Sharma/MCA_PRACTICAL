//  9. Create a method that returns the first non-repeated character in a string. If there are no non-repeated characters, return a special value (like null).

public class Question9 {
    public static void main(String[] args) {
        String str = "Ritesh Sharma";
        System.out.println(repeated(str.toLowerCase().toCharArray()));
    }

    public static char repeated(char[] ch) {
        for (int i = 0; i < ch.length; i++) {
            int count = 1;
            for (int j = i+1; j < ch.length; j++) {
                if(ch[i] == ch[j]) count++;
            }
            if(count == 1) return ch[i];
        }
        return '\0';
    }
}
