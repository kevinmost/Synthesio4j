package responses.analytics;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import response_data_structures.analytics.AnalyticsSentimentPeriod;
import response_data_structures.analytics.Sentiment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin
 * @date 8/23/14
 */
public final class AnalyticsSentimentResponse extends AnalyticsRootResponse {

    public AnalyticsSentimentResponse(JsonObject apiResponse) {
        super(apiResponse);
    }

    private Sentiment globalSentiment;
    private List<AnalyticsSentimentPeriod> periods;
    public Sentiment getGlobalSentiment() {
        return globalSentiment;
    }
    public List<AnalyticsSentimentPeriod> getPeriods() {
        return periods;
    }

    @Override
    protected void parse() throws IOException {
        periods = new ArrayList<>();

        JsonArray jsonPeriods = getAsJsonArray("periods");

        for (JsonElement period : jsonPeriods) {
            periods.add(new AnalyticsSentimentPeriod(period.getAsJsonObject()));
        }

        globalSentiment = new Sentiment(getAsJsonObject(getAsJsonObject("global"), "sentiment"));
    }
}
