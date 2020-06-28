package hbv.com.ua.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesUtil {
    private static PropertiesUtil instance;
    private Properties properties;

    private final String PROPERTIES_NAME = "application.properties";

    private PropertiesUtil() {
    }

    public static PropertiesUtil getInstance() {
        if (instance == null) {
            instance = new PropertiesUtil();
        }
        return instance;
    }

    private void init() {
        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(PROPERTIES_NAME)) {
            if (inputStream != null) {
                this.properties = new Properties();
                this.properties.load(inputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getProperty(final String key) {
        return this.properties.getProperty(key);
    }

    public String getProperty(final String key, final String defaultValue) {
        return this.properties.getProperty(key);
    }

}
