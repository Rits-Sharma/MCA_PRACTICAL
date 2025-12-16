// 11. Create a method that counts how many times a given substring appears in a string.

public class Question11 {
    public static void main(String[] args) {
        String str = "This is the airplane.";
        String sub = "is";
        System.out.println(substring(str, sub));
    }

    public static int substring(String str, String sub) {
        int count = 0;
        str = str.toLowerCase();
        for (int i = 0; i <= str.length()-sub.length(); i++) {
            if (str.substring(i, i + sub.length()).equals(sub)) {
                count++;
            }
        }
        return count;
    }
}
