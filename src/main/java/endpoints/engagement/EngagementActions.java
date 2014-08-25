package endpoints.engagement;

import api.SynthesioApiCall;
import responses.engagement.EngagementActionsResponse;

import java.io.IOException;

/**
 * @author kevin
 * @date 8/23/14
 */
public class EngagementActions extends SynthesioApiCall {

    public EngagementActions(String key) {
        super(key);
    }

    @Override
    protected String getBaseApiString() {
        return "https://api.synthesio.com/engagement/actions";
    }

    @SuppressWarnings("unchecked")
    @Override
    public EngagementActionsResponse executeApiCall() throws IOException {
        return super.makeCall(EngagementActionsResponse.class);
    }
}
