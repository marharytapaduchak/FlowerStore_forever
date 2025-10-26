package ucu.edu.ua.lab7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import ucu.edu.ua.lab7.delivery.DHLDeliveryStrategy;
import ucu.edu.ua.lab7.delivery.PostDeliveryStrategy;
import ucu.edu.ua.lab7.item.Item;

public class DeliveryTests {

    static class TestItem extends Item {
        private final double p;
        TestItem(double p) { this.p = p; this.description = "test"; }
        @Override public double price() { return p; }
    }

    @Test
    void dhl_returnsMessageWithCount() {
        var s = new DHLDeliveryStrategy();
        String msg = s.deliver(List.of(new TestItem(10), new TestItem(5)));
        assertTrue(msg.toLowerCase().contains("dhl"));
        assertTrue(msg.contains("2"));
    }

    @Test
    void post_returnsMessageWithCount() {
        var s = new PostDeliveryStrategy();
        String msg = s.deliver(List.of(new TestItem(7)));
        assertTrue(msg.toLowerCase().contains("post"));
        assertTrue(msg.contains("1"));
    }
}
