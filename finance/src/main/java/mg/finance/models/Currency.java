package mg.finance.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Currency {

    private Long id;
    private long systemId;
    private LocalDateTime date;
    private String abbreviation;
    private double scale;
    private String name;
    private double rate;
}
