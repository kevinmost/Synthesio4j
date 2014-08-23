package responses.analytics;

import api.SynthesioApiResponse;
import com.google.gson.JsonObject;

/**
 * @author kevin
 * @date 8/23/14
 */
public abstract class AnalyticsRootResponse extends SynthesioApiResponse {

    public AnalyticsRootResponse(JsonObject apiResponse, String key) {
        super(apiResponse, key);
    }

    protected abstract void parse();
}
