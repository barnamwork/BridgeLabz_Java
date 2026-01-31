/*
 * BankAssociation
 * -------------------
 * This program demonstrates Association.
 * A Bank is associated with Customers.
 * Customers can exist independently of the Bank.
 */

import java.util.ArrayList;

/* Customer class represents a bank customer */
class Customer {

    // Customer name
    private String name;

    // Customer balance
    private double balance;

    // Constructor to initialize customer
    public Customer(String name) {
        this.name = name;
        this.balance = 0;
    }

    // Adds amount to balance
    public void addBalance(double amount) {
        balance += amount;
    }

    // Displays balance
    public void viewBalance() {
        System.out.println(name + "'s balance: " + balance);
    }

    // Returns customer name
    public String getName() {
        return name;
    }
}

/* Bank class associated with customers */
class Bank {

    // Bank name
    private String bankName;

    // List of customers
    private ArrayList<Customer> customers = new ArrayList<>();

    // Constructor to initialize bank
    public Bank(String bankName) {
        this.bankName = bankName;
    }

    // Opens account for a customer
    public void openAccount(Customer customer) {
        customers.add(customer);
        customer.addBalance(1000); // Initial balance
        System.out.println("Account opened for " + customer.getName());
    }
}

/* Main class */
public class BankAssociation {

    public static void main(String[] args) {

        // Creating bank
        Bank bank = new Bank("SBI");

        // Creating customer
        Customer customer = new Customer("Rahul");

        // Bank-customer interaction
        bank.openAccount(customer);
        customer.viewBalance();
    }
}
