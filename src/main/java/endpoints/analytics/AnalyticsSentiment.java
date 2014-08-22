package endpoints.analytics;

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
}
