package mg.finance.models;

public class CryptoCurrency {

    private Long id;

    private String name;

    private String symbol;

    private long rank;

    private double usdPrice;

    private double btcPrice;

    private double change24h;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public double getUsdPrice() {
        return usdPrice;
    }

    public void setUsdPrice(double usdPrice) {
        this.usdPrice = usdPrice;
    }

    public double getBtcPrice() {
        return btcPrice;
    }

    public void setBtcPrice(double btcPrice) {
        this.btcPrice = btcPrice;
    }

    public double getChange24h() {
        return change24h;
    }

    public void setChange24h(double change24h) {
        this.change24h = change24h;
    }
}

//    name = models.CharField(max_length=200, default='')
//        symbol = models.CharField(max_length=200, default='')
//        rank = models.IntegerField(default=0)
//        price_usd = models.FloatField(default=0.0)
//        price_btc = models.FloatField(default=0.0)
//        change_24h = models.FloatField(default=0.0)