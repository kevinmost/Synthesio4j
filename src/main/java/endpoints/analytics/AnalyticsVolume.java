package endpoints.analytics;

import responses.analytics.AnalyticsVolumeResponse;

import java.io.IOException;

/**
 * @author kevin
 * @date 8/21/14
 */
public final class AnalyticsVolume extends AnalyticsNonGeneral {

    public AnalyticsVolume(String key) {
        super(key);
    }

    @Override
    protected String getBaseApiString() {
        return "https://api.synthesio.com/analytics/" + reportId + "/volume";
    }

    @SuppressWarnings("unchecked")
    @Override
    public AnalyticsVolumeResponse executeApiCall() throws IOException {
        return super.makeCall(AnalyticsVolumeResponse.class);
    }
}
