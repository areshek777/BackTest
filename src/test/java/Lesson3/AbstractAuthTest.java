package Lesson3;

import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class AbstractAuthTest {
    static Properties prop = new Properties();
    private static InputStream configureFile;
    private static String apiKey;
    private static String baseURL;

    @BeforeAll
    static void initTest() throws IOException {
        configureFile = new FileInputStream("src/main/resources/my.properties");
        prop.load(configureFile);
        apiKey = prop.getProperty("apiKey");
        baseURL = prop.getProperty("baseURL");
    }

    public static String getApiKey() {
        return apiKey;
    }

    public static String getBaseURL() {
        return baseURL;

    }
}
