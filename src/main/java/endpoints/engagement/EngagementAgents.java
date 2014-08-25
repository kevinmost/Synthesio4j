package endpoints.engagement;

import api.SynthesioApiCall;
import responses.engagement.EngagementAgentsResponse;

import java.io.IOException;

/**
 * @author kevin
 * @date 8/24/14
 */
public class EngagementAgents extends SynthesioApiCall {

    public EngagementAgents(String key) {
        super(key);
    }

    @Override
    protected String getBaseApiString() {
        return "https://api.synthesio.com/engagement/agents";
    }

    @SuppressWarnings("unchecked")
    @Override
    public EngagementAgentsResponse executeApiCall() throws IOException {
        return super.makeCall(EngagementAgentsResponse.class);
    }
}
