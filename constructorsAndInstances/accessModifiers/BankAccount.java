package accessmodifiers;

import java.util.Scanner;

class BankAccount {

    public int accountNumber;        // public
    protected String accountHolder;  // protected
    private double balance;          // private

    // public methods for private balance
    public void setBalance(double b) {
        balance = b;
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SavingsAccount s = new SavingsAccount();

        System.out.print("Account Number: ");
        s.accountNumber = sc.nextInt();
        sc.nextLine();

        System.out.print("Account Holder: ");
        s.accountHolder = sc.nextLine();

        System.out.print("Balance: ");
        double b = sc.nextDouble();
        s.setBalance(b);

        s.display();
        System.out.println("Balance: " + s.getBalance());
    }
}

class SavingsAccount extends BankAccount {

    void display() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Holder: " + accountHolder);
    }
}
