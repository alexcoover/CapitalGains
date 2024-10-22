package StockLedger;
import Deque.LinkedDeque;

public class LedgerEntry {
    private final String symbol;
    private int shares;
    private final LinkedDeque<StockPurchase> deque;


    public LedgerEntry(String stockSymbol, int sharesBought, double pricePerShare) {
        this.symbol = stockSymbol;
        deque = new LinkedDeque<>();
        addBackEntries(sharesBought, pricePerShare);

    }

    public String getName() {
        return symbol;
    }

    public int getShares() {
        return shares;
    }


    public void addBackEntries(int sharesBought, double pricePerShare) {
        for (int i = 0; i < sharesBought; i++) {
            deque.addToBack(new StockPurchase(symbol, pricePerShare));
        }
        shares += sharesBought;
    }

    public void addFrontEntries(int sharesBought, double pricePerShare) {
        for (int i = 0; i < sharesBought; i++) {
            deque.addToFront(new StockPurchase(symbol, pricePerShare));
        }
        shares += sharesBought;
    }

    public double removeFrontEntries(int sharesSold, double pricePerShare) {
        double spent = 0;
        for (int i = 0; i < sharesSold; i++) {
            spent += deque.removeFront().getPricePerShare();
        }
        shares -= sharesSold;
        return sharesSold * pricePerShare - spent;
    }

    public void toListItems() {
        LinkedDeque<StockPurchase> temp = new LinkedDeque<>();
        for(StockPurchase s : deque){
            temp.addToBack(s);
        }
        while (!temp.isEmpty()) {
            System.out.println(temp.removeFront().getAll());
        }
    }

    public void toList(){
        LinkedDeque<StockPurchase> temp = new LinkedDeque<>();
        for(StockPurchase s : deque){
            temp.addToBack(s);
        }
        int count = 0;
        double last = 0;
        last = temp.getFront().getPricePerShare();
        while (!temp.isEmpty()) {
            if(temp.getFront().getPricePerShare() == last){
                count++;
                last = temp.removeFront().getPricePerShare();
            } else{
                System.out.print(symbol + ": " + last + " (" + count + " shares), ");
                count = 0;
                last = temp.getFront().getPricePerShare();
            }
        }
        System.out.print(symbol + ": " + last + " (" + count + " shares) \n");
    }
}
