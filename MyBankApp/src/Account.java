/**
 * Represents a bank account.
 * Handles all account-related transactions such as
 * deposit, withdrawal, and transfer.
 */
public class Account {

    // Stores the current balance of the account
    private double balance;

    /**
     * Default constructor.
     * Initializes account with minimum starting balance of 1000.
     */
    public Account() {
        this.balance = 1000;
    }

    /**
     * Overloaded constructor.
     * If the provided balance is greater than 1000,
     * it will be used. Otherwise, default 1000 is set.
     */
    public Account(double balance) {
        if (balance > 1000) {
            this.balance = balance;
        } else {
            this.balance = 1000.0;
        }
    }

    /**
     * Returns the current balance of the account.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Deposits money into the account.
     * @param amt Amount to deposit
     * @return true if successful, false if invalid amount
     */
    public boolean deposit(double amt) {
        if (amt > 0.0) {
            balance += amt;
            return true;
        }
        return false;
    }

    /**
     * Withdraws money from the account.
     * @param amt Amount to withdraw
     * @return true if successful, false if insufficient balance or invalid amount
     */
    public boolean withdraw(double amt) {
        if (amt > 0 && amt <= balance) {
            balance -= amt;
            return true;
        }
        return false;
    }

    /**
     * Transfers money to another account.
     * @param target Target account
     * @param amount Amount to transfer
     * @return true if transfer successful, false otherwise
     */
    public boolean transfer(Account target, double amount) {
        if (target == null) {
            return false;
        }

        if (withdraw(amount)) {
            target.deposit(amount);
            return true;
        }

        return false;
    }
}