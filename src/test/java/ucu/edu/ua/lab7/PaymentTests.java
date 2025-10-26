package ucu.edu.ua.lab7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ucu.edu.ua.lab7.payment.CreditCardPaymentStrategy;
import ucu.edu.ua.lab7.payment.PayPalPaymentStrategy;

public class PaymentTests {

    @Test
    void creditCardStrategy_returnsMessageWithAmount() {
        var s = new CreditCardPaymentStrategy();
        String msg = s.pay(250.0);
        assertTrue(msg.toLowerCase().contains("credit"));
        assertTrue(msg.contains("250"));
    }

    @Test
    void payPalStrategy_returnsMessageWithAmount() {
        var s = new PayPalPaymentStrategy();
        String msg = s.pay(99.99);
        assertTrue(msg.toLowerCase().contains("paypal"));
        assertTrue(msg.contains("99.99"));
    }
}
