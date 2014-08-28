package responses.profile;

import api.SynthesioApiResponse;
import com.google.gson.JsonObject;

import java.io.IOException;

/**
 * @author kevin
 * @date 8/28/14
 */
public class ProfileResponse extends SynthesioApiResponse {

    private String id;
    private String name;
    private String username;
    private String profileUrl;
    private String picture;
    private String sex;
    private String locale;
    private String location;
    private String bio;
    private String web;
    private String ranking;
    private Integer followers;
    private Integer following;
    private Integer updates;
    private Integer listed;


    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getUsername() {
        return username;
    }
    public String getProfileUrl() {
        return profileUrl;
    }
    public String getPicture() {
        return picture;
    }
    public String getSex() {
        return sex;
    }
    public String getLocale() {
        return locale;
    }
    public String getLocation() {
        return location;
    }
    public String getBio() {
        return bio;
    }
    public String getWeb() {
        return web;
    }
    public String getRanking() {
        return ranking;
    }
    public Integer getFollowers() {
        return followers;
    }
    public Integer getFollowing() {
        return following;
    }
    public Integer getUpdates() {
        return updates;
    }
    public Integer getListed() {
        return listed;
    }



    public ProfileResponse(JsonObject apiResponse) {
        super(apiResponse);
    }

    @Override
    protected void parse() throws IOException {
        id = getAsString("id");
        name = getAsString("name");
        username = getAsString("username");
        profileUrl = getAsString("profileUrl");
        picture = getAsString("picture");
        sex = getAsString("sex");
        locale = getAsString("locale");
        location = getAsString("location");
        bio = getAsString("bio");
        web = getAsString("web");
        ranking = getAsString("ranking");
        followers = getAsInt("followers");
        following = getAsInt("following");
        updates = getAsInt("updates");
        listed = getAsInt("listed");
    }
}
