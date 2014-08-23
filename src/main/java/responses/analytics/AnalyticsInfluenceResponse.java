package responses.analytics;

import api.SynthesioApiResponse;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import response_data_structures.analytics.AnalyticsInfluencePeriod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin
 * @date 8/22/14
 */
public class AnalyticsInfluenceResponse extends SynthesioApiResponse {

    public AnalyticsInfluenceResponse(JsonObject apiResponse, String key) {
        super(apiResponse, key);
        parse();
    }

    private List<AnalyticsInfluencePeriod> periods = new ArrayList<>();
    private double globalInfluence;
    private String nextUrl;
    public List<AnalyticsInfluencePeriod> getPeriods() {
        return periods;
    }
    public double getGlobalInfluence() {
        return globalInfluence;
    }


    protected void parse() {
        // Get the "period" array
        JsonArray jsonPeriods = getJSON().get("periods").getAsJsonArray();

        // Parse each "period" element and add them to the ArrayList
        for (JsonElement period : jsonPeriods) {
            periods.add(new AnalyticsInfluencePeriod(period.getAsJsonObject()));
        }

        // Parse the global.influence object, which is a double
        globalInfluence = getJSON().get("global").getAsJsonObject().get("influence").getAsDouble();

        // Parse the next_url if there is one
        JsonElement nextUrlElement = getJSON().get("next_url");
        if (nextUrlElement != null) {
            nextUrl = nextUrlElement.getAsString();
        }
    }

}
