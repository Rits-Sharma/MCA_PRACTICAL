// 11. Create a method that counts how many times a given substring appears in a string.

public class Question11 {
    public static void main(String[] args) {
        String str = "This is the airplane.";
        String sub = "is";
        System.out.println("Occurence of '" + sub + "' in '" + str + "' : " + countSubstring(str, sub));
    }

    public static int substring(String str, String sub) {
        int count = 0;
        str = str.toLowerCase();
        sub = sub.toLowerCase();
        for (int i = 0; i <= str.length()-sub.length(); i++) {
            if (str.substring(i, i + sub.length()).equals(sub)) {
                count++;
            }
        }
        return count;
    }

    public static int countSubstring(String str, String sub) {
        int count = 0;

        // Loop through the main string
        for (int i = 0; i <= str.length() - sub.length(); i++) {
            int j;

            // Check substring match
            for (j = 0; j < sub.length(); j++) {
                if (str.charAt(i + j) != sub.charAt(j)) {
                    break;
                }
            }

            // If full substring matched
            if (j == sub.length()) {
                count++;
            }
        }
        return count;
    }
}
