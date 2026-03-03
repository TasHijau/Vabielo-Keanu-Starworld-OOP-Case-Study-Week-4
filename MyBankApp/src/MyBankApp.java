import java.util.ArrayList;
import java.util.Scanner;

/**
 * NOTE:
 * AI assistance (ChatGPT) was used to
 * help generate and improve code comments.
 */

/**
 * Main application class.
 * Provides console-based interface for both Admin and Customer operations.
 */
public class MyBankApp {

    public static void main(String[] args) {

        // Scanner for user input
        Scanner sc = new Scanner(System.in);

        // Create bank instance
        Bank b1 = new Bank("BanKuMike");

        // Main program loop (runs until user chooses Exit)
        while (true) {

            System.out.println("Welcome to " + b1.getBankName());
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();   // clear input buffer

            switch (choice) {

                // =========================
                // ADMIN MENU
                // =========================
                case 1:

                    while (true) {

                        System.out.println("\n--- Admin Menu ---");
                        System.out.println("1. Add Customer");
                        System.out.println("2. Search Customer");
                        System.out.println("3. Delete Customer");
                        System.out.println("4. Display Customers");
                        System.out.println("5. Create Account");
                        System.out.println("6. Back");

                        System.out.print("Choose: ");
                        int adminChoice = sc.nextInt();
                        sc.nextLine();

                        switch (adminChoice) {

                            // Add Customer
                            case 1:
                                System.out.print("Enter First Name: ");
                                String fName = sc.nextLine();

                                System.out.print("Enter Last Name: ");
                                String lName = sc.nextLine();

                                b1.addCustomer(fName, lName);
                                System.out.println("Customer successfully added.");
                                break;

                            // Search Customer
                            case 2:
                                System.out.print("Enter First Name: ");
                                String searchName = sc.nextLine();

                                ArrayList<Customer> results = b1.findCustomer(searchName);

                                if (results.isEmpty()) {
                                    System.out.println("No customer found.");
                                } else {
                                    for (int i = 0; i < results.size(); i++) {
                                        Customer c = results.get(i);
                                        System.out.println((i + 1) + ". " +
                                                c.getFirstName() + " " + c.getLastName());

                                        if (c.getAccount() == null) {
                                            System.out.println("   No account.");
                                        } else {
                                            System.out.println("   Balance: " +
                                                    c.getAccount().getBalance());
                                        }
                                    }
                                }
                                break;

                            // Delete Customer
                            case 3:
                                System.out.print("Enter First Name: ");
                                String deleteName = sc.nextLine();

                                ArrayList<Customer> deleteResults = b1.findCustomer(deleteName);

                                if (deleteResults.isEmpty()) {
                                    System.out.println("No customer found.");
                                } else if (deleteResults.size() == 1) {
                                    b1.deleteCustomer(deleteResults.get(0));
                                    System.out.println("Customer deleted.");
                                } else {
                                    for (int i = 0; i < deleteResults.size(); i++) {
                                        Customer c = deleteResults.get(i);
                                        System.out.println((i + 1) + ". " +
                                                c.getFirstName() + " " + c.getLastName());
                                    }

                                    System.out.print("Select customer to delete: ");
                                    int selection = sc.nextInt();
                                    sc.nextLine();

                                    if (selection >= 1 &&
                                            selection <= deleteResults.size()) {
                                        b1.deleteCustomer(
                                                deleteResults.get(selection - 1));
                                        System.out.println("Customer deleted.");
                                    } else {
                                        System.out.println("Invalid selection.");
                                    }
                                }
                                break;

                            // Display All Customers
                            case 4:
                                if (b1.getNumberOfCustomers() == 0) {
                                    System.out.println("No customers available.");
                                } else {
                                    for (int i = 0;
                                        i < b1.getNumberOfCustomers(); i++) {
                                        Customer c = b1.getCustomer(i);
                                        System.out.println((i + 1) + ". " +
                                                c.getFirstName() + " " +
                                                c.getLastName());
                                    }
                                }
                                break;

                            // Create Account
                            case 5:
                                System.out.print("Enter First Name: ");
                                String accountName = sc.nextLine();

                                ArrayList<Customer> accountResults =
                                        b1.findCustomer(accountName);

                                if (accountResults.isEmpty()) {
                                    System.out.println("No customer found.");
                                } else if (accountResults.size() == 1) {

                                    if (b1.createAccount(accountResults.get(0))) {
                                        System.out.println("Account successfully created.");
                                    } else {
                                        System.out.println("Customer already has an account.");
                                    }

                                } else {
                                    for (int i = 0; i < accountResults.size(); i++) {
                                        Customer c = accountResults.get(i);
                                        System.out.println((i + 1) + ". " +
                                                c.getFirstName() + " " +
                                                c.getLastName());
                                    }

                                    System.out.print("Select customer: ");
                                    int selection = sc.nextInt();
                                    sc.nextLine();

                                    if (selection >= 1 &&
                                            selection <= accountResults.size()) {

                                        if (b1.createAccount(
                                                accountResults.get(selection - 1))) {
                                            System.out.println("Account successfully created.");
                                        } else {
                                            System.out.println("Customer already has an account.");
                                        }
                                    } else {
                                        System.out.println("Invalid selection.");
                                    }
                                }
                                break;

                            // Back to Main Menu
                            case 6:
                                break;
                        }

                        if (adminChoice == 6) {
                            break;
                        }
                    }
                    break;

                // =========================
                // CUSTOMER MENU
                // =========================
                case 2:

                    System.out.print("Enter First Name: ");
                    String fName = sc.nextLine();

                    System.out.print("Enter Last Name: ");
                    String lName = sc.nextLine();

                    Customer currentCustomer =
                            b1.findCustomer(fName, lName);

                    if (currentCustomer == null) {
                        System.out.println("Customer not found.");
                        break;
                    }

                    if (currentCustomer.getAccount() == null) {
                        System.out.println("No account found. Please contact admin.");
                        break;
                    }

                    while (true) {

                        System.out.println("\n--- Customer Menu ---");
                        System.out.println("1. Balance Inquiry");
                        System.out.println("2. Deposit");
                        System.out.println("3. Withdraw");
                        System.out.println("4. Transfer");
                        System.out.println("5. Logout");

                        System.out.print("Choose: ");
                        int customerChoice = sc.nextInt();
                        sc.nextLine();

                        switch (customerChoice) {

                            case 1:
                                System.out.println("Balance: " +
                                        currentCustomer.getAccount().getBalance());
                                break;

                            case 2:
                                System.out.print("Enter amount to deposit: ");
                                double depositAmount = sc.nextDouble();
                                sc.nextLine();

                                if (currentCustomer.getAccount()
                                        .deposit(depositAmount)) {
                                    System.out.println("Deposit successful.");
                                    System.out.println("New Balance: " +
                                            currentCustomer.getAccount().getBalance());
                                } else {
                                    System.out.println("Transaction failed.");
                                }
                                break;

                            case 3:
                                System.out.print("Enter amount to withdraw: ");
                                double withdrawAmount = sc.nextDouble();
                                sc.nextLine();

                                if (currentCustomer.getAccount()
                                        .withdraw(withdrawAmount)) {
                                    System.out.println("Withdrawal successful.");
                                    System.out.println("New Balance: " +
                                            currentCustomer.getAccount().getBalance());
                                } else {
                                    System.out.println("Transaction failed.");
                                }
                                break;

                            case 4:
                                System.out.print("Enter target First Name: ");
                                String targetFName = sc.nextLine();

                                System.out.print("Enter target Last Name: ");
                                String targetLName = sc.nextLine();

                                Customer targetCustomer =
                                        b1.findCustomer(targetFName, targetLName);

                                if (targetCustomer == null) {
                                    System.out.println("Target customer not found.");
                                    break;
                                }

                                if (targetCustomer == currentCustomer) {
                                    System.out.println("Cannot transfer to yourself.");
                                    break;
                                }

                                if (targetCustomer.getAccount() == null) {
                                    System.out.println("Target has no account.");
                                    break;
                                }

                                System.out.print("Enter amount to transfer: ");
                                double transferAmount = sc.nextDouble();
                                sc.nextLine();

                                if (currentCustomer.getAccount()
                                        .transfer(targetCustomer.getAccount(),
                                                transferAmount)) {
                                    System.out.println("Transfer successful.");
                                    System.out.println("Your New Balance: " +
                                            currentCustomer.getAccount().getBalance());
                                } else {
                                    System.out.println("Transfer failed.");
                                }
                                break;

                            case 5:
                                break;
                        }

                        if (customerChoice == 5) {
                            break;
                        }
                    }
                    break;

                // Exit Program
                case 3:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}