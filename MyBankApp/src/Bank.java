import java.util.ArrayList;

/**
 * Represents the bank system.
 * Responsible for managing customers and their accounts.
 */
public class Bank {

    // Name of the bank
    private String bankName;

    // List that stores all customers
    private ArrayList<Customer> customers = new ArrayList<>();

    /**
     * Constructor that sets the bank name.
     */
    public Bank(String bankName) {
        this.bankName = bankName;
    }

    /**
     * Returns the bank name.
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Adds a new customer to the bank.
     */
    public void addCustomer(String fName, String lName) {
        customers.add(new Customer(fName, lName));
    }

    /**
     * Returns total number of customers.
     */
    public int getNumberOfCustomers() {
        return customers.size();
    }

    /**
     * Returns customer at a specific index.
     */
    public Customer getCustomer(int index) {
        return customers.get(index);
    }

    /**
     * Searches customers by first name.
     * Returns a list of matching customers.
     */
    public ArrayList<Customer> findCustomer(String firstName) {
        ArrayList<Customer> result = new ArrayList<>();

        for (Customer c : customers) {
            if (c.getFirstName().equalsIgnoreCase(firstName)) {
                result.add(c);
            }
        }
        return result;
    }

    /**
     * Searches for a specific customer by first and last name.
     * Returns the customer if found, otherwise null.
     */
    public Customer findCustomer(String firstName, String lastName) {
        for (Customer c : customers) {
            if (c.getFirstName().equalsIgnoreCase(firstName) &&
                c.getLastName().equalsIgnoreCase(lastName)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Deletes a customer from the bank.
     * Returns true if successfully removed.
     */
    public boolean deleteCustomer(Customer customer) {
        return customers.remove(customer);
    }

    /**
     * Creates an account for a customer if they do not already have one.
     * Returns true if account is created, false otherwise.
     */
    public boolean createAccount(Customer customer) {
        if (customer.getAccount() == null) {
            Account account = new Account();
            customer.setAccount(account);
            return true;
        } else {
            return false;
        }
    }
}