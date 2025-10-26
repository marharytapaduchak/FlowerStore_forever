package ucu.edu.ua.lab7.delivery;

import java.util.List;
import ucu.edu.ua.lab7.item.Item;

public class PostDeliveryStrategy implements Delivery {

    @Override
    public String deliver(List<Item> items) {
        return "Delivered by Post (" + items.size() + " items)";
    }
}
