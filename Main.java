import java.util.*;

public class Main {

    static ArrayList<User> users = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while(true) {
            System.out.println("\n===== BANKING SYSTEM =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            switch(choice) {
                case 1: register(); break;
                case 2: login(); break;
                case 3: System.exit(0);
            }
        }
    }

    static void register() {
        System.out.print("Enter name: ");
        String name = sc.next();

        System.out.print("Set password: ");
        String password = sc.next();

        int accNo = 1000 + users.size();

        User user = new User(name, password, accNo, 0);
        users.add(user);

        System.out.println("Account Created! Account No: " + accNo);
    }

    static void login() {
        System.out.print("Enter account number: ");
        int acc = sc.nextInt();

        System.out.print("Enter password: ");
        String pass = sc.next();

        for(User u : users) {
            if(u.accountNumber == acc && u.password.equals(pass)) {
                System.out.println("Login Successful!");
                userMenu(u);
                return;
            }
        }

        System.out.println("Invalid credentials!");
    }

    static void userMenu(User user) {
        while(true) {
            System.out.println("\n--- USER MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Transfer Money");
            System.out.println("6. Logout");

            int ch = sc.nextInt();

            switch(ch) {
                case 1:
                    System.out.print("Enter amount: ");
                    user.deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    user.withdraw(sc.nextDouble());
                    break;

                case 3:
                    System.out.println("Balance: " + user.balance);
                    break;

                case 4:
                    user.showTransactions();
                    break;

                case 5:
                    System.out.print("Enter receiver account number: ");
                    int recAcc = sc.nextInt();

                    User receiver = null;

                    for(User u : users) {
                        if(u.accountNumber == recAcc) {
                            receiver = u;
                            break;
                        }
                    }

                    if(receiver == null) {
                        System.out.println("Account not found!");
                        break;
                    }

                    System.out.print("Enter amount: ");
                    double amt = sc.nextDouble();

                    user.transfer(receiver, amt);
                    break;

                case 6:
                    return;
            }
        }
    }
}