package analytics;

import api.SynthesioApiCall;
import api.SynthesioApiResponse;

import java.io.IOException;

/**
 * @author kevin
 * @date 8/21/14
 */
public class Analytics extends SynthesioApiCall {

    String reportId;

    /**
     * Set the report ID that will be used in the base URL. This is mandatory before making the API call. A NullPointerException will result if makeCall() is invoked before setReportId()
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
     * Set the report ID that will be used in the base URL. This is mandatory before making the API call. A NullPointerException will result if makeCall() is invoked before setReportId()
     * @param reportId The report ID
     * @throws java.lang.NumberFormatException If you provide a negative-value reportId. reportId is an unsigned int
     */
    public void setReportId(int reportId) {
        setReportId(String.valueOf(reportId));
    }





    public Analytics(String key) {
        super(key);
    }

    @Override
    public SynthesioApiResponse makeCall() throws IOException {
        // Check if the reportId has been set. If it has, let the superclass make the call as normal
        if (reportId == null) {
            throw new NullPointerException("You must specify a reportId by calling the setReportId() method on this object before calling makeCall()");
        }
        return super.makeCall();
    }

    @Override
    protected String getBaseApiString() {
        return "https://api.synthesio.com/analytics/" + reportId + "/influence/";
    }
}
