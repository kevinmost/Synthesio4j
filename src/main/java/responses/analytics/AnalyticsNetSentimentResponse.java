package responses.analytics;

import api.SynthesioApiResponse;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import response_data_structures.analytics.AnalyticsNetSentimentPeriod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin
 * @date 8/23/14
 */
public class AnalyticsNetSentimentResponse extends SynthesioApiResponse {

    public AnalyticsNetSentimentResponse(JsonObject apiResponse, String key) {
        super(apiResponse, key);
    }

    private int globalNetSentiment;
    private List<AnalyticsNetSentimentPeriod> periods = new ArrayList<>();
    public int getGlobalNetSentiment() {
        return globalNetSentiment;
    }
    public List<AnalyticsNetSentimentPeriod> getPeriods() {
        return periods;
    }

    @Override
    protected void parse() throws IOException {
        JsonArray jsonPeriods = getJSON().get("periods").getAsJsonArray();

        for (JsonElement period : jsonPeriods) {
            periods.add(new AnalyticsNetSentimentPeriod(period.getAsJsonObject()));
        }

        globalNetSentiment = getJSON().get("global").getAsJsonObject().get("netsentiment").getAsInt();
    }

}
