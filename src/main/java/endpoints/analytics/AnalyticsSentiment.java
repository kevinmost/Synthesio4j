package endpoints.analytics;

/**
 * @author kevin
 * @date 8/21/14
 */
public abstract class AnalyticsSentiment extends AnalyticsNonGeneral {

    protected AnalyticsSentiment(String key) {
        super(key);
    }

    @Override
    protected String getBaseApiString() {
        return "https://api.synthesio.com/analytics/" + reportId + "/sentiment";
    }
}
