package StockLedger;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class StockLedgerTest {

    @Test
    void buy() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        StockLedger sl = new StockLedger();
        sl.buy("GME", 3, 11.11);
        sl.printLedger();
        assertEquals("GME: 11.11 (3 shares) \n", outContent.toString());
    }

    @Test
    void sell() {
        StockLedger sl = new StockLedger();
        sl.buy("GME", 3, 11.12);
        assertEquals(-0.03, sl.sell("GME", 3, 11.11), 0.0001);
    }

    @Test
    void contains() {
        StockLedger sl = new StockLedger();
        sl.buy("GME", 3, 11.12);
        assertTrue(sl.contains("GME"));
    }

    @Test
    void getEntry() {
        StockLedger sl = new StockLedger();
        sl.buy("GME", 1, 11.12);
        assertEquals(sl.ledger.getFirst(), sl.getEntry("GME"));
    }

    @Test
    void printLedger() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        StockLedger sl = new StockLedger();
        sl.buy("GME", 3, 11.11);
        sl.printLedger();
        assertEquals("GME: 11.11 (3 shares) \n", outContent.toString());
    }
}