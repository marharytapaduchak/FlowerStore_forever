package ucu.edu.ua.lab7.order.dto;

public class OrderResponse {
    public double total;
    public String deliveryMessage;
    public String paymentMessage;

    public OrderResponse(double total, String deliveryMessage, String paymentMessage) {
        this.total = total;
        this.deliveryMessage = deliveryMessage;
        this.paymentMessage = paymentMessage;
    }
}
