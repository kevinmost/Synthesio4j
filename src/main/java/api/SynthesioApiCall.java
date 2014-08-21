package api;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import gumi.builders.UrlBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * The class that all other *ApiCall classes extend from
 * This class is responsible for making the API call and then it returns a SynthesioApiResponse
 * @author kevin
 * @date 8/21/14
 */
public abstract class SynthesioApiCall {

    // The parameters that will be defined for this API call
    Map<String, String> parameters = new HashMap<String, String>();

    protected SynthesioApiCall(String key) {
        setKey(key);
    }

    /**
     * Makes an API call using the parameters currently defined in this object
     * @return The results of the API call
     */
    public SynthesioApiResponse makeCall() throws IOException {
        UrlBuilder builder = UrlBuilder.fromString(getBaseApiString());
        for (Map.Entry<String, String> parameter : parameters.entrySet()) {
            if (parameter.getValue() != null) {
                builder = builder.addParameter(parameter.getKey(), parameter.getValue());
            }
        }
        return new SynthesioApiResponse(getJsonFromUrl(builder.toUrl()));
    }

    // Set the API key that we are going to use for this call
    public void setKey(String key) {
        parameters.put("key", key);
    }

    // Set the API response format that you want (JSON or XML)
    public void setFormat(RestResponseFormat format) {
        parameters.put("format", format.getStr());
    }

    // Set any other parameter
    protected void setParameter(String key, String value) {
        parameters.put(key, value);
    }

    // Returns the base URL that this API endpoint uses. This is implemented as an abstract method so that all subclasses are forced to define their own endpoint
    protected abstract String getBaseApiString();

    /**
     * Given a URL object, returns a JSON representation of the response given when querying that URL
     * @param url URL to query for a JSON response
     * @return JSON object representing that URL query
     * @throws IOException If the HTTP call cannot be completed
     */
    protected static JsonElement getJsonFromUrl(URL url) throws IOException {
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        return jp.parse(new InputStreamReader((InputStream)request.getContent()));
    }
}