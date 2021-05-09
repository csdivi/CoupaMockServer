package mock.coupa.util;

import mock.coupa.requisition.Id;
import mock.coupa.requisition.TimeStamp;

import java.util.Date;

public class DataUtil {
    public static Id id(int value) {
        return Id.builder()
            .value(value)
            .build();
    }

    public static TimeStamp timestamp() {
        return TimeStamp.builder()
            .date(new Date())
            .build();
    }
}
