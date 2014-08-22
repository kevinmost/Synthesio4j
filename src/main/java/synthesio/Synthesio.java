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


    public <T extends SynthesioApiCall> T makeApiCall(Class<T> clazz) {
        Constructor c = clazz.getDeclaredConstructors()[0];
        try {
            return (T)(c.newInstance(key));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
