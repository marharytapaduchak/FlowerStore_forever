package ucu.edu.ua.lab7.item;

public class RibbonDecorator extends ItemDecorator {

    public RibbonDecorator(Item item) {
        super(item);
    }

    @Override
    public String getDescription() {
        return item.getDescription() + ", with ribbon";
    }

    @Override
    public double price() {
        return item.price() + 20;
    }
}
