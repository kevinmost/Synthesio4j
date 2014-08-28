import endpoints.analytics.*;
import endpoints.engagement.EngagementActions;
import endpoints.engagement.EngagementAgents;
import endpoints.engagement.EngagementHistory;
import endpoints.engagement.EngagementSSO;
import endpoints.profile.Profile;
import responses.analytics.AnalyticsResponse;
import responses.profile.ProfileResponse;
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
//        testEngagement();
//        testProfile();
    }

    private static void testProfile() throws IOException {
        Profile profile = syn.makeApiCall(Profile.class);

        // We are getting the profile for the Facebook user 178732245548073
        profile.setProfileId("facebook.com:178732245548073");

        ProfileResponse response = profile.executeApiCall();

        System.out.println(response.getName() + ": " + response.getRanking());
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
        System.out.println(influence.executeApiCall().getNextUrl());

        AnalyticsNetSentiment netSentiment = response.getNetSentiment();
        System.out.println(netSentiment.executeApiCall().getGlobalNetSentiment());

        AnalyticsSentiment sentiment = response.getSentiment();
        System.out.println(sentiment.executeApiCall().getGlobalSentiment().getNegative());

        AnalyticsVolume volume = response.getVolume();
        System.out.println(volume.executeApiCall().getGlobalVolume());
    }

    private static void testEngagement() throws IOException {
        EngagementActions actions = syn.makeApiCall(EngagementActions.class);
        System.out.println(actions.executeApiCall().getActions().get(0).getAction());

        EngagementAgents agents = syn.makeApiCall(EngagementAgents.class);
        System.out.println(agents.executeApiCall().getAgents().get(0).getFirstName());

        EngagementHistory history = syn.makeApiCall(EngagementHistory.class);
        System.out.println(history.executeApiCall().getHistory().get(0).getDateGMT());

        EngagementSSO sso = syn.makeApiCall(EngagementSSO.class);
        sso.setAgentId(4738);
        System.out.println(sso.executeApiCall().getFirstName());
    }
}
