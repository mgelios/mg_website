package mg.finance.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CurrencyStatistics {

    private Long id;

    private LocalDateTime date;
    private Currency currency;
    private double rate;
}
