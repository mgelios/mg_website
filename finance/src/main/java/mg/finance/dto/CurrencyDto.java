package mg.finance.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
public class CurrencyDto {

    private UUID uuid;
    private OffsetDateTime date;
    private String abbreviation;
    private String name;
    private long systemId;
    private double scale;
    private double rate;
}
