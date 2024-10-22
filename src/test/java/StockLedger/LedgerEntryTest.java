package StockLedger;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LedgerEntryTest {

    @Test
    void getName() {
        LedgerEntry le = new LedgerEntry("DOGE", 15, 0.01);
        assertEquals("DOGE", le.getName());
    }

    @Test
    void getShares() {
        LedgerEntry le = new LedgerEntry("DOGE", 15, 0.01);
        assertEquals(15, le.getShares());
    }

    @Test
    void addBackEntries() {
        LedgerEntry le = new LedgerEntry("DOGE", 15, 0.01);
        le.addBackEntries(10, 0.02);
        assertEquals(25, le.getShares());
    }

    @Test
    void addFrontEntries() {
        LedgerEntry le = new LedgerEntry("DOGE", 15, 0.01);
        le.addFrontEntries(10, 0.02);
        assertEquals(25, le.getShares());
    }

    @Test
    void removeFrontEntries() {
        LedgerEntry le = new LedgerEntry("DOGE", 15, 0.01);
        assertEquals(0.1, le.removeFrontEntries(10, 0.02), 0.0001);
    }

    @Test
    void toListItems() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        LedgerEntry le = new LedgerEntry("DOGE", 1, 0.01);
        le.toListItems();
        assertEquals("DOGE " + 0.01 + "\n", outContent.toString());
    }

    @Test
    void toList() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        LedgerEntry le = new LedgerEntry("DOGE", 1, 0.01);
        le.toList();
        assertEquals("DOGE: 0.01 (1 shares) \n", outContent.toString());
    }
}