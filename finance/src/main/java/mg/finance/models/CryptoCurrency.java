package mg.finance.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CryptoCurrency {

    private Long id;
    private String name;
    private String symbol;
    private long rank;
    private double priceUSD;
    private double priceBTC;
    private double volumeUSD24h;
    private double marketCapUSD;
    private double availableSupply;
    private double totalSupply;
    private double maxSupply;
    private double percentChangeIn1h;
    private double percentChangeIn24h;
    private double percentChangeIn7d;
    private LocalDateTime lastUpdated;
}
