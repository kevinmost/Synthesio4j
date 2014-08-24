package response_data_structures.engagement;

import com.google.gson.JsonObject;
import response_data_structures.JsonDataObject;

/**
 * @author kevin
 * @date 8/23/14
 */
public class EngagementActionsData extends JsonDataObject {

    private String action;
    private int id;
    private String type;

    public EngagementActionsData(JsonObject object) {
        super(object);
        action = object.get("action").getAsString();
        id = object.get("id").getAsInt();
        type = object.get("type").getAsString();
    }

    public int getId() {
        return id;
    }
    public String getAction() {
        return action;
    }
    public String getType() {
        return type;
    }
}
