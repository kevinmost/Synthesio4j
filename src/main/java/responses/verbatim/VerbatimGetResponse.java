package responses.verbatim;

import api.SynthesioApiResponse;
import com.google.gson.JsonObject;
import response_data_structures.verbatim.VerbatimData;

import java.io.IOException;

/**
 * @author kevin
 * @date 8/28/14
 */
public class VerbatimGetResponse extends SynthesioApiResponse {

    public VerbatimGetResponse(JsonObject apiResponse) {
        super(apiResponse);
    }

    private VerbatimData verbatim;
    public VerbatimData getVerbatim() {
        return verbatim;
    }

    @Override
    protected void parse() throws IOException {
        // TODO: This is untested because the API documentation does not provide an endpoint example that actually returns a valid JSON. Still needs to be tested with an actual API key
        verbatim = new VerbatimData(getJSON());
    }
}
