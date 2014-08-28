package endpoints.profile;

import api.SynthesioApiCall;
import responses.profile.ProfileResponse;

import java.io.IOException;

/**
 * @author kevin
 * @date 8/28/14
 */
public class Profile extends SynthesioApiCall {

    public Profile(String key) {
        super(key);
    }

    private String profileId;
    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    @Override
    protected String getBaseApiString() {
        return "https://api.synthesio.com/profile/" + profileId;
    }

    @SuppressWarnings("unchecked")
    @Override
    public ProfileResponse executeApiCall() throws IOException {
        return super.makeCall(ProfileResponse.class);
    }
}
