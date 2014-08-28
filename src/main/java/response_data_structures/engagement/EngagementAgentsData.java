package response_data_structures.engagement;

import com.google.gson.JsonObject;
import response_data_structures.JsonDataObject;

/**
 * @author kevin
 * @date 8/24/14
 */
public class EngagementAgentsData extends JsonDataObject {

    private int id;
    private String firstName;
    private String lastName;
    private String login;

    public EngagementAgentsData(JsonObject object) {
        super(object);
    }

    @Override
    protected void parse() {
        id = object.get("id").getAsInt();
        firstName = object.get("firstName").getAsString();
        lastName = object.get("lastName").getAsString();
        login = object.get("login").getAsString();
    }

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
}
