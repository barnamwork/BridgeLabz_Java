package level1;

public class UniversityFees {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int fee = 125000;
        int discountPercent=10;
        int discount = fee/discountPercent;
        int finalAmount = fee - discount;
        System.out.println("The discount amount is INR " + discount + " and the final discounted fee is INR "+ finalAmount);

    }

}
