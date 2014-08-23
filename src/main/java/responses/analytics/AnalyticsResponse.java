package responses.analytics;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import endpoints.analytics.AnalyticsInfluence;

/**
 * @author kevin
 * @date 8/22/14
 */
public class AnalyticsResponse extends AnalyticsRootResponse {

    // The objects within the AnalyticsResponse object
    private AnalyticsInfluence influence;

    protected AnalyticsResponse(JsonObject apiResponse, String key) {
        super(apiResponse, key);
        parse();
    }

    // Parse the JSON response object into native data elements
    protected void parse() {
        JsonArray rootArray = getJSON().getAsJsonArray("indicators");

        // Take each element and parse out the data structures
        for (JsonElement indicator : rootArray) {

            JsonObject indicatorRoot = indicator.getAsJsonObject();
            String indicatorName = indicatorRoot.get("indicator").getAsString();
            String indicatorValue = indicatorRoot.get("reference").getAsString();

            // TODO: Make the logic to get the reportId from the URL better
            String reportId = indicatorValue.substring(36, 41);

            switch(indicatorName) {
                // TODO: Implement all of these
                case "Influence rating":
                    influence = new AnalyticsInfluence(key);
                    influence.setReportId(reportId);
                    break;
                case "Net sentiment":

                    break;
                case "Sentiment":

                    break;
                case "Volume":

                    break;
            }
        }
    }

    public AnalyticsInfluence getInfluence() {
        return influence;
    }
}
