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
public final class AnalyticsSentimentPeriod extends AnalyticsNonGeneralData {
    public AnalyticsSentimentPeriod(JsonObject object) {
        super(object);

        sentiment = new Sentiment(object.get("sentiment").getAsJsonObject());
    }

    private Sentiment sentiment;
    private Map<String, Sentiment> topics = new HashMap<>();
    public Sentiment getSentiment() {
        return sentiment;
    }
    public Map<String, Sentiment> getTopics() {
        return topics;
    }

    @Override
    void addTopicsToMap(JsonArray topicsArray) {
        for (JsonElement topic : topicsArray) {
            JsonObject topicObject = topic.getAsJsonObject();
            topics.put(topicObject.get("topic").getAsString(), new Sentiment(topicObject.get("sentiment").getAsJsonObject()));
        }
    }
}
