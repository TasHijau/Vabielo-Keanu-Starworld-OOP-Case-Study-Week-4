/**
 * Represents a bank customer.
 * Stores customer personal information and their account.
 */
public class Customer {

    // Customer's first name
    private String firstName;

    // Customer's last name
    private String lastName;

    // Customer's bank account (can be null if not yet created)
    private Account account;

    /**
     * Constructor that initializes customer name.
     */
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns the customer's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the customer's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the customer's account.
     * May return null if account has not been created.
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Assigns an account to the customer.
     */
    public void setAccount(Account account) {
        this.account = account;
    }
}