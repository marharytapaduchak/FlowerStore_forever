package ucu.edu.ua.lab7.payment;

public class CreditCardPaymentStrategy implements Payment {
    @Override
    public String pay(double amount) {
        return "Paid " + amount + " using Credit Card.";
    }
}
