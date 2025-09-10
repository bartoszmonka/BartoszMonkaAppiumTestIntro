package waits;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitForElement {

    private static WebDriverWait getWebDriverWait(AndroidDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static WebElement waitUntilElementIsVisible(AndroidDriver driver, By locator) {
        WebDriverWait webDriverWait = getWebDriverWait(driver);
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
