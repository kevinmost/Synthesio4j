package endpoints.report;

import api.SynthesioApiCall;
import responses.report.ReportsListResponse;

import java.io.IOException;

/**
 * @author kevin
 * @date 8/28/14
 */
public class ReportsList extends SynthesioApiCall {
    public ReportsList(String key) {
        super(key);
    }

    @Override
    protected String getBaseApiString() {
        return "https://api.synthesio.com/report/";
    }

    @SuppressWarnings("unchecked")
    @Override
    public ReportsListResponse executeApiCall() throws IOException {
        return super.makeCall(ReportsListResponse.class);
    }
}
