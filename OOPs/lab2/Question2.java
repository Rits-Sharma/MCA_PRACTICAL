// 2. Create a class BankAccount with a static variable totalAccounts that tracks the number of accounts created. Use a static method to print the total number of accounts. Also, initialize this static variable using a static block.

class BankAccount {
    static int totalAccounts;
    static {
        totalAccounts = 0;
        System.out.println("Static block executed.");
    }
    public BankAccount() {
        totalAccounts++;
    }
    static void print() {
        System.out.println(totalAccounts);
    }
}

public class L2_Question2 {
    public static void main(String[] args) {
        BankAccount b = new BankAccount();
        BankAccount b2 = new BankAccount();
        BankAccount.print();
    }
}

