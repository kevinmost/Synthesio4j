package response_data_structures.engagement;

import com.google.gson.JsonObject;
import org.joda.time.DateTime;
import response_data_structures.JsonDataObject;
import response_data_structures.ResponseDataStructureUtils;

/**
 * @author kevin
 * @date 8/25/14
 */
public class EngagementHistoryData extends JsonDataObject {
    private EngagementActionsData action;
    private EngagementAgentsData agent;
    private DateTime dateGMT;
    private int id;
    private String infoField;
    private String infoValue;
    private int report;
    private int timestamp;
    private int verbatimId;

    public EngagementActionsData getAction() {
        return action;
    }
    public EngagementAgentsData getAgent() {
        return agent;
    }
    public DateTime getDateGMT() {
        return dateGMT;
    }
    public int getId() {
        return id;
    }
    public String getInfoField() {
        return infoField;
    }
    public String getInfoValue() {
        return infoValue;
    }
    public int getReport() {
        return report;
    }
    public int getTimestamp() {
        return timestamp;
    }
    public int getVerbatimId() {
        return verbatimId;
    }

    public EngagementHistoryData(JsonObject object) {
        super(object);

        action = new EngagementActionsData(object.get("action").getAsJsonObject());
        if (!object.get("agent").isJsonNull()) agent = new EngagementAgentsData(object.get("agent").getAsJsonObject());
        dateGMT = ResponseDataStructureUtils.parseISO8601(object.get("dateGMT").getAsString());
        id = object.get("id").getAsInt();

        JsonObject info = object.get("info").getAsJsonObject();
        infoField = info.get("field").getAsString();
        infoValue = info.get("value").getAsString();

        report = object.get("report").getAsInt();
        timestamp = object.get("timestamp").getAsInt();
        verbatimId = object.get("verbatim").getAsInt();
    }
}
