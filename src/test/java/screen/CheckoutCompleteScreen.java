package screen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static generic.assertions.AssertWebElement.assertThat;

public class CheckoutCompleteScreen extends BaseScreen {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/completeTV")
    private WebElement titleElement;

    @FindBy(xpath = "//*[@content-desc='Tap to open catalog']")
    private WebElement continueShoppingButton;


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
