package ucu.edu.ua.lab7.order.dto;

import java.util.List;

public class OrderRequest {
    public String delivery;
    public String payment;
    public List<ItemSpec> items;

    public static class ItemSpec {
        public String type;
        public List<String> decorators;

        public String flowerType;
        public String flowerColor;
        public double sepalLength;
        public double price;

        public List<FlowerPackSpec> packs;
    }

    public static class FlowerPackSpec {
        public String flowerType;
        public String flowerColor;
        public double sepalLength;
        public double price;
        public int quantity;
    }
}
