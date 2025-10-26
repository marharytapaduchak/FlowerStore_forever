package ucu.edu.ua.lab7.item;

public abstract class ItemDecorator extends Item {
    protected final Item item;

    protected ItemDecorator(Item item) {
        this.item = item;
    }

    @Override
    public String getDescription() {
        return item.getDescription();
    }
}
