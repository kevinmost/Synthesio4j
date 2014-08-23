package response_data_structures.analytics;

import com.google.gson.JsonObject;

/**
 * @author kevin
 * @date 8/23/14
 */
public class Sentiment {
    private int negative;
    private int neutral;
    private int positive;

    public Sentiment(JsonObject object) {
        negative = object.get("negative").getAsInt();
        neutral = object.get("neutral").getAsInt();
        positive = object.get("positive").getAsInt();
    }

    public int getNegative() {
        return negative;
    }
    public int getNeutral() {
        return neutral;
    }
    public int getPositive() {
        return positive;
    }
}