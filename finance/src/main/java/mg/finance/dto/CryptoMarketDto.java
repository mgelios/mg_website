package mg.finance.dto;

import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CryptoMarketDto {

    private UUID uuid;
    private Long activeCryptoCurrencies;
    private Long totalCryptoCurrencies;
    private Long btcDominance;
    private Long ethDominance;
    private Long totalMarketCapUsd;
    private Long totalDayVolumeUsd;
    private Long altcoinMarketCapUsd;
    private Long altcoinDayVolumeUsd;
    private OffsetDateTime lastUpdated;
}