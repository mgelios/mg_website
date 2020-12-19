package mg.finance.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CurrencyConversionDto {

    private UUID uuid;
    private CurrencyDto currencyFrom;
    private CurrencyDto currencyTo;
    private double value;
}
