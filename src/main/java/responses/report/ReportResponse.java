package responses.report;

import api.SynthesioApiResponse;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import response_data_structures.verbatim.VerbatimData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin
 * @date 8/28/14
 */
public class ReportResponse extends SynthesioApiResponse {

    public ReportResponse(JsonObject apiResponse) {
        super(apiResponse);
    }

    List<VerbatimData> results;
    String nextUrl;
    public List<VerbatimData> getResults() {
        return results;
    }
    public String getNextUrl() {
        return nextUrl;
    }

    @Override
    protected void parse() throws IOException {
        nextUrl = getJSON().get("next_url").getAsString();

        results = new ArrayList<>();
        JsonArray verbatims = getJSON().get("results").getAsJsonArray();

        for (JsonElement verbatim : verbatims) {
            results.add(new VerbatimData(verbatim.getAsJsonObject()));
        }
    }
}
