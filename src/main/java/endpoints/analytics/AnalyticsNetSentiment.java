package endpoints.analytics;

/**
 * All parameters within this are the same as within AnalyticsInfluence, so we don't need to do anything beyond extending this class and changing the endpoint URL
 * @author kevin
 * @date 8/21/14
 */
public abstract class AnalyticsNetSentiment extends AnalyticsNonGeneral {

    protected AnalyticsNetSentiment(String key) {
        super(key);
    }

    @Override
    protected String getBaseApiString() {
        return "https://api.synthesio.com/analytics/" + reportId + "/netsentiment";
    }
}
