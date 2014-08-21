package constants;

/**
 * @author kevin
 * @date 8/21/14
 */
public enum RestResponseFormat {
    JSON("json"),
    XML("xml");

    String str;

    RestResponseFormat(String str) {
        this.str = str;
    }

    public String getStr() {return str;}
}
