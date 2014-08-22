import com.google.gson.JsonElement;
import endpoints.analytics.AnalyticsNetSentiment;
import synthesio.Synthesio;

import java.io.IOException;

/**
 * @author kevin
 * @date 8/21/14
 */
public class SynthesioDriver {
    public static void main(String[] args) throws IOException {
        String testApiKey = "0635fdd44ad0cfc1358d16e20091266ec9adc864";
        Synthesio syn = new Synthesio(testApiKey);

        testAnalytics(syn);

    }

    private static void testAnalytics(Synthesio syn) throws IOException {
        AnalyticsNetSentiment analytics = syn.makeApiCall(AnalyticsNetSentiment.class);

        analytics.setReportId(21724);

        analytics.setAfter("2014-08-08T00:00:00+00:00");

        JsonElement response = analytics.makeCall().getApiResponse();

        System.out.println(response.toString());
    }
}
