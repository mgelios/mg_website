package mg.finance.dto;

import lombok.Data;

@Data
public class CurrencyConversionDto {

    private Long id;

    private CurrencyDto currencyFrom;
    private CurrencyDto currencyTo;

    private double value;
}
