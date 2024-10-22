package StockLedger;

public class Main {
    public static void main(String[] args) {
        StockLedger sl = new StockLedger();
        double YTD = 0.0;

        sl.buy("AAPL", 20, 45);
        sl.buy("AAPL", 20, 75);
        sl.buy("MSFT", 20, 95);
        sl.printLedger();

        double profit = sl.sell("AAPL", 30, 65);
        YTD += profit;
        System.out.println("Sold 30 shares of AAPL at $65. Profit: $" + profit);
        sl.printLedger();

        profit = sl.sell("AAPL", 10, 65);
        YTD += profit;
        System.out.println("Sold 10 shares of AAPL at $65. Profit: $" + profit);
        sl.printLedger();

        sl.buy("AAPL", 100, 20);
        sl.buy("AAPL", 20, 24);
        sl.buy("TSLA", 200, 36);
        sl.printLedger();

        profit = sl.sell("AAPL", 10, 65);
        YTD += profit;
        System.out.println("Sold 10 shares of AAPL at $65. Profit: $" + profit);
        sl.printLedger();

        profit = sl.sell("TSLA", 150, 30);
        YTD += profit;
        System.out.println("Sold 150 shares of TSLA at $30. Profit: $" + profit);
        sl.printLedger();

        sl.buy("MSFT", 5, 60);
        sl.buy("MSFT", 5, 70);
        sl.printLedger();

        profit = sl.sell("MSFT", 4, 30);
        YTD += profit;
        System.out.println("Sold 4 shares of MSFT at $30. Profit: $" + profit);
        sl.printLedger();

        profit = sl.sell("MSFT", 2, 30);
        YTD += profit;
        System.out.println("Sold 2 shares of MSFT at $30. Profit: $" + profit);
        sl.printLedger();
        System.out.println("Year to date profit: $" + YTD);
    }
}
