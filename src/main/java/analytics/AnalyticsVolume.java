package analytics;

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
}
