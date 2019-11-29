package mg.finance.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CurrencyDto {

    private Long id;
    private long systemId;
    private LocalDateTime date;
    private String abbreviation;
    private double scale;
    private String name;
    private double rate;
}
