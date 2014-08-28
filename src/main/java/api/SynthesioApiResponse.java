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



    private JsonElement getJsonElement(JsonObject json, String str) {
        return json.get(str);
    }
    private JsonElement getJsonElement(String str) {
        return getJsonElement(getJSON(), str);
    }

    protected String getAsString(String str) {
        return getJsonElement(str).getAsString();
    }
    protected String getAsString(JsonObject json, String str) {
        return getJsonElement(json, str).getAsString();
    }
    protected Integer getAsInt(String str) {
        return getJsonElement(str).getAsInt();
    }
    protected Integer getAsInt(JsonObject json, String str) {
        return getJsonElement(json, str).getAsInt();
    }
    protected Double getAsDouble(String str) {
        return getJsonElement(str).getAsDouble();
    }
    protected Double getAsDouble(JsonObject json, String str) {
        return getJsonElement(json, str).getAsDouble();
    }
    protected JsonArray getAsJsonArray(String str) {
        return getJsonElement(str).getAsJsonArray();
    }
    protected JsonArray getAsJsonArray(JsonObject json, String str) {
        return getJsonElement(json, str).getAsJsonArray();
    }
    protected JsonObject getAsJsonObject(String str) {
        return getJsonElement(str).getAsJsonObject();
    }
    protected JsonObject getAsJsonObject(JsonObject json, String str) {
        return getJsonElement(json, str).getAsJsonObject();
    }
}
