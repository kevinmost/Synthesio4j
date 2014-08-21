package synthesio;

import analytics.Analytics;

/**
 * @author kevin
 * @date 8/21/14
 */
public class Synthesio {

    String key;

    protected Synthesio(String apiKey) {
        this.key = apiKey;

    }

    public Analytics makeAnalyticsApiCall() {
        return new Analytics(key);
    }
}
