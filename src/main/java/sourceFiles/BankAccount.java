package sourceFiles;

public class BankAccount {
    private String accountId;
    private double balance;

    public BankAccount(String accountId, double initialBalance) {
        this.accountId = accountId;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public String getAccountInfo() {
        return "Account ID: " + accountId + ", Balance: $" + balance;
    }
}
