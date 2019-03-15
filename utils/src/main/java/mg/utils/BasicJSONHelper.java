package mg.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;
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
        return Long.valueOf(getObjectByPath(object, path).toString());
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
        return Double.valueOf(getObjectByPath(object, path).toString());
    }

    //TODO: change return statment for big integers and big decimals
    @Override
    public BigInteger getBigInteger(JSONObject object, String path) {
        return null;
    }

    @Override
    public BigDecimal getBigDecimal(JSONObject object, String path) {
        return null;
    }

    @Override
    public Boolean getBoolean(JSONObject object, String path) {
        return null;
    }

    @Override
    public Timestamp getTimestampOfEpochSecond(JSONObject object, String path) {
        return Timestamp.from(Instant.ofEpochSecond(getLong(object, path)));
    }

    //TODO: reformat code
    private Object getLastObjectInPath(Object object, List<String> pathParts, int currentIndex) {
        if (currentIndex != pathParts.size()){
            if (!pathParts.get(currentIndex).contains("]")) {
                Object currentObject = ((JSONObject) object).get(pathParts.get(currentIndex));
                return getLastObjectInPath(currentObject, pathParts, currentIndex + 1);
            } else {
                String arrayName = pathParts.get(currentIndex).split("[\\[]|[\\]]")[0];
                int arrayIndex = Integer.valueOf(pathParts.get(currentIndex).split("[\\[]|[\\]]")[1]);
                return getLastObjectInPath(((JSONObject) object).getJSONArray(arrayName).get(arrayIndex), pathParts, currentIndex + 1);
            }
        } else return object;
    }

    private Object getObjectByPath(JSONObject parentObject ,String path) {
        List<String> pathParts = Arrays.stream(path.split("[.]"))
                .collect(Collectors.toList());
        return getLastObjectInPath(parentObject, pathParts, 0);
    }
}
