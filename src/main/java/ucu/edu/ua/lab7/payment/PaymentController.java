package ucu.edu.ua.lab7.payment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @GetMapping("/pay")
    public String pay(@RequestParam String method, @RequestParam double amount) {
        Payment strategy;
        switch (method.toLowerCase()) {
            case "credit" -> strategy = new CreditCardPaymentStrategy();
            case "paypal" -> strategy = new PayPalPaymentStrategy();
            default -> { return "Unknown payment method: " + method; }
        }
        return strategy.pay(amount);
    }
}
