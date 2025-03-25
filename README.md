# Bank Account App

This is a simple Java console application that simulates a basic banking system. Users can log in with a PIN, check their balance, deposit funds, and withdraw money.

## 🧾 Features

- Load accounts from a CSV file
- PIN-based login
- Balance inquiry
- Deposit and withdrawal operations
- Basic error handling for incorrect PINs and insufficient funds

## 📁 Files

- `BankAccount.java`: Defines the `BankAccount` class with methods to deposit, withdraw, and check balances.
- `Main.java`: Contains the main logic for reading accounts from a CSV file and interacting with the user.
- `accounts.csv`: CSV file containing account data in the format: `PIN,Name,Balance`.

## 🧪 Sample CSV Format

PIN,Name,Balance 
1234,John Doe,5000.0 
4321,Jane Smith,7500.0

## ▶️ How to Run

1. Compile the files:
   ```bash javac Main.java BankAccount.java
      java Main
