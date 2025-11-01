package ucu.edu.ua.lab7.item;

public class PaperDecorator extends ItemDecorator {

    public PaperDecorator(Item item) {
        super(item);
    }

    @Override
    public String getDescription() {
        return item.getDescription() + ", wrapped in paper";
    }

    @Override
    public double price() {
        return item.price() + 13;
    }
}
