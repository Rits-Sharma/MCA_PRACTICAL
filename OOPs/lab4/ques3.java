class Chain {
    public Chain step1() {
        System.out.println("Step 1");
        return this; // returning the current object
    }

    public Chain step2() {
        System.out.println("Step 2");
        return this;
    }

    public Chain step3() {
        System.out.println("Step 3");
        return this;
    }
}

public class ques3{
    public static void main(String[] args) {
        Chain chain = new Chain();
        chain.step1().step2().step3(); // method chaining
    }
}