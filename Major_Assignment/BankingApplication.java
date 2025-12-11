import java.util.Scanner;
class BankingException extends Exception {
    public BankingException(String message) { super(message); }
}
class AccountNotFoundException extends BankingException {
    public AccountNotFoundException(String accountId) { super("Account not found: " + accountId); }
}
class InsufficientFundsException extends BankingException {
    private final double balance;
    private final double amount;
    public InsufficientFundsException(double balance, double amount) {
        super("Insufficient funds. Balance: " + balance + ", Withdrawal attempt: " + amount);
        this.balance = balance;
        this.amount = amount;
    }
    public double getBalance() { return balance; }
    public double getAmount() { return amount; }
}
class UnauthorizedOperationException extends BankingException {
    public UnauthorizedOperationException(String operation) { super("Unauthorized operation: " + operation); }
}
class BankAccount {
    private String accountId;
    private double balance;
    private String password;
    public BankAccount(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }
    public String getAccountId()  { return accountId; }
    public double getBalance()    { return balance; }
    public void setPassword(String password)  { this.password = password; }
    public void deposit(double amount) throws BankingException {
        if (amount <= 0)throw new BankingException("Deposit amount must be greater than zero.");
        balance += amount;
    }
    public void withdraw(double amount, String password) throws InsufficientFundsException, UnauthorizedOperationException, BankingException {
        if (!this.password.equals(password)) throw new UnauthorizedOperationException("Incorrect password for account: " + accountId);
        if (amount <= 0) throw new BankingException("Withdrawal amount must be positive.");
        if (amount > balance) throw new InsufficientFundsException(balance, amount);
        balance -= amount;
    }
}
class BankService {
    public void withdraw(BankAccount account,String password, double amount)throws InsufficientFundsException, AccountNotFoundException, BankingException {
        if (account == null) throw new AccountNotFoundException("Account not found exception.");
        account.withdraw(amount, password);
        System.out.println("Withdrawal successful: " + amount);
    }
    public void deposit(BankAccount account, double amount) throws AccountNotFoundException,  BankingException {
        if (account == null) throw new AccountNotFoundException("Invalid account data.");
        account.deposit(amount);
        System.out.println("Deposit successful: " + amount);
    }
}
public class BankingApplication {  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankService service = new BankService();
        BankAccount acc = new BankAccount("R071", 5000);
        System.out.println("Welcome to the Banking Application!");
        System.out.println("Account ID: " + acc.getAccountId() + "\nCurrent Balance: " + acc.getBalance());
        System.out.print("Set your account password: ");
        acc.setPassword(sc.nextLine());   
        int choice;
        do {
            System.out.println("Banking Menu\n1. Deposit\n2. Withdraw\n0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1 :
                        System.out.print("Enter amount to deposit: ");
                        service.deposit(acc, sc.nextDouble());
                        System.out.println("Current Balance: " + acc.getBalance());
                        break;
                    case 2 :
                        System.out.print("Enter amount to withdraw: ");
                        double amount = sc.nextDouble();
                        System.out.print("Enter password: ");
                        service.withdraw(acc, sc.next(), amount);
                        System.out.println("Current Balance: " + acc.getBalance());
                        break;
                    case 0 : System.out.println("Thank you for using the Banking Application!");
                    break;
                    default: System.out.println("Invalid choice! Please select again.");
                }
            } catch (BankingException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 0);   
        sc.close();
    }    
}