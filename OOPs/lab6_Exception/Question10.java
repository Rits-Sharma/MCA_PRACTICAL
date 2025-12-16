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
    int balance = 1000;
    static Scanner sc = new Scanner(System.in);
    boolean isLockedAcc = false;

    public int deposit () throws InvalidAmountException, AccountLockedException {
        int amt;
        System.out.print("Enter balance to deposit: ");
        amt = sc.nextInt();
        if(isLockedAcc) throw new AccountLockedException("Your account is locked, Can't do transaction.");
        if(amt < 0) {
            throw new InvalidAmountException("Negative balance can't be deposited.");
        }
        balance += amt;
        System.out.println("Remaining balance: " + balance);
        return balance;
    }
    public int withdrawal () throws InsufficientFundsException, InvalidAmountException, AccountLockedException {
        int amt;
        System.out.print("Enter balance to withdraw: ");
        amt = sc.nextInt();
        if(isLockedAcc) throw new AccountLockedException("Your account is locked, Can't do transaction.");
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
        while(true) {
            int n;
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Deposit. ");
            System.out.println("2. Withdrawal. ");
            System.out.println("0. Exit. ");
            System.out.print("Enter number to do opertion: ");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    try{
                        bA.deposit();
                    } catch (InvalidAmountException | AccountLockedException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                
                case 2:
                    try{
                        bA.withdrawal();
                    } catch (InsufficientFundsException | InvalidAmountException | AccountLockedException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 0:
                    sc.close();
                    return;

                default:
                    break;
            } sc.close();
        }
    }
}
