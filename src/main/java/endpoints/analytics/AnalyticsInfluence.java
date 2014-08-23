package endpoints.analytics;

import responses.analytics.AnalyticsInfluenceResponse;

import java.io.IOException;

/**
 * @author kevin
 * @date 8/21/14
 */
public final class AnalyticsInfluence extends AnalyticsNonGeneral {

    public AnalyticsInfluence(String key) {
        super(key);
    }

    @Override
    protected String getBaseApiString() {
        return "https://api.synthesio.com/analytics/" + reportId + "/influence";
    }

    @SuppressWarnings("unchecked")
    @Override
    public AnalyticsInfluenceResponse executeApiCall() throws IOException {
        return super.makeCall(AnalyticsInfluenceResponse.class);
    }
}
