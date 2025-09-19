package tests;

import driver.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class TestBase {

    private final Logger logger = LogManager.getLogger(this.getClass().getName());
    public AndroidDriver driver;

    protected Logger log() {
        return logger;
    }

    protected WebDriverWait getWebDriverWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @BeforeEach
    public void setUp() {
        log().info("android tests setup");

        var options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UIAutomator2")
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .setNewCommandTimeout(Duration.ofSeconds(3600))
                .amend("appium:connectHardwareKeyboard", true);

        try {
            URL url = URI.create("http://127.0.0.1:4723").toURL();
            driver = new AndroidDriver(url, options);
            DriverManager.setAndroidDriver(driver);
            log().info("AndroidDriver has been initialization");
        } catch (Exception e) {
            log().error("error during AndroidDriver initialization: {}", e.getMessage(), e);
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize AndroidDriver. Please ensure Appium server is running on http://127.0.0.1:4723", e);
        }
    }

    @AfterEach
    public void tearDown() {
        DriverManager.disposeDriver();
    }
}
