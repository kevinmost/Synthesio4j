package api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

/**
 * @author kevin
 * @date 8/21/14
 */
public abstract class SynthesioApiResponse {

    protected static final JsonParser PARSER = new JsonParser();

    private JsonObject apiResponse;
    protected String key;

    public SynthesioApiResponse(JsonObject apiResponse, String key) {
        this.apiResponse = apiResponse;
        this.key = key;
    }

    public JsonObject getJSON() {
        return apiResponse;
    }

    protected abstract void parse() throws IOException;
}
