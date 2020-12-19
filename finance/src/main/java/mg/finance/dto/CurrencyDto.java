package mg.finance.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class CurrencyDto {

    private UUID uuid;
    private long systemId;
    private LocalDateTime date;
    private String abbreviation;
    private double scale;
    private String name;
    private double rate;
}
