package StockLedger;

import Deque.LinkedDeque;

import java.util.ArrayList;

public class StockLedger {
    ArrayList<LedgerEntry> ledger = new ArrayList<LedgerEntry>();

    //buy new stock
    public void buy(String stockSymbol, int sharesBought, double pricePerShare){
        //check if ticker exists in ledger and create one if it doesnt
        if(ledger.contains(getEntry(stockSymbol))){
            int index = ledger.indexOf(getEntry(stockSymbol));
            LedgerEntry temp = getEntry(stockSymbol);
            temp.addBackEntries(sharesBought, pricePerShare);
            ledger.set(index, temp);
        } else{
            ledger.add(new LedgerEntry(stockSymbol, sharesBought, pricePerShare));
        }
    }

    //sell stock
    public double sell(String stockSymbol, int sharesSold, double pricePerShare) {
        double gains = 0;
        //removes stocks in queue order and adds them up.
        if (ledger.contains(getEntry(stockSymbol))) {
            int index = ledger.indexOf(getEntry(stockSymbol));
            LedgerEntry temp = getEntry(stockSymbol);
            gains = temp.removeFrontEntries(sharesSold, pricePerShare);
            if(temp.getShares() == 0){
                ledger.remove(index);
            } else{
                ledger.set(index, temp);
            }
        }
        return gains;
    }

    //basic contains checker
    public boolean contains(String stockSymbol){
        for(LedgerEntry obj : ledger){
            if(obj.getName().equals(stockSymbol)){
                return true;
            }
        }
        return false;
    }

    //finds and returns ledger entry using stock symbol
    public LedgerEntry getEntry(String stockSymbol) {
        for (LedgerEntry obj : ledger) {
            if (obj.getName().equals(stockSymbol)) {
                return obj;
            }
        }
        return null;
    }

    //accesses print method in LedgerEntry class
    public void printLedger(){
        for(LedgerEntry obj : ledger){
            obj.toList();
        }
    }
}
