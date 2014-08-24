package synthesio;

import api.SynthesioApiCall;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author kevin
 * @date 8/21/14
 */
public class Synthesio {

    String key;

    public Synthesio(String apiKey) {
        this.key = apiKey;

    }


    /**
     * Allows you to use this Synthesio object to make API calls
     * @param clazz The class that represents the Synthesio endpoint you would like to query
     * @param <T> Any class that extends SynthesioApiCall; that is, any endpoint in the Synthesio API
     * @return An instance of the specified subclass of SynthesioApiCall, which you can then act on to make an API call
     */
    @SuppressWarnings("unchecked")
    public <T extends SynthesioApiCall> T makeApiCall(Class<T> clazz) {
        Constructor c = clazz.getDeclaredConstructors()[0];
        try {
            return (T)c.newInstance(key);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
