package ucu.edu.ua.lab7.delivery;

import java.util.List;
import ucu.edu.ua.lab7.item.Item;

public class DHLDeliveryStrategy implements Delivery {

    @Override
    public String deliver(List<Item> items) {
        return "Delivered by DHL (" + items.size() + " items)";
    }
}
