package ucu.edu.ua.lab7.item;

public abstract class Item {
    protected String description;

    public String getDescription() {
        return description;
    }

    public abstract double price();
}
