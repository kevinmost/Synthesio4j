package responses.engagement;

import api.SynthesioApiResponse;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import response_data_structures.engagement.EngagementAgentsData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin
 * @date 8/24/14
 */
public class EngagementAgentsResponse extends SynthesioApiResponse {
    public EngagementAgentsResponse(JsonObject apiResponse) {
        super(apiResponse);
    }

    private List<EngagementAgentsData> agents;
    public List<EngagementAgentsData> getAgents() {
        return agents;
    }

    @Override
    protected void parse() throws IOException {
        agents = new ArrayList<>();

        JsonArray agentsArray = getJSON().get("users").getAsJsonArray();

        for (JsonElement agent : agentsArray) {
            agents.add(new EngagementAgentsData(agent.getAsJsonObject()));
        }
    }
}
