package mg.utils.mapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DateMapper {

    public LocalDateTime asLocalDateTime(Timestamp timestamp) {
        return timestamp.toLocalDateTime();
    }

    public Timestamp asTimestamp(LocalDateTime localDateTime) {
        return Timestamp.valueOf(localDateTime);
    }
}
