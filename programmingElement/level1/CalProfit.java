package level1;

public class CalProfit {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int costPrice=129;
        int sellingPrice=191;
        int profit=sellingPrice-costPrice;
        double percentage=((double)profit/(double)costPrice)*100;
        System.out.println("The Cost Price is INR "+costPrice + " and Selling Price is INR "+sellingPrice +"\nThe Profit is INR "+profit+" and the Profit Percentage is "+ percentage);

    }
}

