package response_data_structures;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;

/**
 * @author kevin
 * @date 8/23/14
 */
public class ResponseDataStructureUtils {
    public static DateTime parseISO8601(String iso8601) {
        return ISODateTimeFormat.dateTimeNoMillis().parseDateTime(iso8601);
    }
}
