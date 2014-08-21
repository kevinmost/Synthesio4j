package analytics;

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
}
