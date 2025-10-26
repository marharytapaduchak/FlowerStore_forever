package ucu.edu.ua.lab7.flower.decorators;

import ucu.edu.ua.lab7.item.Item;
import ucu.edu.ua.lab7.item.ItemDecorator;

public class BasketDecorator extends ItemDecorator {
    public BasketDecorator(Item item) {
        super(item);
    }

    @Override
    public double price() {
        return item.price() + 4;
    }

    @Override
    public String getDescription() {
        return item.getDescription() + ", basket";
    }
}
