package StockLedger;

public class StockPurchase{
    private final String stockSymbol;
    private final double pricePerShare;

    //init
    public StockPurchase(String stockSymbol, double pricePerShare){
        this.stockSymbol = stockSymbol;
        this.pricePerShare = pricePerShare;
    }

    public StockPurchase() {
        this.stockSymbol = null;
        this.pricePerShare = 0;
    }

    //return symbol
    public String getStockSymbol(){
        return stockSymbol;
    }

    //return price
    public double getPricePerShare(){
        return pricePerShare;
    }

    //return all
    public String getAll(){
        return stockSymbol + " " + Double.toString(pricePerShare);
    }

}
