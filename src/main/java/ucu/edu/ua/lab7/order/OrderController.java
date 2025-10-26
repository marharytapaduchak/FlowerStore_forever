package ucu.edu.ua.lab7.order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ucu.edu.ua.lab7.delivery.DHLDeliveryStrategy;
import ucu.edu.ua.lab7.delivery.Delivery;
import ucu.edu.ua.lab7.delivery.PostDeliveryStrategy;
import ucu.edu.ua.lab7.item.Item;
import ucu.edu.ua.lab7.order.dto.OrderRequest;
import ucu.edu.ua.lab7.order.dto.OrderResponse;
import ucu.edu.ua.lab7.payment.CreditCardPaymentStrategy;
import ucu.edu.ua.lab7.payment.PayPalPaymentStrategy;
import ucu.edu.ua.lab7.payment.Payment;

@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/demo")
    public OrderResponse demo() {
        return new OrderResponse(153.0, "Delivered by DHL (1 items)", "Paid 153.0 using PayPal.");
    }

    @PostMapping("/process")
    public ResponseEntity<OrderResponse> process(@RequestBody OrderRequest req) {

        if (req == null || req.items == null || req.items.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(new OrderResponse(0, "No items", "No payment"));
        }

        Order order = new Order();

        Delivery delivery = switch (safeLower(req.delivery)) {
            case "dhl" -> new DHLDeliveryStrategy();
            case "post" -> new PostDeliveryStrategy();
            default -> null;
        };
        if (delivery == null) {
            return ResponseEntity.badRequest()
                    .body(new OrderResponse(0, "Unknown delivery: " + req.delivery, "N/A"));
        }
        order.setDeliveryStrategy(delivery);

        Payment payment = switch (safeLower(req.payment)) {
            case "credit" -> new CreditCardPaymentStrategy();
            case "paypal" -> new PayPalPaymentStrategy();
            default -> null;
        };
        if (payment == null) {
            return ResponseEntity.badRequest()
                    .body(new OrderResponse(0, "N/A", "Unknown payment: " + req.payment));
        }
        order.setPaymentStrategy(payment);

        for (var spec : req.items) {
            Item item = OrderItemMapper.toItem(spec);
            if (item != null) {
                order.addItem(item);
            }
        }

        String result = order.processOrder();
        double total = order.calculateTotalPrice();

        String deliveryMsg = result.substring(result.indexOf("Delivery: ") + 10, result.indexOf(" | Payment:"));
        String paymentMsg = result.substring(result.indexOf("Payment: ") + 9, result.indexOf(" | Total:"));

        return ResponseEntity.ok(new OrderResponse(total, deliveryMsg, paymentMsg));
    }

    private static String safeLower(String s) {
        return s == null ? "" : s.toLowerCase();
    }
}
