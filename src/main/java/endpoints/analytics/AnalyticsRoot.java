package endpoints.analytics;

import api.SynthesioApiCall;

/**
 * Adds on the parameters needed to the SynthesioApiCall base layer; that is, a reportId
 * @author kevin
 * @date 8/23/14
 */
abstract class AnalyticsRoot extends SynthesioApiCall {

    String reportId;

    protected AnalyticsRoot(String key) {
        super(key);
    }

    /**
     * Set the report ID that will be used in the base URL. This is mandatory before making the API call. A NullPointerException will result if executeApiCall() is invoked before setReportId()
     * @param reportId The report ID
     * @throws java.lang.NumberFormatException If you provide a negative-value reportId. reportId is an unsigned int
     */
    public void setReportId(String reportId) {
        if (!reportId.matches("[0-9]+")) {
            throw new NumberFormatException("Your report ID was given as " + reportId + ". However, it must be an unsigned integer");
        }
        this.reportId = String.valueOf(reportId);
    }
    /**
     * Set the report ID that will be used in the base URL. This is mandatory before making the API call. A NullPointerException will result if executeApiCall() is invoked before setReportId()
     * @param reportId The report ID
     * @throws java.lang.NumberFormatException If you provide a negative-value reportId. reportId is an unsigned int
     */
    public void setReportId(int reportId) {
        setReportId(String.valueOf(reportId));
    }
}
