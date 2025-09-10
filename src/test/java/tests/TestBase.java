package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.net.URL;

public class TestBase {

    public AndroidDriver driver;
    private final Logger logger = LogManager.getLogger(this.getClass().getName());

    protected Logger log() {
        return logger;
    }

    @BeforeEach
    public void setUp() {
        log().info("android tests setup");

        var options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("appium:automationName", "UIAutomator2")
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:newCommandTimeout", 3600)
                .amend("appium:connectHardwareKeyboard", true);

        try {
            URL url = new URL("http://127.0.0.1:4723");
            driver = new AndroidDriver(url, options);
            log().info("AndroidDriver has been initialization");
        } catch (Exception e) {
            log().error("error during AndroidDriver initialization: {}", e.getMessage(), e);
            e.printStackTrace();
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}