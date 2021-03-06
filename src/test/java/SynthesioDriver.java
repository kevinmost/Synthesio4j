import endpoints.analytics.*;
import endpoints.engagement.EngagementActions;
import endpoints.engagement.EngagementAgents;
import endpoints.engagement.EngagementHistory;
import endpoints.engagement.EngagementSSO;
import endpoints.profile.Profile;
import endpoints.report.Report;
import endpoints.report.ReportsList;
import endpoints.search.Search;
import endpoints.verbatim.VerbatimGet;
import responses.analytics.AnalyticsResponse;
import responses.profile.ProfileResponse;
import responses.report.ReportResponse;
import responses.report.ReportsListResponse;
import responses.search.SearchResponse;
import responses.verbatim.VerbatimGetResponse;
import synthesio.Synthesio;

import java.io.IOException;

/**
 * @author kevin
 * @date 8/21/14
 */
public class SynthesioDriver {
    // When the Synthesio object has the API key set, you don't have to pass your key into any future API calls that you make. The object will handle that.
    private static String testApiKey = "0635fdd44ad0cfc1358d16e20091266ec9adc864";
    private static Synthesio syn = new Synthesio(testApiKey);

    public static void main(String[] args) throws IOException {
        testAnalytics();
        testEngagement();
        testProfile();
        testReports();
        testSearch();
    }

    private static void testSearch() throws IOException {
        Search search = syn.makeApiCall(Search.class);

        search.setQuery("linux");
        search.setBefore("2013-10-01");

        SearchResponse response = search.executeApiCall();

        System.out.println(response.getResultsCount() + "results. Next URL is " + response.getNextUrl());
    }

    private static void testReports() throws IOException {
        ReportsList reportsList = syn.makeApiCall(ReportsList.class);

        ReportsListResponse reportsListResponse = reportsList.executeApiCall();

        int id = reportsListResponse.getReports().get(0).getId();



        Report report = syn.makeApiCall(Report.class);
        report.setReportId(21724);
        report.setCountry("fr"); // Reports from France
        ReportResponse reportResponse = report.executeApiCall();

        // Print the first 10 items in the list
        for (int i = 0; i < 10; i++) {
            System.out.print(reportResponse.getResults().get(i).getUrl() + ",");
        }
    }
    private static void testVerbatim() throws IOException {
        VerbatimGet verbatimGet = syn.makeApiCall(VerbatimGet.class);

        verbatimGet.setVerbatimId(27930393517L);

        VerbatimGetResponse response = verbatimGet.executeApiCall();

        System.out.println(response.getVerbatim().getUrl());
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
