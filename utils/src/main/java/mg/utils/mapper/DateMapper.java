package mg.utils.mapper;

import org.mapstruct.Mapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public abstract class DateMapper {

    public LocalDateTime toLocalDateMapper(Timestamp timestamp) {
        return timestamp.toLocalDateTime();
    }

    public Timestamp toTimestamp(LocalDateTime localDateTime) {
        return Timestamp.valueOf(localDateTime);
    }
}
