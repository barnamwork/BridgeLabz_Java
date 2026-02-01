package inheritance;

public class BankAccount {
    int accNo;

    BankAccount(int accNo){
        this.accNo = accNo;
    }

    void displayAccountType(){
        System.out.println("Account no: " + accNo);

    }

    public static void main() {
        BankAccount bankaccount = new BankAccount(101);
        bankaccount.displayAccountType();
        System.out.println();

        SavingsAccount savingaccount = new SavingsAccount(102, 8.5);
        savingaccount.displayAccountType();
        System.out.println();

        CheckingAmount checkingamount = new CheckingAmount(103, 120000.0);
        checkingamount.displayAccountType();
        System.out.println();

        FixedDepositAccount fixed = new FixedDepositAccount(104, 7.5);
        fixed.displayAccountType();
        System.out.println();
    }

}
class SavingsAccount extends BankAccount{
    double interestRate;

    SavingsAccount(int accNo, double interestRate){
        super(accNo);
        this.interestRate = interestRate;
    }

    void displayAccountType(){
        System.out.println("Account no: " + accNo);
        System.out.println("Interest Rate: " + interestRate);
    }
}
class CheckingAmount extends BankAccount{
    double withdrawalLimit;

    CheckingAmount(int accNo, double withdrawalLimit){
        super(accNo);
        this.withdrawalLimit=withdrawalLimit;
    }

    void displayAccountType(){
        System.out.println("Account no: " + accNo);
        System.out.println("Withdrawal Limit: " + withdrawalLimit);
    }
}
class FixedDepositAccount extends BankAccount{

    double fixedRate;
    FixedDepositAccount(int accNo, double fixedRate){
        super(accNo);
        this.fixedRate=fixedRate;
    }
    void displayAccountType(){
        System.out.println("Account no: " + accNo);
        System.out.println("Fixed Rate: " + fixedRate);
    }
}

