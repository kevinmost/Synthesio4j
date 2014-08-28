package responses.analytics;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import endpoints.analytics.AnalyticsInfluence;
import endpoints.analytics.AnalyticsNetSentiment;
import endpoints.analytics.AnalyticsSentiment;
import endpoints.analytics.AnalyticsVolume;

/**
 * @author kevin
 * @date 8/22/14
 */
public final class AnalyticsResponse extends AnalyticsRootResponse {

    // The objects within the AnalyticsResponse object
    private AnalyticsInfluence influence;
    private AnalyticsSentiment sentiment;
    private AnalyticsNetSentiment netSentiment;
    private AnalyticsVolume volume;

    protected AnalyticsResponse(JsonObject apiResponse) {
        super(apiResponse);
    }

    // Parse the JSON response object into native data elements
    protected void parse() {
        JsonArray rootArray = getAsJsonArray("indicators");

        // Take each element and parse out the data structures
        for (JsonElement indicator : rootArray) {

            JsonObject indicatorRoot = indicator.getAsJsonObject();
            String indicatorName = getAsString(indicatorRoot, "indicator");
            String indicatorValue = getAsString(indicatorRoot, "reference");

            // TODO: Make the logic to get the reportId and key from the URL better
            String reportId = indicatorValue.substring(36, 41);
            String key = indicatorValue.substring(indicatorValue.lastIndexOf("key=") + 4);

            // Set the corresponding object depending on what the name of this particular node was
            switch(indicatorName) {
                case "Influence rating":
                    influence = new AnalyticsInfluence(key);
                    influence.setReportId(reportId);
                    break;
                case "Net sentiment":
                    netSentiment = new AnalyticsNetSentiment(key);
                    netSentiment.setReportId(reportId);
                    break;
                case "Sentiment":
                    sentiment = new AnalyticsSentiment(key);
                    sentiment.setReportId(reportId);
                    break;
                case "Volume":
                    volume = new AnalyticsVolume(key);
                    volume.setReportId(reportId);
                    break;
            }
        }
    }

    public AnalyticsInfluence getInfluence() {
        return influence;
    }
    public AnalyticsNetSentiment getNetSentiment() {
        return netSentiment;
    }
    public AnalyticsSentiment getSentiment() {
        return sentiment;
    }
    public AnalyticsVolume getVolume() {
        return volume;
    }
}
