import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountHolderName;
    private double balance;

    public Account(String accountHolderName) {
        this.accountHolderName = accountHolderName;
        this.balance = 0.0;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }
}

//main function

public class SimpleBankingApp {
    private static ArrayList<Account> ac = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n--- Simple Banking Application ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    running = false;
                    System.out.println("Thank you for using the banking application!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void createAccount() {
        System.out.print("Enter account holder's name: ");
        String name = sc.nextLine();

        // Check if the account already exists
        if (findAccount(name) != null) {
            System.out.println("An account already exists for " + name + ". Please use a different name.");
            return;
        }

        Account newAccount = new Account(name);
        ac.add(newAccount);
        System.out.println("Account created for " + name);
    }

    //For deposit money
    private static void depositMoney() {
        System.out.print("Enter account holder's name: ");
        String name = sc.nextLine();
        Account account = findAccount(name);
        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = sc.nextDouble();
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdrawMoney() {
        System.out.print("Enter account holder's name: ");
        String name = sc.nextLine();
        Account account = findAccount(name);

        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = sc.nextDouble();
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void checkBalance() {
        System.out.print("Enter account holder's name: ");
        String name = sc.nextLine();
        Account account = findAccount(name);

        if (account != null) {
            System.out.println("Current balance for " + name + ": $" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private static Account findAccount(String name) {
        for (Account account : ac) {
            if (account.getAccountHolderName().equalsIgnoreCase(name)) {
                return account;
            }
        }
        return null; // Account not found
    }
    
}