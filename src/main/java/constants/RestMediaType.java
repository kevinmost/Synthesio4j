package constants;

/**
 * @author kevin
 * @date 8/21/14
 */
public enum RestMediaType {
    BLOG("blog"),
    COMMUNITY("community"),
    FORUM("forum"),
    HOSTED_COMMUNITY("hosted-community"),
    MAINSTREAM("mainstream"),
    MICRO_BLOGGING("micro-blogging"),
    SOCIAL("social");

    private String str;
    RestMediaType(String str) {
        this.str = str;
    }
    public String getStr() {
        return str;
    }
}
