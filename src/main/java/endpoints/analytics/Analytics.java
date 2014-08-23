package endpoints.analytics;

import responses.analytics.AnalyticsResponse;

import java.io.IOException;

/**
 * @author kevin
 * @date 8/21/14
 */
public final class Analytics extends AnalyticsRoot {

    public Analytics(String key) {
        super(key);
    }

    @SuppressWarnings("unchecked")
    @Override
    /**
     * Make the API call and get an AnalyticsResponse object
     */
    public AnalyticsResponse executeApiCall() throws IOException {
        // Check if the reportId has been set. If it has, let the superclass make the call as normal
        if (reportId == null) {
            throw new NullPointerException("You must specify a reportId by calling the setReportId() method on this object before calling executeApiCall()");
        }
        return super.makeCall(AnalyticsResponse.class);
    }

    @Override
    protected String getBaseApiString() {
        return "https://api.synthesio.com/analytics/" + reportId;
    }
}
