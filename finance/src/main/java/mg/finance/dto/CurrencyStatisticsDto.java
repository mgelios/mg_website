package mg.finance.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class CurrencyStatisticsDto {

    private UUID uuid;
    private LocalDateTime date;
    private CurrencyDto currency;
    private double rate;
}
