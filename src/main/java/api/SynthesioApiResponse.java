package api;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;

/**
 * @author kevin
 * @date 8/21/14
 */
public abstract class SynthesioApiResponse {

    private JsonObject apiResponse;

    public SynthesioApiResponse(JsonObject apiResponse) {
        this.apiResponse = apiResponse;
        try {
            parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JsonObject getJSON() {
        return apiResponse;
    }

    protected abstract void parse() throws IOException;





    protected String getAsString(JsonObject json, String str) {
        JsonElement el = json.get(str);
        return el == null ? null : el.getAsString();
    }
    protected String getAsString(String str) {
        return getAsString(getJSON(), str);
    }
    protected Integer getAsInt(JsonObject json, String str) {
        JsonElement el = json.get(str);
        return el == null ? null : el.getAsInt();
    }
    protected Integer getAsInt(String str) {
        return getAsInt(getJSON(), str);
    }
    protected Double getAsDouble(JsonObject json, String str) {
        JsonElement el = json.get(str);
        return el == null ? null : el.getAsDouble();
    }
    protected Double getAsDouble(String str) {
        return getAsDouble(getJSON(), str);
    }
    protected JsonArray getAsJsonArray(JsonObject json, String str) {
        JsonElement el = json.get(str);
        return el == null ? null : el.getAsJsonArray();
    }
    protected JsonArray getAsJsonArray(String str) {
        return getAsJsonArray(getJSON(), str);
    }
    protected JsonObject getAsJsonObject(JsonObject json, String str) {
        JsonElement el = json.get(str);
        return el == null ? null : el.getAsJsonObject();
    }
    protected JsonObject getAsJsonObject(String str) {
        return getAsJsonObject(getJSON(), str);
    }

}
