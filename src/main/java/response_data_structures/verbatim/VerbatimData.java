package response_data_structures.verbatim;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.commons.lang3.StringUtils;
import response_data_structures.JsonDataObject;

import java.lang.reflect.Field;

/**
 * @author kevin
 * @date 8/28/14
 */
public class VerbatimData extends JsonDataObject {

    private JsonObject author;
    private String content;
    private String country;
    private String countryShort;
    private String dateGMT;
    private JsonObject geo;
    private Integer id;
    private String language;
    private String languageShort;
    private String mediaType;
    private Boolean restrictedUsage;
    private String sentiment;
    private String source;
    private Float synthesioRank;
    private Integer timestamp;
    private String topics;
    private String title;
    private String url;
    private Integer viewCount;

    public JsonObject getAuthor() {
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
    public JsonObject getGeo() {
        return geo;
    }
    public Integer getId() {
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
    public Boolean isRestrictedUsage() {
        return restrictedUsage;
    }
    public String getSentiment() {
        return sentiment;
    }
    public String getSource() {
        return source;
    }
    public Float getSynthesioRank() {
        return synthesioRank;
    }
    public Integer getTimestamp() {
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
    public Integer getViewCount() {
        return viewCount;
    }


    public VerbatimData(JsonObject object) {
        super(object);
    }

    @Override
    protected void parse() {

        try {
            for (Field field : this.getClass().getDeclaredFields()) {
                JsonElement el = object.get(field.getName());
                if (el != null && !el.isJsonNull()) {
                    switch (field.getType().getName()) {
                        case "java.lang.Integer":
                            field.set(this, el.getAsInt());
                            break;
                        case "java.lang.String":
                            if (el.isJsonArray()) field.set(this, StringUtils.join(el.getAsJsonArray(), ','));
                            else field.set(this, el.getAsString());
                            break;
                        case "java.lang.Float":
                            field.set(this, el.getAsFloat());
                            break;
                        case "java.lang.Boolean":
                            field.set(this, el.getAsBoolean());
                            break;
                        case "com.google.gson.JsonObject":
                            field.set(this, el.getAsJsonObject());
                            break;
                        default:
                            System.err.println("pls: " + field.getType().getName());
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
