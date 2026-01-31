package  inheritance;

public class Order {
    int orderId;
    String date;

    Order(int orderId, String date){
        this.orderId=orderId;
        this.date=date;
    }

    void getOrderStatus(){
        System.out.println("OrderId : "+ orderId);
        System.out.println("Date : "+ date);
    }

    static void main() {
        Order order = new Order (0, "");
        ShippedOrder shippedOrder = new ShippedOrder(1,"21st Jan 2026", 1234);
        DeliveredOrder deliveredOrder = new DeliveredOrder(2,"21st Jan 2026", 5678, "31st Jan 2026");
        order.getOrderStatus();
        System.out.println();
        shippedOrder.getOrderStatus();
        System.out.println();
        deliveredOrder.getOrderStatus();
    }

}
class ShippedOrder extends Order{
    int trackingNumber;

    ShippedOrder(int orderId, String date, int trackingNumber){
        super(orderId, date);
        this.trackingNumber=trackingNumber;
    }

    @Override
    void getOrderStatus(){
        super.getOrderStatus();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}
class DeliveredOrder extends ShippedOrder{
    String deliveryDate;

    DeliveredOrder(int orderId, String date, int trackingNumber, String deliveryDate){
        super(orderId, date, trackingNumber);
        this.deliveryDate=deliveryDate;
    }

    @Override
    void getOrderStatus(){
        super.getOrderStatus();
        System.out.println("Delivery Date: " + deliveryDate);
    }
}