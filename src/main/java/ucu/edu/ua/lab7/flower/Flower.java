package ucu.edu.ua.lab7.flower;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import ucu.edu.ua.lab7.item.Item;

@Getter@AllArgsConstructor@ToString
public class Flower extends Item {
    private double sepalLength;
    private FlowerColor color;
    private double price;
    private FlowerType flowerType;

    public Flower() {
        
    }

    public Flower(
        FlowerType type,
        FlowerColor color,
        double sepalLength,
        double price
    ) {
        this.flowerType = type;
        this.color = color;
        this.sepalLength = sepalLength;
        this.price = price;
        this.description = type + " (" + color + ")";
    }

    public Flower(Flower flower) {
        this.sepalLength = flower.sepalLength;
        this.color = flower.color;
        this.price = flower.price;
        this.flowerType = flower.flowerType;
        this.description = flower.getDescription();
    }

    public void setPrice(int newPrice) {
        this.price = (double) newPrice;
    }

    public void setColor(FlowerColor newColor) {
        this.color = newColor;
    }

    public void setSepalLength(double newSepalLength) {
        this.sepalLength = newSepalLength;
    }

    public void setFlowerType(FlowerType newType) {
        this.flowerType = newType;
    }

    @Override
    public double price() {
        return this.price;
    }

    @Override
    public String getDescription() {
        if (this.description == null) {
            this.description = flowerType + " (" + color + ")";
        }
        return this.description;
    }
}
