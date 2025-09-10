package screen;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.TestBase;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutCompleteScreen extends TestBase {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/completeTV")
    private WebElement titleElement;

    @FindBy(xpath = "//*[@content-desc='Tap to open catalog']")
    private WebElement continueShoppingButton;

    public CheckoutCompleteScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private WebDriverWait getWebDriverWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void checkScreenTitle() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(titleElement));
        String completeText = titleElement.getText();
        assertEquals("Checkout Complete", completeText, "Text should be 'Checkout Complete'");
        log().info("Screen Title: {}", completeText);
    }

    public void tapContinueShoppingButton() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(continueShoppingButton));
        continueShoppingButton.click();
        log().info("tap button [Continue Shopping]");
    }
}
