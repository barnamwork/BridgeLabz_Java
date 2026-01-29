package level2;

// This class simulates ATM operations using a parameterized constructor

class BankATM {

    String accountHolder;
    long accountNumber;
    double balance;

    // Parameterized Constructor
    BankATM(String accountHolder, long accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amt) {
        balance += amt;
    }

    void withdraw(double amt) {
        if (amt <= balance)
            balance -= amt;
        else
            System.out.println("Insufficient Balance");
    }

    void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Current Balance: " + balance);
    }

    public static void main(String[] args) {
        BankATM acc = new BankATM("Rohit", 123456, 5000);

        acc.deposit(2000);
        acc.withdraw(1000);
        acc.displayBalance();
    }
}

