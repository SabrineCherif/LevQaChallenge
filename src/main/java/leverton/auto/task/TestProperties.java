package leverton.auto.task;

import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    private static TestProperties INSTANCE;
    private static final String LOGIN_PAGE_KEY = "page.login";
    private static final String COUNTRIES_REST_URL = "rest.countries";
    private static final String PROPERTIES_FILE_NAME = "/test.properties";

    private final Properties properties;

    private TestProperties() throws IOException {
        Properties properties = new Properties();
        properties.load(this.getClass().getResourceAsStream(PROPERTIES_FILE_NAME));
        this.properties = new Properties(properties);
    }

    private static synchronized TestProperties getINSTANCE() {
        if (INSTANCE == null) {
            try {
                INSTANCE = new TestProperties();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return INSTANCE;
    }

    public static String getLoginPageUrl() {
        return getINSTANCE().properties.getProperty(LOGIN_PAGE_KEY);
    }
    public static String getCountriesRestUrl() {
        return getINSTANCE().properties.getProperty(COUNTRIES_REST_URL);
    }


}
