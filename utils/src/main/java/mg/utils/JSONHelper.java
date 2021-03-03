package mg.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public interface JSONHelper {

    JSONObject getJSONObject(JSONObject object, String path);

    JSONArray getJSONArray(JSONObject object, String path);

    String getString(JSONObject object, String path);

    Long getLong(JSONObject object, String path);

    Integer getInt(JSONObject object, String path);

    Float getFloat(JSONObject object, String path);

    Double getDouble(JSONObject object, String path);

    BigInteger getBigInteger(JSONObject object, String path);

    BigDecimal getBigDecimal(JSONObject object, String path);

    Boolean getBoolean(JSONObject object, String path);

    LocalDateTime getLocalDateTime(JSONObject object, String path, DateTimeFormatter dateTimeFormatter);

    OffsetDateTime getOffsetDateTime(JSONObject object, String path, DateTimeFormatter dateTimeFormatter, ZoneOffset zoneOffset);

    Timestamp getTimestampOfEpochSecond(JSONObject object, String path);

    OffsetDateTime getOffsetDateTimeOfEpochSecond(JSONObject object, String path);

    Timestamp getTimestampFromFormat(JSONObject object, String path, String pattern);
}
