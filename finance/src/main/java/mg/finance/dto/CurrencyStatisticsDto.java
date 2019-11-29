package mg.finance.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CurrencyStatisticsDto {

    private Long id;

    private LocalDateTime date;
    private CurrencyDto currency;
    private double rate;
}
