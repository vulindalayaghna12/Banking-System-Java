import java.util.ArrayList;

public class User {
    String name;
    String password;
    int accountNumber;
    double balance;
    ArrayList<String> transactions = new ArrayList<>();

    public User(String name, String password, int accountNumber, double balance) {
        this.name = name;
        this.password = password;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: " + amount + " | Balance: " + balance);
        System.out.println("Deposited successfully!");
    }

    void withdraw(double amount) {
        if(balance >= amount) {
            balance -= amount;
            transactions.add("Withdrawn: " + amount + " | Balance: " + balance);
            System.out.println("Withdraw successful!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void transfer(User receiver, double amount) {
        if(this.balance >= amount) {
            this.balance -= amount;
            receiver.balance += amount;

            this.transactions.add("Transferred " + amount + " to Acc No: " + receiver.accountNumber);
            receiver.transactions.add("Received " + amount + " from Acc No: " + this.accountNumber);

            System.out.println("Transfer successful!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void showTransactions() {
        System.out.println("\nTransaction History:");
        for(String t : transactions) {
            System.out.println(t);
        }
    }
}