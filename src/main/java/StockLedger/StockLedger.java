package StockLedger;

import Deque.LinkedDeque;

import java.util.ArrayList;

public class StockLedger {
    ArrayList<LedgerEntry> ledger = new ArrayList<LedgerEntry>();

    public void buy(String stockSymbol, int sharesBought, double pricePerShare){
        //if(ledger.stream().anyMatch(obj -> obj.getName().equals(stockSymbol))){}
        if(ledger.contains(getEntry(stockSymbol))){
            int index = ledger.indexOf(getEntry(stockSymbol));
            LedgerEntry temp = getEntry(stockSymbol);
            temp.addBackEntries(sharesBought, pricePerShare);
            ledger.set(index, temp);
        } else{
            ledger.add(new LedgerEntry(stockSymbol, sharesBought, pricePerShare));
        }
    }

    public double sell(String stockSymbol, int sharesSold, double pricePerShare) {
        double gains = 0;
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

    public boolean contains(String stockSymbol){
        for(LedgerEntry obj : ledger){
            if(obj.getName().equals(stockSymbol)){
                return true;
            }
        }
        return false;
    }
    public LedgerEntry getEntry(String stockSymbol) {
        for (LedgerEntry obj : ledger) {
            if (obj.getName().equals(stockSymbol)) {
                return obj;
            }
        }
        return null;
    }

    public void printLedger(){
        for(LedgerEntry obj : ledger){
            obj.toList();
        }
    }
}
