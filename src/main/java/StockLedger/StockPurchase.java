package StockLedger;

public class StockPurchase{
    private final String stockSymbol;
    private final double pricePerShare;

    public StockPurchase(String stockSymbol, double pricePerShare){
        this.stockSymbol = stockSymbol;
        this.pricePerShare = pricePerShare;
    }

    public String getStockSymbol(){
        return stockSymbol;
    }

    public double getPricePerShare(){
        return pricePerShare;
    }

    public String getAll(){
        return stockSymbol + " " + Double.toString(pricePerShare);
    }

}
