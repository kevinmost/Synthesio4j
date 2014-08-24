package endpoints.engagement;

import api.SynthesioApiCall;
import api.SynthesioApiResponse;

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

    @Override
    public <T extends SynthesioApiResponse> T executeApiCall() throws IOException {
        return null;
    }
}
