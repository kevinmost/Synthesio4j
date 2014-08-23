package responses.analytics;

import api.SynthesioApiResponse;
import com.google.gson.JsonObject;

import java.io.IOException;

/**
 * @author kevin
 * @date 8/23/14
 */
public abstract class AnalyticsRootResponse extends SynthesioApiResponse {

    public AnalyticsRootResponse(JsonObject apiResponse) {
        super(apiResponse);
    }

    protected abstract void parse() throws IOException;
}
