package StockLedger;
import Deque.LinkedDeque;

public class LedgerEntry {
    private final String symbol;
    private int shares;
    private final LinkedDeque<StockPurchase> deque;

    //init
    public LedgerEntry(String stockSymbol, int sharesBought, double pricePerShare) {
        this.symbol = stockSymbol;
        deque = new LinkedDeque<>();
        addBackEntries(sharesBought, pricePerShare);

    }

    //return name
    public String getName() {
        return symbol;
    }

    //return share
    public int getShares() {
        return shares;
    }

    //add shares to back(standard queue)
    public void addBackEntries(int sharesBought, double pricePerShare) {
        for (int i = 0; i < sharesBought; i++) {
            deque.addToBack(new StockPurchase(symbol, pricePerShare));
        }
        shares += sharesBought;
    }

    //add shares to front(deque option)
    public void addFrontEntries(int sharesBought, double pricePerShare) {
        for (int i = 0; i < sharesBought; i++) {
            deque.addToFront(new StockPurchase(symbol, pricePerShare));
        }
        shares += sharesBought;
    }

    //remove front entries(standard queue)
    public double removeFrontEntries(int sharesSold, double pricePerShare) {
        double spent = 0;
        for (int i = 0; i < sharesSold; i++) {
            spent += deque.removeFront().getPricePerShare();
        }
        shares -= sharesSold;
        return sharesSold * pricePerShare - spent;
    }

    //long itemized list printer using cloned deque
    public void toListItems() {
        LinkedDeque<StockPurchase> temp = new LinkedDeque<>();
        for(StockPurchase s : deque){
            temp.addToBack(s);
        }
        while (!temp.isEmpty()) {
            System.out.println(temp.removeFront().getAll());
        }
    }

    //pretty version of stocks printed and their price at quantities
    public void toList(){
        LinkedDeque<StockPurchase> temp = new LinkedDeque<>();
        for(StockPurchase s : deque){
            temp.addToBack(s);
        }
        int count = 0;
        double last = 0;
        last = temp.getFront().getPricePerShare();
        while (!temp.isEmpty()) {
            //tally up shares at the same price
            if(temp.getFront().getPricePerShare() == last){
                count++;
                last = temp.removeFront().getPricePerShare();
            } else{ //print shares counted at their price
                System.out.print(symbol + ": " + last + " (" + count + " shares), ");
                count = 0;
                last = temp.getFront().getPricePerShare();
            }
        }//add newline after stock symbol change
        System.out.print(symbol + ": " + last + " (" + count + " shares) \n");
    }
}
