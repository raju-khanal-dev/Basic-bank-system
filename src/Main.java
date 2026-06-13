import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    private String holderName;
    private int accountNumber;
    private int pin;
    private double balance;
    private ArrayList<String> history;

    public BankAccount(String holderName, int accountNumber, int pin, double balance) {
        this.holderName = holderName;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
        history = new ArrayList<>();
        history.add("Account created with Rs. " + balance);
    }

    public boolean login(int enteredPin) {
        return pin == enteredPin;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            history.add("Deposited Rs. " + amount);
            System.out.println("Deposit Successful!");
        } else {
            System.out.println("Invalid Amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid Amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient Balance!");
        } else {
            balance -= amount;
            history.add("Withdrawn Rs. " + amount);
            System.out.println("Withdrawal Successful!");
        }
    }

    public void showBalance() {
        System.out.println("Current Balance: Rs. " + balance);
    }

    public void showDetails() {
        System.out.println("\n===== ACCOUNT DETAILS =====");
        System.out.println("Account Holder : " + holderName);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Balance        : Rs. " + balance);
    }

    public void showHistory() {
        System.out.println("\n===== TRANSACTION HISTORY =====");
        for (String transaction : history) {
            System.out.println(transaction);
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== CREATE ACCOUNT =====");

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        int accountNo = sc.nextInt();

        System.out.print("Set 4-Digit PIN: ");
        int pin = sc.nextInt();

        System.out.print("Initial Deposit: ");
        double balance = sc.nextDouble();

        BankAccount account =
                new BankAccount(name, accountNo, pin, balance);

        System.out.println("\nAccount Created Successfully!");

        System.out.println("\n===== LOGIN =====");

        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();

        if (!account.login(enteredPin)) {
            System.out.println("Incorrect PIN!");
            return;
        }

        int choice;

        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Details");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Choose Option: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Amount: ");
                    account.deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter Amount: ");
                    account.withdraw(sc.nextDouble());
                    break;

                case 3:
                    account.showBalance();
                    break;

                case 4:
                    account.showDetails();
                    break;

                case 5:
                    account.showHistory();
                    break;

                case 6:
                    System.out.println("Thank You For Banking With Us!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}