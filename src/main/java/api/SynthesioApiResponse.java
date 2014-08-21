package api;

import com.google.gson.JsonElement;

/**
 * @author kevin
 * @date 8/21/14
 */
public class SynthesioApiResponse {
    JsonElement apiResponse;

    public SynthesioApiResponse(JsonElement apiResponse) {
        this.apiResponse = apiResponse;
    }
}
