package responses.analytics;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import response_data_structures.analytics.AnalyticsVolumePeriod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin
 * @date 8/23/14
 */
public final class AnalyticsVolumeResponse extends AnalyticsRootResponse {
    public AnalyticsVolumeResponse(JsonObject apiResponse) {
        super(apiResponse);
    }

    private int globalVolume;
    private List<AnalyticsVolumePeriod> periods;
    public int getGlobalVolume() {
        return globalVolume;
    }
    public List<AnalyticsVolumePeriod> getPeriods() {
        return periods;
    }

    @Override
    protected void parse() throws IOException {
        periods = new ArrayList<>();

        JsonArray jsonPeriods = getAsJsonArray("periods");

        for (JsonElement period : jsonPeriods) {
            periods.add(new AnalyticsVolumePeriod(period.getAsJsonObject()));
        }

        globalVolume = getAsInt(getAsJsonObject("global"), "volume");
    }
}
