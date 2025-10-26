package ucu.edu.ua.lab7.delivery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @GetMapping("/choose")
    public String chooseDelivery(@RequestParam String provider) {
        Delivery strategy = switch (provider.toLowerCase()) {
            case "post" -> new PostDeliveryStrategy();
            case "dhl" -> new DHLDeliveryStrategy();
            default -> null;
        };

        if (strategy == null) {
            return "Unknown delivery provider: " + provider;
        }

        return "Delivery strategy selected: " + provider;
    }
}
