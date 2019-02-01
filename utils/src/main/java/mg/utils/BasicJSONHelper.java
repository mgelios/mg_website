package mg.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BasicJSONHelper implements JSONHelper {

    @Override
    public JSONObject getJSONObject(JSONObject object, String path) {
        List<String> pathParts = splitPath(path);
        JSONObject currentObject = object;
        for (String part : pathParts){
            currentObject = currentObject.getJSONObject(part);
        }
        return currentObject;
    }

    @Override
    public JSONArray getJSONArray(JSONObject object, String path) {
        return null;
    }

    @Override
    public String getString(JSONObject object, String path) {
        return null;
    }

    @Override
    public Long getLong(JSONObject object, String path) {
        return null;
    }

    @Override
    public Integer getInt(JSONObject object, String path) {
        return null;
    }

    @Override
    public Float getFloat(JSONObject object, String path) {
        return null;
    }

    @Override
    public Double getDouble(JSONObject object, String path) {
        return null;
    }

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

    private List<String> splitPath(String path){
        return Arrays.stream(path.split("[.]"))
                .collect(Collectors.toList());
    }
}
