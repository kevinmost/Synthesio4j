package endpoints.analytics;

import constants.RestInterval;
import constants.RestMediaType;
import org.apache.commons.lang3.StringUtils;

/**
 * The overarching class that all Analytics classes (with the exception of the regular, general Analytics class) extend from
 * @author kevin
 * @date 8/21/14
 */
abstract class AnalyticsNonGeneral extends AnalyticsRoot {


    protected AnalyticsNonGeneral(String key) {
        super(key);
    }

    // TODO: Put in some sort of validation for these parameters such as date and country
    public void setAfter(String after) {
        setParameter("after", after);
    }
    public void setBefore(String before) {
        setParameter("before", before);
    }
    public void setCountry(String country) {
        setParameter("country", country);
    }
    public void setLanguage(String language) {
        setParameter("language", language);
    }
    public void setInterval(RestInterval interval) {
        setParameter("interval", interval.getStr());
    }
    public void setMediaType(RestMediaType mediatype) {
        setParameter("mediatype", mediatype.getStr());
    }
    public void setRank(String rank) {
        setParameter("rank", rank);
    }
    public void setRank(float rank) {
        setParameter("rank", String.valueOf(rank));
    }
    public void setTags(String... tags) {
        setParameter("tag", StringUtils.join(tags, ','));
    }
}
