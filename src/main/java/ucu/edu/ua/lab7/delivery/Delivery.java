package ucu.edu.ua.lab7.delivery;

import java.util.List;
import ucu.edu.ua.lab7.item.Item;

public interface Delivery {
    String deliver(List<Item> items);
}
