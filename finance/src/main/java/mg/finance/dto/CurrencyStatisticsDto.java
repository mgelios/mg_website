package mg.finance.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
public class CurrencyStatisticsDto {

    private UUID uuid;
    private Long currencyId;
    private OffsetDateTime date;
    private CurrencyDto currency;
    private double rate;
}
