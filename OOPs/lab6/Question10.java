// Question 10: Comprehensive Banking Application
// Develop a simple banking application with a BankAccount class that has methods for deposit and withdrawal. Implement the following exception handling:
// •InsufficientFundsException- thrown when withdrawal balance exceeds balance
// • InvalidAmountException- thrown for negative deposit/withdrawal amounts
// • AccountLockedException- thrown when operating on a locked account
// Create a menu-driven program to test all these scenarios.

import java.util.Scanner;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class AccountLockedException extends Exception {
    public AccountLockedException(String message) {
        super(message);
    }
}



class BankAccount {
    static int balance = 1000;
    static Scanner sc = new Scanner(System.in);

    public static int deposit () throws InvalidAmountException {
        int amt;
        System.out.print("Enter balance to deposit: ");
        amt = sc.nextInt();
        if(amt < 0) {
            throw new InvalidAmountException("Negative balance can't be deposited.");
        }
        balance += amt;
        System.out.println("Remaining balance: " + balance);
        return balance;
    }
    public static int withdrawal () throws InsufficientFundsException, InvalidAmountException {
        int amt;
        System.out.print("Enter balance to withdraw: ");
        Scanner sc = new Scanner(System.in);
        amt = sc.nextInt();
        if(amt > balance) {
            throw new InsufficientFundsException("Insufficient balance : Can't do withdrawal.");
        }
        if(amt < 0) {
            throw new InvalidAmountException("Negative balance can't be withdrawn.");
        }
        balance -= amt;
        System.out.println("Remaining balance: " + balance);
        return balance;
    }
}

public class Question10 {
    public static void main(String[] args) {
        BankAccount bA = new BankAccount();
        try {
            bA.withdrawal();
            bA.deposit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
