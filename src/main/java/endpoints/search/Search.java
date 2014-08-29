package endpoints.search;

import api.SynthesioApiCall;
import constants.RestMediaType;
import responses.search.SearchResponse;

import java.io.IOException;

/**
 * @author kevin
 * @date 8/29/14
 */
public class Search extends SynthesioApiCall {

    public Search(String key) {
        super(key);
    }

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
    public void setLimit(int limit) {
        setParameter("limit", String.valueOf(limit));
    }
    public void setLimit(String limit) {
        setParameter("limit", limit);
    }
    public void setMediaType(RestMediaType mediatype) {
        setParameter("mediatype", mediatype.getStr());
    }
    public void setOffset(int offset) {
        setParameter("offset", String.valueOf(offset));
    }
    public void setOffset(String offset) {
        setParameter("offset", offset);
    }
    public void setQuery(String query) {
        setParameter("query", query);
    }
    public void setStrict(boolean strict) {
        setParameter("strict", strict?"1":"0");
    }


    @Override
    protected String getBaseApiString() {
        return "https://api.synthesio.com/search";
    }

    @SuppressWarnings("unchecked")
    @Override
    public SearchResponse executeApiCall() throws IOException {
        return super.makeCall(SearchResponse.class);
    }
}
