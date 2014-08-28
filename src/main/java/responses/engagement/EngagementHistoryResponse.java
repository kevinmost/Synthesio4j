package responses.engagement;

import api.SynthesioApiResponse;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import response_data_structures.engagement.EngagementHistoryData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin
 * @date 8/25/14
 */
public class EngagementHistoryResponse extends SynthesioApiResponse {

    public EngagementHistoryResponse(JsonObject apiResponse) {
        super(apiResponse);
    }

    private List<EngagementHistoryData> history;
    private String nextUrl;
    public List<EngagementHistoryData> getHistory() {
        return history;
    }
    public String getNextUrl() {
        return nextUrl;
    }

    @Override
    protected void parse() throws IOException {
        history = new ArrayList<>();

        JsonArray jsonHistories = getAsJsonArray("history");

        for (JsonElement jsonHistory : jsonHistories) {
            history.add(new EngagementHistoryData(jsonHistory.getAsJsonObject()));
        }

        nextUrl = getAsString("next_url");
    }
}
