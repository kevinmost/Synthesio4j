package api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import constants.RestResponseFormat;
import gumi.builders.UrlBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
    Map<String, String> parameters = new HashMap<>();

    protected SynthesioApiCall(String key) {
        setKey(key);
    }

    /**
     * Makes an API call using the parameters currently defined in this object
     * @return The results of the API call
     */
    @SuppressWarnings("unchecked")
    protected <T extends SynthesioApiResponse> T makeCall(Class<T> clazz) throws IOException {
        // Creates a UrlBuilder object that contains the base URL for the current object with all of the non-null parameters appended
        UrlBuilder builder = UrlBuilder.fromString(getBaseApiString());
        for (Map.Entry<String, String> parameter : parameters.entrySet()) {
            if (parameter.getValue() != null) {
                builder = builder.addParameter(parameter.getKey(), parameter.getValue());
            }
        }
        try {
            System.err.println("Initializing " + clazz.getName());
            Constructor c = clazz.getDeclaredConstructors()[0];
            c.setAccessible(true);
            return (T) c.newInstance(getJsonFromUrl(builder.toUrl()));
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Set the API key that we are going to use for this call
     * @param key Your API key
     */
    public void setKey(String key) {
        parameters.put("key", key);
    }

    /**
     * Set the API response format that you want (JSON or XML). Defaults to JSON if none specified
     * @param format The format (either RestResponseFormat.JSON or RestResponseFormat.XML)
     */
    public void setFormat(RestResponseFormat format) {
        parameters.put("format", format.getStr());
    }

    /**
     * Set any parameter within the parameters Map. This is a protected method so that the user cannot directly set anything that the library doesn't allow them to
     * @param key the key for the entry
     * @param value the value for the entry
     */
    protected void setParameter(String key, String value) {
        parameters.put(key, value);
    }

    /**
     * @return the base URL that this API endpoint uses. This is implemented as an abstract method so that all subclasses are forced to define their own endpoint
     */
    protected abstract String getBaseApiString();


    /**
     * Make the API call that you have built up, and return an object that extends SynthesioApiResponse
     * @param <T> The corresponding type that extends out from SynthesioApiResponse. eg, if you did executeApiCall() on an AnalyticsNetSentiment, you get an AnalyticsNetSentimentResponse
     * @return A response from the Synthesio API
     * @throws IOException If the API call could not be completed
     */
    public abstract <T extends SynthesioApiResponse> T executeApiCall() throws IOException;

    /**
     * Given a URL object, returns a JSON representation of the response given when querying that URL
     * @param url URL to query for a JSON response
     * @return JSON object representing that URL query
     * @throws IOException If the HTTP call cannot be completed
     */
    public static JsonObject getJsonFromUrl(URL url) throws IOException {
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        return jp.parse(new InputStreamReader((InputStream)request.getContent())).getAsJsonObject();
    }
}