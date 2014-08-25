package endpoints.engagement;

import api.SynthesioApiCall;
import responses.engagement.EngagementSSOResponse;

import java.io.IOException;

/**
 * @author kevin
 * @date 8/25/14
 */
public class EngagementSSO extends SynthesioApiCall {

    public EngagementSSO(String key) {
        super(key);
    }

    public void setAgentId(int agentId) {
        setParameter("agent", String.valueOf(agentId));
    }
    public void setAgentId(String agentId) {
        setParameter("agent", agentId);
    }
    public void setUrl(String url) {
        setParameter("url", url);
    }

    @Override
    protected String getBaseApiString() {
        return "https://api.synthesio.com/engagement/sso";
    }

    @SuppressWarnings("unchecked")
    @Override
    public EngagementSSOResponse executeApiCall() throws IOException {
        return super.makeCall(EngagementSSOResponse.class);
    }
}
