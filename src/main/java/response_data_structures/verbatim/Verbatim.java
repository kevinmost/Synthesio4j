package response_data_structures.verbatim;

import com.google.gson.JsonObject;
import response_data_structures.JsonDataObject;

/**
 * @author kevin
 * @date 8/28/14
 */
public class Verbatim extends JsonDataObject {

    private String author;
    private String content;
    private String country;
    private String countryShort;
    private String dateGMT;
    private String geo;
    private int id;
    private String language;
    private String languageShort;
    private String mediaType;
    private boolean restrictedUsage;
    private String sentiment;
    private String source;
    private float synthesioRank;
    private int timestamp;
    private String topics;
    private String title;
    private String url;
    private int viewCount;

    public String getAuthor() {
        return author;
    }
    public String getContent() {
        return content;
    }
    public String getCountry() {
        return country;
    }
    public String getCountryShort() {
        return countryShort;
    }
    public String getDateGMT() {
        return dateGMT;
    }
    public String getGeo() {
        return geo;
    }
    public int getId() {
        return id;
    }
    public String getLanguage() {
        return language;
    }
    public String getLanguageShort() {
        return languageShort;
    }
    public String getMediaType() {
        return mediaType;
    }
    public boolean isRestrictedUsage() {
        return restrictedUsage;
    }
    public String getSentiment() {
        return sentiment;
    }
    public String getSource() {
        return source;
    }
    public float getSynthesioRank() {
        return synthesioRank;
    }
    public int getTimestamp() {
        return timestamp;
    }
    public String getTopics() {
        return topics;
    }
    public String getTitle() {
        return title;
    }
    public String getUrl() {
        return url;
    }
    public int getViewCount() {
        return viewCount;
    }


    public Verbatim(JsonObject object) {
        super(object);
    }

    @Override
    protected void parse() {
        author = object.get("author").getAsString();
        content = object.get("content").getAsString();
        country = object.get("country").getAsString();
        countryShort = object.get("countryShort").getAsString();
        dateGMT = object.get("dateGMT").getAsString();
        geo = object.get("geo").getAsString();
        id = object.get("id").getAsInt();
        language = object.get("language").getAsString();
        languageShort = object.get("languageShort").getAsString();
        mediaType = object.get("mediaType").getAsString();
        restrictedUsage = object.get("restrictedUsage").getAsBoolean();
        sentiment = object.get("sentiment").getAsString();
        source = object.get("source").getAsString();
        synthesioRank = object.get("synthesioRank").getAsFloat();
        timestamp = object.get("timestamp").getAsInt();
        topics = object.get("topics").getAsString();
        title = object.get("title").getAsString();
        url = object.get("url").getAsString();
        viewCount = object.get("viewCount").getAsInt();
    }
}
