package responses.engagement;

import api.SynthesioApiResponse;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import response_data_structures.engagement.EngagementActionsData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin
 * @date 8/23/14
 */
public class EngagementActionsResponse extends SynthesioApiResponse {

    public EngagementActionsResponse(JsonObject apiResponse) {
        super(apiResponse);
    }

    private List<EngagementActionsData> actions;
    public List<EngagementActionsData> getActions() {
        return actions;
    }

    @Override
    protected void parse() throws IOException {
        actions = new ArrayList<>();

        JsonArray actionsArray = getAsJsonArray("actions");

        for (JsonElement action : actionsArray) {
            actions.add(new EngagementActionsData(action.getAsJsonObject()));
        }
    }
}
