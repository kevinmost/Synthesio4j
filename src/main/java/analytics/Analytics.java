package analytics;

import api.SynthesioApiCall;

/**
 * @author kevin
 * @date 8/21/14
 */
public class Analytics extends SynthesioApiCall {

    String reportId;

    public Analytics(String key) {
        super(key);
    }

    @Override
    protected String getBaseApiString() {
        return "https://api.synthesio.com/analytics/" + reportId + "/influence/";
    }

    /**
     * Set the report ID that will be used. This is mandatory before making the API call
     * @param reportId The report ID
     * @throws java.lang.NumberFormatException If you provide a negative-value reportId. reportId is an unsigned int
     */
    public void setReportId(String reportId) {
        if (!reportId.matches("[0-9]+")) {
            throw new NumberFormatException("Your report ID was given as " + reportId + ". However, it must be an unsigned integer");
        }
        this.reportId = String.valueOf(reportId);
    }
    public void setReportId(int reportId) {
        setReportId(String.valueOf(reportId));
    }


}
