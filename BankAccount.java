public class BankAccount{
    private long pin;
    private String accountHolder;
    private double balance;

    public BankAccount(long login_pin, String name, double startingBalance) {
        pin = login_pin;
        accountHolder = name;
        balance = startingBalance;
    }

    public boolean confirm_pin(long typed_pin){
        if (pin == typed_pin){
            return true;
        }else{
            return false;
        }
    }

    public String getAccountHolder(){
        return accountHolder;
    }

    public void deposit(double amount) {
        if (amount > 0){
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > balance){
            System.out.println("Insufficient funds. Withdrawal denied.");
        }else{
            balance -= amount;
            System.out.println("Withdrawl Successful");
        }
    }

    public double getBalance() {
        return balance;
    }
}