package analytics;

import constants.RestInterval;
import constants.RestMediaType;
import org.apache.commons.lang3.StringUtils;

/**
 * @author kevin
 * @date 8/21/14
 */
public class AnalyticsInfluence extends Analytics {

    public AnalyticsInfluence(String key) {
        super(key);
    }

    @Override
    protected String getBaseApiString() {
        return "https://api.synthesio.com/analytics/" + reportId + "/influence";
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
