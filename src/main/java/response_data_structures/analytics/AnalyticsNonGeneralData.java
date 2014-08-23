package response_data_structures.analytics;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.joda.time.DateTime;
import response_data_structures.JsonDataObject;
import response_data_structures.ResponseDataStructureUtils;

/**
 * @author kevin
 * @date 8/23/14
 */
public abstract class AnalyticsNonGeneralData extends JsonDataObject {

    protected DateTime start;
    protected DateTime end;
    protected JsonArray topicsArray;

    public AnalyticsNonGeneralData(JsonObject object) {
        super(object);

        start = ResponseDataStructureUtils.parseISO8601(object.get("start").getAsString());
        end = ResponseDataStructureUtils.parseISO8601(object.get("end").getAsString());

        JsonElement topics = object.get("topics");
        if (topics != null) {
            topicsArray = topics.getAsJsonArray();
        }
    }

    abstract void addTopicsToMap(JsonArray topicsArray);


    public DateTime getEnd() {
        return end;
    }
    public DateTime getStart() {
        return start;
    }
    public JsonArray getTopicsArray() {
        return topicsArray;
    }
}
