package response_data_structures.analytics;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kevin
 * @date 8/23/14
 */
public class AnalyticsNetSentimentPeriod extends AnalyticsNonGeneralData {

    private int netSentiment;
    private Map<String, Integer> topics = new HashMap<>();

    public AnalyticsNetSentimentPeriod(JsonObject object) {
        super(object);

        netSentiment = object.get("netsentiment").getAsInt();
    }

    @Override
    void addTopicsToMap(JsonArray topicsArray) {
        for (JsonElement topic : topicsArray) {
            JsonObject topicObject = topic.getAsJsonObject();
            topics.put(topicObject.get("topic").getAsString(), topicObject.get("netsentiment").getAsInt());
        }
    }


    public int getNetSentiment() {
        return netSentiment;
    }
    public Map<String, Integer> getTopics() {
        return topics;
    }
}
