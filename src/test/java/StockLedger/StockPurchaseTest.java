package StockLedger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StockPurchaseTest {

    @Test
    void getStockSymbol() {
        StockPurchase sp = new StockPurchase("ALEX", 28);
        assertEquals("ALEX", sp.getStockSymbol());
    }

    @Test
    void getPricePerShare() {
        StockPurchase sp = new StockPurchase("ALEX", 28);
        assertEquals(28, sp.getPricePerShare());
    }

    @Test
    void getAll() {
        StockPurchase sp = new StockPurchase("ALEX", 28);
        assertEquals("ALEX 28.0", sp.getAll());
    }
}