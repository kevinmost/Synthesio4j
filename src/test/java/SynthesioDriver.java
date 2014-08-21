import analytics.AnalyticsNetSentiment;
import com.google.gson.JsonElement;
import synthesio.Synthesio;
import synthesio.SynthesioFactory;

import java.io.IOException;

/**
 * @author kevin
 * @date 8/21/14
 */
public class SynthesioDriver {
    public static void main(String[] args) throws IOException {
        String testApiKey = "0635fdd44ad0cfc1358d16e20091266ec9adc864";
        Synthesio syn = SynthesioFactory.createSynthesio(testApiKey);

        testAnalytics(syn);

    }

    private static void testAnalytics(Synthesio syn) throws IOException {
        AnalyticsNetSentiment analytics = syn.makeAnalyticsNetSentimentApiCall();

        analytics.setReportId(21724);

        analytics.setAfter("2014-08-08T00:00:00+00:00");

        JsonElement response = analytics.makeCall().getApiResponse();

        System.out.println(response.toString());
    }
}
