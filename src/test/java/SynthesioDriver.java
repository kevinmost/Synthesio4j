import endpoints.analytics.Analytics;
import endpoints.analytics.AnalyticsInfluence;
import responses.analytics.AnalyticsInfluenceResponse;
import responses.analytics.AnalyticsResponse;
import synthesio.Synthesio;

import java.io.IOException;

/**
 * @author kevin
 * @date 8/21/14
 */
public class SynthesioDriver {

    private static String testApiKey = "0635fdd44ad0cfc1358d16e20091266ec9adc864";
    private static Synthesio syn = new Synthesio(testApiKey);

    public static void main(String[] args) throws IOException {
        testAnalytics();

    }

    /**
     * Test to make sure that our analytics objects work well
     * @throws IOException If we can't get our JSONs for whatever reason
     */
    private static void testAnalytics() throws IOException {
        // Creates an analytics object using our Synthesio object
        Analytics analytics = syn.makeApiCall(Analytics.class);

        // Set the reportid that we want for this Analytics object
        analytics.setReportId(21724);

        // Makes the API call and gets the response. This is a general Analytics call and will simply return 4 more endpoints that we can query
        AnalyticsResponse response = analytics.executeApiCall();

        AnalyticsInfluence influence = response.getInfluence();
        AnalyticsInfluenceResponse influenceResponse = influence.executeApiCall();
        System.out.println(influenceResponse.getGlobalInfluence());

//        // Gets the Influence object that was created when we had our AnalyticsResponse object automatically parse all of the links returned to it
//        AnalyticsInfluence influence = response.getInfluence();
//
//        AnalyticsInfluenceResponse influenceResponse = influence.executeApiCall();
//
//        System.out.println(influenceResponse.getGlobalInfluence());


    }
}
