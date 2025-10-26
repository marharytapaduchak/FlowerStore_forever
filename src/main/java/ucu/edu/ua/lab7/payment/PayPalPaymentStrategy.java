package ucu.edu.ua.lab7.payment;

public class PayPalPaymentStrategy implements Payment{
    @Override
    public String pay(double amount) {
        return "Paid " + amount + " using PayPal.";
    }
}
