package responses.report;

import api.SynthesioApiResponse;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import response_data_structures.report.Report;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin
 * @date 8/28/14
 */
public class ReportsListResponse extends SynthesioApiResponse {

    public ReportsListResponse(JsonObject apiResponse) {
        super(apiResponse);
    }

    List<Report> reports;
    public List<Report> getReports() {
        return reports;
    }

    @Override
    protected void parse() throws IOException {
        reports = new ArrayList<>();

        JsonArray root = getJSON().get("element").getAsJsonArray();

        for (JsonElement report : root) {
            reports.add(new Report(report.getAsJsonObject()));
        }
    }
}
