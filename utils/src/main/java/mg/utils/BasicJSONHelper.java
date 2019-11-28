package mg.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BasicJSONHelper implements JSONHelper {

    @Override
    public JSONObject getJSONObject(JSONObject object, String path) {
        return (JSONObject) getObjectByPath(object, path);
    }

    @Override
    public JSONArray getJSONArray(JSONObject object, String path) {
        return (JSONArray) getObjectByPath(object, path);
    }

    @Override
    public String getString(JSONObject object, String path) {
        return getObjectByPath(object, path).toString();
    }

    @Override
    public Long getLong(JSONObject object, String path) {
        Object result = getObjectByPath(object, path);
        if (JSONObject.NULL.equals(result)) {
            return 0L;
        } else {
            return result instanceof Number ? ((Number) result).longValue() : Long.parseLong((String) result);
        }
    }

    @Override
    public Integer getInt(JSONObject object, String path) {
        return Integer.valueOf(getObjectByPath(object, path).toString());
    }

    @Override
    public Float getFloat(JSONObject object, String path) {
        return Float.valueOf(getObjectByPath(object, path).toString());
    }

    @Override
    public Double getDouble(JSONObject object, String path) {
        Object result = getObjectByPath(object, path);
        if (JSONObject.NULL.equals(result)) {
            return 0.0;
        } else {
            return result instanceof Number ? ((Number) result).doubleValue() : Double.parseDouble((String) result);
        }
    }

    @Override
    public BigInteger getBigInteger(JSONObject object, String path) {
        return new BigInteger(getString(object, path));
    }

    @Override
    public BigDecimal getBigDecimal(JSONObject object, String path) {
        return new BigDecimal(getString(object, path));
    }

    @Override
    public Boolean getBoolean(JSONObject object, String path) {
        return null;
    }

    @Override
    public Timestamp getTimestampOfEpochSecond(JSONObject object, String path) {
        return Timestamp.from(Instant.ofEpochSecond(getLong(object, path)));
    }

    @Override
    public Timestamp getTimestampFromFormat(JSONObject object, String path, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return Timestamp.from(LocalDateTime.from(formatter.parse(getString(object, path))).toInstant(ZoneOffset.MIN));
    }

    private Object getLastObjectInPath(Object object, List<String> pathParts, int currentIndex) {
        if (currentIndex != pathParts.size()) {
            if (!pathParts.get(currentIndex).contains("]")) {
                return processObject(object, pathParts, currentIndex);
            } else {
                return processArrayItem(object, pathParts, currentIndex);
            }
        } else return object;
    }

    private Object processObject(Object object, List<String> pathParts, int currentIndex) {
        if (((JSONObject) object).has(pathParts.get(currentIndex))) {
            Object currentObject = ((JSONObject) object).get(pathParts.get(currentIndex));
            return getLastObjectInPath(currentObject, pathParts, currentIndex + 1);
        } else return null;
    }

    private Object processArrayItem(Object object, List<String> pathParts, int currentIndex) {
        String arrayName = pathParts.get(currentIndex).split("[\\[]|[\\]]")[0];
        int arrayIndex = Integer.valueOf(pathParts.get(currentIndex).split("[\\[]|[\\]]")[1]);
        if (((JSONObject) object).has(arrayName)) {
            return getLastObjectInPath(((JSONObject) object).getJSONArray(arrayName).get(arrayIndex),
                    pathParts, currentIndex + 1);
        } else return null;
    }

    private Object getObjectByPath(JSONObject parentObject, String path) {
        List<String> pathParts = Arrays.stream(path.split("[.]"))
                .collect(Collectors.toList());
        return getLastObjectInPath(parentObject, pathParts, 0);
    }
}
