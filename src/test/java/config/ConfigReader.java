package config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    static Properties prop;

    static {

        try {

            prop = new Properties();

            InputStream fis =
                    ConfigReader.class.getClassLoader()
                            .getResourceAsStream("config.properties");

            prop.load(fis);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getBaseUrl() {
        return prop.getProperty("base.url");
    }
}