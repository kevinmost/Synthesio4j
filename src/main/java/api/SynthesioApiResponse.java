package api;

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
}
