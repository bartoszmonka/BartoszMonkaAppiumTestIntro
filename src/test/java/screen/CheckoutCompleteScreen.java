package screen;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.TestBase;

import static generic.assertions.AssertWebElement.assertThat;

public class CheckoutCompleteScreen extends TestBase {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/completeTV")
    private WebElement titleElement;

    @FindBy(xpath = "//*[@content-desc='Tap to open catalog']")
    private WebElement continueShoppingButton;

    public CheckoutCompleteScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkScreenTitle() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(titleElement));
        assertThat(titleElement).hasTextEqualTo("Checkout Complete", "Text should be 'Checkout Complete'");
    }

    public void tapContinueShoppingButton() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(continueShoppingButton));
        continueShoppingButton.click();
        log().info("tap button [Continue Shopping]");
    }
}
