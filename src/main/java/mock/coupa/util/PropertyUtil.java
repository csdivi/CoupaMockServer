package mock.coupa.util;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Properties;

@Slf4j
public class PropertyUtil {
    private static Properties PROPERTIES = new Properties();
    static {
        try {
            PROPERTIES.load(PropertyUtil.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
