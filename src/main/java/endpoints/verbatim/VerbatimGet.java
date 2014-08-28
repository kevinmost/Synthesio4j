package endpoints.verbatim;

import api.SynthesioApiCall;
import responses.verbatim.VerbatimGetResponse;

import java.io.IOException;

/**
 * @author kevin
 * @date 8/28/14
 */
public class VerbatimGet extends SynthesioApiCall {

    public VerbatimGet(String key) {
        super(key);
    }


    private String verbatimId;
    public void setVerbatimId(long verbatimId) {
        this.verbatimId = String.valueOf(verbatimId);
    }
    public void setVerbatimId(String verbatimId) {
        if (!verbatimId.matches("[0-9]+")) {
            throw new NumberFormatException("Your report ID was given as " + verbatimId + ". However, it must be an unsigned integer");
        }
        this.verbatimId = String.valueOf(verbatimId);
    }
    @Override
    protected String getBaseApiString() {
        return "https://api.synthesio.com/verbatim/" + verbatimId;
    }

    @SuppressWarnings("unchecked")
    @Override
    public VerbatimGetResponse executeApiCall() throws IOException {
        return super.makeCall(VerbatimGetResponse.class);
    }
}
