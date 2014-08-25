package endpoints.engagement;

import api.SynthesioApiCall;
import responses.engagement.EngagementHistoryResponse;

import java.io.IOException;

/**
 * @author kevin
 * @date 8/24/14
 */
public class EngagementHistory extends SynthesioApiCall {

    public EngagementHistory(String key) {
        super(key);
    }


    public void setActionId(int actionId) {
        setParameter("action", String.valueOf(actionId));
    }
    public void setActionId(String actionId) {
        setParameter("action", actionId);
    }
    public void setAfter(String after) {
        setParameter("after", after);
    }
    public void setAgent(int agent) {
        setParameter("agent", String.valueOf(agent));
    }
    public void setAgent(String agent) {
        setParameter("agent", agent);
    }
    public void setBefore(String before) {
        setParameter("before", before);
    }
    public void setVerbatimId(int verbatimId) {
        setParameter("verbatim", String.valueOf(verbatimId));
    }
    public void setVerbatimId(String verbatimId) {
        setParameter("verbatim", verbatimId);
    }


    @Override
    protected String getBaseApiString() {
        return "https://api.synthesio.com/engagement/history";
    }

    @SuppressWarnings("unchecked")
    @Override
    public EngagementHistoryResponse executeApiCall() throws IOException {
        return super.makeCall(EngagementHistoryResponse.class);
    }
}
