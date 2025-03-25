import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String fileName = "accounts.csv";
        BankAccount[] accounts = new BankAccount[100];
        try {
            File writer = new File(fileName);
            Scanner fileScanner = new Scanner(writer);
            // skip header column names
            if (fileScanner.hasNextLine()) {
                fileScanner.nextLine(); 
            }
            int account_nums = 0;

            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] values = line.split(",");
                long pin = Long.parseLong(values[0]);
                String name = values[1];
                double balance = Double.parseDouble(values[2]);

                BankAccount acc = new BankAccount(pin, name, balance);
                accounts[account_nums] = acc;
                account_nums++;
            }
            fileScanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        accounts[0] = new BankAccount(5132, "Evan", 8000.0);
        accounts[1] = new BankAccount(1234, "Sam", 4000.0);
        accounts[2] = new BankAccount(9084, "Michael", 10000.0);

        Scanner scanner = new Scanner(System.in);
        BankAccount foundAccount = null;
        boolean pin_found = false;

        while (!pin_found) {
            System.out.print("Please enter your pin number: ");
            long pin = scanner.nextLong();
            scanner.nextLine(); // eat newline

            for (int i = 0; i < accounts.length; i++) {
                if (accounts[i].confirm_pin(pin)) {
                    foundAccount = accounts[i];
                    pin_found = true;
                    break;
                }
            }

            if (foundAccount == null) {
                System.out.println("Invalid PIN. Try again.");
            }
        }

        boolean exit_status = false;
        while (!exit_status) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("-(S) Show Balance\n-(W) Withdraw\n-(D) Deposit\n-(E) Exit");
            String action = scanner.nextLine().toLowerCase();

            switch (action) {
                case "s":
                case "show":
                    System.out.println("Amount: $" + foundAccount.getBalance());
                    break;
                case "w":
                case "withdraw":
                    System.out.print("Enter amount to withdraw: ");
                    double with_amount = scanner.nextDouble();
                    scanner.nextLine(); // eat newline
                    foundAccount.withdraw(with_amount);
                    break;
                case "d":
                case "deposit":
                    System.out.print("Enter amount to deposit: ");
                    double dep_amount = scanner.nextDouble();
                    scanner.nextLine(); // eat newline
                    foundAccount.deposit(dep_amount);
                    break;
                case "e":
                case "exit":
                    exit_status = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
        System.out.println("Thank you for using our banking system!");
    }
}
