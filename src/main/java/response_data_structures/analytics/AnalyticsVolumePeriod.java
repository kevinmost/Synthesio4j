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
public final class AnalyticsVolumePeriod extends AnalyticsNonGeneralData {

    public AnalyticsVolumePeriod(JsonObject object) {
        super(object);
    }

    private int volume;
    private Map<String, Integer> topics = new HashMap<>();

    @Override
    void addTopicsToMap(JsonArray topicsArray) {
        for (JsonElement topic : topicsArray) {
            JsonObject topicAsObject = topic.getAsJsonObject();
            topics.put(topicAsObject.get("topic").getAsString(), topicAsObject.get("volume").getAsInt());
        }
    }

    public Map<String, Integer> getTopics() {
        return topics;
    }
    public int getVolume() {
        return volume;
    }
}