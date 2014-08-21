package synthesio;

/**
 * Use this factory to create a Synthesio object. The Synthesio object will then be used to make all API calls
 * @author kevin
 * @date 8/21/14
 */
public class SynthesioFactory {

    public static Synthesio createSynthesio(String apiKey) {
        return new Synthesio(apiKey);
    }
}
