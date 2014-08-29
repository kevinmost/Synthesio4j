package endpoints.report;

import api.SynthesioApiCall;
import constants.RestMediaType;
import constants.RestSentiment;
import org.apache.commons.lang3.StringUtils;
import responses.report.ReportResponse;

import java.io.IOException;

/**
 * @author kevin
 * @date 8/28/14
 */
public class Report extends SynthesioApiCall {
    public Report(String key) {
        super(key);
    }

    private String reportId;
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

    public void setAfter(String after) {
        setParameter("after", after);
    }
    public void setBefore(String before) {
        setParameter("before", before);
    }
    public void setCountry(String country) {
        setParameter("country", country);
    }
    public void setLanguage(String language) {
        setParameter("language", language);
    }
    public void setLimit(int limit) {
        setParameter("interval", String.valueOf(limit));
    }
    public void setMediaType(RestMediaType mediatype) {
        setParameter("mediatype", mediatype.getStr());
    }
    public void setOffset(int offset) {
        setParameter("offset", String.valueOf(offset));
    }
    public void setQuery(String query) {
        setParameter("query", query);
    }
    public void setRank(float rank) {
        setParameter("rank", String.valueOf(rank));
    }
    public void setReviewed(boolean reviewed) {
        setParameter("reviewed", reviewed?"1":"0");
    }
    public void setSentiment(RestSentiment sentiment) {
        setParameter("sentiment", sentiment.getStr());
    }
    public void setTags(String... tags) {
        setParameter("tag", StringUtils.join(tags, ','));
    }


    @Override
    protected String getBaseApiString() {
        return "https://api.synthesio.com/report/" + reportId;
    }

    @SuppressWarnings("unchecked")
    @Override
    public ReportResponse executeApiCall() throws IOException {
        return super.makeCall(ReportResponse.class);
    }
}
