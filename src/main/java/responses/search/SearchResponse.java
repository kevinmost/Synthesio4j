package responses.search;

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
 * @date 8/29/14
 */
public class SearchResponse extends SynthesioApiResponse {

    public SearchResponse(JsonObject apiResponse) {
        super(apiResponse);
    }

    private int resultsCount;
    private String nextUrl;
    private List<VerbatimData> results;
    public int getResultsCount() {
        return resultsCount;
    }
    public String getNextUrl() {
        return nextUrl;
    }
    public List<VerbatimData> getResults() {
        return results;
    }

    @Override
    protected void parse() throws IOException {
        results = new ArrayList<>();

        resultsCount = getAsInt("results_count");
        nextUrl = getAsString("next_url");

        JsonArray resultsArray = getAsJsonArray("results");

        for (JsonElement result : resultsArray) {
            results.add(new VerbatimData(result.getAsJsonObject()));
        }
    }
}
