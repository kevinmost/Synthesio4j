package api;

import java.util.Map;

/**
 * The class that all other *ApiCall classes extend from
 * @author kevin
 * @date 8/21/14
 */
public abstract class SynthesioApiCall {

    // The parameters that will be defined for this API call
    Map<String, String> parameters;

    /**
     * Makes an API call using the parameters currently defined in this object
     * @return The results of the API call
     */
    abstract SynthesioApiResponse makeCall();

    // Set the API key that we are going to use for this call
    void setKey(String key) {
        parameters.put("key", key);
    }

    void setFormat(RestResponseFormat format) {
        parameters.put("format", format.getStr());
    }
}