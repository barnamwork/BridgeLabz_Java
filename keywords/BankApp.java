package keywords;

/**
 * The BankAccount class represents a bank account with static bank name and account count, private holder name, and final account number.
 * It demonstrates static, private, final keywords, and instanceof operator.
 */
class BankAccount{
    static String bankName = "Indian Bank";
    static int noOfAccount = 0;

    private String accountHolderName;
    private final long accountNumber;

    BankAccount(String accountHolderName,long accountNumber){
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        noOfAccount++;
    }

    // Method to display account details using instanceof check
    public void displayDetails(){
        if(this instanceof BankAccount) {
            System.out.println("Bank Name : " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
        }else{
            System.out.println("Invalid object");
        }
    }

    // Static method to get total number of accounts
    public static int getTotalAccounts(){
        return noOfAccount;
    }
}

/**
 * The BankApp class demonstrates the use of various Java keywords in a banking application context.
 */
public class BankApp {
    public static void main(String[] args){
        BankAccount acc1 = new BankAccount("Aayush", 6752439998911L);
        BankAccount acc2 = new BankAccount("Gautam", 5788882734766L);

        acc1.displayDetails();
        System.out.println("--------------------------------");
        acc2.displayDetails();

        System.out.println("\nTotal number of accounts: " + BankAccount.getTotalAccounts());
    }
}