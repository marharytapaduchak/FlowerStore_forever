package ucu.edu.ua.lab7.flower;

import java.util.ArrayList;
import java.util.List;

import ucu.edu.ua.lab7.item.Item;

public class FlowerBucket extends Item {
    private List<FlowerPack> flowerPacks = new ArrayList<>();

    public void addFlowerPack(FlowerPack flowerPack) {
        if (flowerPack != null) {
            flowerPacks.add(flowerPack);
        }
    }

    public double getPrice() {
        double price = 0;
        for (FlowerPack pack : flowerPacks) {
            price += pack.getPrice();
        }
        return price;
    }

    @Override
    public double price() {
        return getPrice();
    }

    @Override
    public String getDescription() {
        return (description != null ? description : "Flower bucket with " + flowerPacks.size() + " packs");
    }
}
