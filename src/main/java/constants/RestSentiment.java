package constants;

/**
 * @author kevin
 * @date 8/28/14
 */
public enum RestSentiment {
    AMBIVALENT("ambivalent"),
    POSITIVE("positive"),
    NEGATIVE("negative"),
    NEUTRAL("neutral"),
    UNASSIGNED("unassigned");

    private String str;
    private RestSentiment(String str) {
        this.str = str;
    }
    public String getStr() {
        return str;
    }
}
