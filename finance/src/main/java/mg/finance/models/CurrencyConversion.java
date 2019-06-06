package mg.finance.models;

import lombok.Data;

@Data
public class CurrencyConversion {

    private Long id;

    private Currency currencyFrom;
    private Currency currencyTo;

    private double value;
}
