package endpoints.analytics;

import responses.analytics.AnalyticsSentimentResponse;

import java.io.IOException;

/**
 * @author kevin
 * @date 8/21/14
 */
public final class AnalyticsSentiment extends AnalyticsNonGeneral {

    public AnalyticsSentiment(String key) {
        super(key);
    }

    @Override
    protected String getBaseApiString() {
        return "https://api.synthesio.com/analytics/" + reportId + "/sentiment";
    }

    @SuppressWarnings("unchecked")
    @Override
    public AnalyticsSentimentResponse executeApiCall() throws IOException {
        return super.makeCall(AnalyticsSentimentResponse.class);
    }
}
