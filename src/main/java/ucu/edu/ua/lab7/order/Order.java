package ucu.edu.ua.lab7.order;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import ucu.edu.ua.lab7.payment.Payment;
import ucu.edu.ua.lab7.delivery.Delivery;
import ucu.edu.ua.lab7.item.Item;

public class Order {

    private final LinkedList<Item> items = new LinkedList<>();
    private Payment payment;
    private Delivery delivery;

    public void setPaymentStrategy(Payment payment) {
        this.payment = payment;
    }

    public void setDeliveryStrategy(Delivery delivery) {
        this.delivery = delivery;
    }

    public void addItem(Item item) {
        if (item != null) items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public double calculateTotalPrice() {
        return items.stream()
                .mapToDouble(Item::price)
                .sum();
    }

    public String processOrder() {
        if (items.isEmpty()) {
            return "Order is empty, nothing to process.";
        }
        if (delivery == null) {
            return "Delivery strategy is not set.";
        }
        if (payment == null) {
            return "Payment strategy is not set.";
        }

        String deliveryResult = delivery.deliver(items);
        double total = calculateTotalPrice();
        String paymentResult = payment.pay(total);

        return "Delivery: " + deliveryResult + " | Payment: " + paymentResult + " | Total: " + total;
    }
}
