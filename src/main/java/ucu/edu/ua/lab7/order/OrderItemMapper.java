package ucu.edu.ua.lab7.order;

import ucu.edu.ua.lab7.flower.*;
import ucu.edu.ua.lab7.flower.decorators.BasketDecorator;
import ucu.edu.ua.lab7.flower.decorators.PaperDecorator;
import ucu.edu.ua.lab7.flower.decorators.RibbonDecorator;
import ucu.edu.ua.lab7.item.Item;
import ucu.edu.ua.lab7.order.dto.OrderRequest.ItemSpec;

public class OrderItemMapper {

    public static Item toItem(ItemSpec spec) {
        if (spec == null || spec.type == null) return null;

        Item base = switch (spec.type.toLowerCase()) {
            case "flower" -> buildFlower(spec);
            case "bucket" -> buildBucket(spec);
            default -> null;
        };
        if (base == null) return null;

        if (spec.decorators != null) {
            for (String d : spec.decorators) {
                base = applyDecorator(base, d);
            }
        }
        return base;
    }

    private static Item buildFlower(ItemSpec s) {
        try {
            FlowerType type = FlowerType.valueOf(s.flowerType.toUpperCase());
            FlowerColor color = FlowerColor.valueOf(s.flowerColor.toUpperCase());
            return new Flower(type, color, s.sepalLength, s.price);
        } catch (Exception e) {
            return null;
        }
    }

    private static Item buildBucket(ItemSpec s) {
        if (s.packs == null || s.packs.isEmpty()) return null;
        FlowerBucket bucket = new FlowerBucket();
        for (var p : s.packs) {
            try {
                FlowerType type = FlowerType.valueOf(p.flowerType.toUpperCase());
                FlowerColor color = FlowerColor.valueOf(p.flowerColor.toUpperCase());
                Flower f = new Flower(type, color, p.sepalLength, p.price);
                FlowerPack pack = new FlowerPack(f, p.quantity);
                bucket.addFlowerPack(pack);
            } catch (Exception ignore) { }
        }
        return bucket;
    }

    private static Item applyDecorator(Item base, String name) {
        if (name == null) return base;
        return switch (name.toLowerCase()) {
            case "paper"  -> new PaperDecorator(base);
            case "ribbon" -> new RibbonDecorator(base);
            case "basket" -> new BasketDecorator(base);
            default -> base;
        };
    }
}
