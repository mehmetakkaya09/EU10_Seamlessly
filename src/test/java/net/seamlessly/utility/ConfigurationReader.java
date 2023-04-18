package net.seamlessly.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();


    static {
        try {
            FileInputStream fis = new FileInputStream("configuration.properties");
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
