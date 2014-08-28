package response_data_structures;

import com.google.gson.JsonObject;

/**
 * @author kevin
 * @date 8/23/14
 */
public abstract class JsonDataObject {
    protected JsonObject object;

    public JsonDataObject(JsonObject object) {
        this.object = object;
        parse();
    }

    protected abstract void parse();
}
