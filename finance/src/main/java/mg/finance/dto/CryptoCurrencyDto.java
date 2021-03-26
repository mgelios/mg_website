package mg.finance.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
public class CryptoCurrencyDto {

    private UUID uuid;
    private String name;
    private String symbol;
    private long rank;
    private double availableSupply;
    private double totalSupply;
    private double maxSupply;
    private double priceUsd;
    private double volumeLastDayUsd;
    private double marketCapUsd;
    private double percentChangeLastHour;
    private double percentChangeLastDay;
    private double percentChangeLastWeek;
    private double percentChangeLastMonth;
    private double percentChangeLastThreeMonth;
    private OffsetDateTime lastUpdated;
}
