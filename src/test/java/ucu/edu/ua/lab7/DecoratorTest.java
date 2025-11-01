package ucu.edu.ua.lab7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ucu.edu.ua.lab7.item.Item;
import ucu.edu.ua.lab7.item.PaperDecorator;
import ucu.edu.ua.lab7.item.BasketDecorator;
import ucu.edu.ua.lab7.item.RibbonDecorator;

public class DecoratorTest {

    static class TestItem extends Item {
        private final double p;

        TestItem(double price) {
            this.description = "test item";
            this.p = price;
        }

        @Override
        public String getDescription() {
            return description;
        }

        @Override
        public double price() {
            return p;
        }
    }

    @Test
    void paperDecoratorAdds13() {
        Item flower = new TestItem(100);
        Item wrapped = new PaperDecorator(flower);

        assertEquals(113, wrapped.price());
        assertTrue(wrapped.getDescription().contains("paper"));
    }

    @Test
    void basketAndRibbonAddsCorrectly() {
        Item flower = new TestItem(100);

        Item decorated = new RibbonDecorator(
                new BasketDecorator(flower)
        );

        assertEquals(160, decorated.price());
    }
}
