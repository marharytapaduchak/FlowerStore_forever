package ucu.edu.ua.lab7.item;

public class BasketDecorator extends ItemDecorator {

    public BasketDecorator(Item item) {
        super(item);
    }

    @Override
    public String getDescription() {
        return item.getDescription() + ", in basket";
    }

    @Override
    public double price() {
        return item.price() + 40;
    }
}
