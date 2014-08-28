package responses.analytics;

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
public final class AnalyticsNetSentimentResponse extends AnalyticsRootResponse {

    public AnalyticsNetSentimentResponse(JsonObject apiResponse) {
        super(apiResponse);
    }

    private int globalNetSentiment;
    private List<AnalyticsNetSentimentPeriod> periods;
    public int getGlobalNetSentiment() {
        return globalNetSentiment;
    }
    public List<AnalyticsNetSentimentPeriod> getPeriods() {
        return periods;
    }

    @Override
    protected void parse() throws IOException {

        periods = new ArrayList<>();

        JsonArray jsonPeriods = getAsJsonArray("periods");

        for (JsonElement period : jsonPeriods) {
            periods.add(new AnalyticsNetSentimentPeriod(period.getAsJsonObject()));
        }

        globalNetSentiment = getAsInt(getAsJsonObject("global"), "netsentiment");
    }

}
