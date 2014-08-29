package response_data_structures.report;

import com.google.gson.JsonObject;
import response_data_structures.JsonDataObject;

/**
 * @author kevin
 * @date 8/28/14
 */
public class ReportsListData extends JsonDataObject {

    public ReportsListData(JsonObject object) {
        super(object);
    }

    private int id;
    private String title;
    private String type;
    private JsonObject tags;
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getType() {
        return type;
    }
    public JsonObject getTags() {
        return tags;
    }

    @Override
    protected void parse() {
        id = object.get("id").getAsInt();
        title = object.get("title").getAsString();
        type = object.get("type").getAsString();
        tags = object.get("tags").getAsJsonObject();
    }
}
