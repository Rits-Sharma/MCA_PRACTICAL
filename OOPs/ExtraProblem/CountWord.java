public class CountWord {
    public static void main(String[] args) {
        String str = "Hello from main method";
        String[] words = str.trim().split("\\s+");
        int count = 0;
        for (String ele : words) {
            count++;
        }
        System.out.println("Number of words: " + count);
    }
}
