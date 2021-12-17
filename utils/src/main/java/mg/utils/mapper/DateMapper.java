package mg.utils.mapper;

import org.mapstruct.Mapper;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Mapper(componentModel = "spring")
public abstract class DateMapper {

    public LocalDateTime toLocalDateMapper(Timestamp timestamp) {
        return timestamp.toLocalDateTime();
    }

    public Timestamp toTimestamp(LocalDateTime localDateTime) {
        return Timestamp.valueOf(localDateTime);
    }

    public OffsetDateTime toOffsetDateTime(Timestamp timestamp) {
        return OffsetDateTime.of(timestamp.toLocalDateTime(), ZoneOffset.ofHours(0));
    }

    public Timestamp toTimestamp(OffsetDateTime offsetDateTime) {
        return Timestamp.from(offsetDateTime.toInstant());
    }

    public Instant toInstant(OffsetDateTime offsetDateTime) {
        return offsetDateTime.toInstant();
    }

    public OffsetDateTime toOffsetDateTime(Instant instant) {
        return instant.atOffset(ZoneOffset.ofHours(0));
    }
}
