package constants;

/**
 * @author kevin
 * @date 8/21/14
 */
public enum RestInterval {
    DAY("day"),
    HOUR("hour");

    private String str;
    RestInterval(String str) {
        this.str = str;
    }
    public String getStr() {
        return str;
    }
}
