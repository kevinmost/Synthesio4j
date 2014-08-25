package responses.engagement;

import api.SynthesioApiResponse;
import com.google.gson.JsonObject;

import java.io.IOException;

/**
 * @author kevin
 * @date 8/25/14
 */
public class EngagementSSOResponse extends SynthesioApiResponse {

    private int id;
    private String firstName;
    private String lastName;
    private String login;
    private String url;

    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getLogin() {
        return login;
    }
    public String getUrl() {
        return url;
    }

    public EngagementSSOResponse(JsonObject apiResponse) {
        super(apiResponse);
    }

    @Override
    protected void parse() throws IOException {
        JsonObject sso = getJSON().get("sso").getAsJsonObject();

        id = sso.get("id").getAsInt();
        firstName = sso.get("firstName").getAsString();
        lastName = sso.get("lastName").getAsString();
        login = sso.get("login").getAsString();
        url = sso.get("url").getAsString();
    }
}
