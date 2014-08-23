package response_data_structures.analytics;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kevin
 * @date 8/22/14
 */
public final class AnalyticsInfluencePeriod extends AnalyticsNonGeneralData {

    private double influence;
    private Map<String, Double> topics = new HashMap<>();


    public AnalyticsInfluencePeriod(JsonObject object) {
        super(object);

        influence = object.get("influence").getAsDouble();
    }

    @Override
    void addTopicsToMap(JsonArray topicsArray) {
        for (JsonElement topic : topicsArray) {
            JsonObject topicObject = topic.getAsJsonObject();
            topics.put(topicObject.get("topic").getAsString(), topicObject.get("influence").getAsDouble());
        }
    }

    public double getInfluence() {
        return influence;
    }
    public Map<String, Double> getTopics() {
        return topics;
    }
}
