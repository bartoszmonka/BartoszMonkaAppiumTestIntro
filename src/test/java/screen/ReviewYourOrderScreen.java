package screen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static generic.assertions.AssertWebElement.assertThat;

public class ReviewYourOrderScreen extends BaseScreen {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/enterShippingAddressTV")
    private WebElement titleElement;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/titleTV")
    private WebElement productNameElement;

    @FindBy(xpath = "//*[@content-desc='Completes the process of checkout']")
    private WebElement placeOrderButton;

    public void checkScreenTitle() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(titleElement));
        assertThat(titleElement).hasTextEqualTo("Review your order", "Text should be 'Review your order'");
    }

    public void verifyProductName(String expectedProductName) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(productNameElement));
        assertThat(productNameElement).hasTextMatching(expectedProductName, "Text should match productText");
    }

    public void tapPlaceOrderButton() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(placeOrderButton));
        placeOrderButton.click();
        log().info("tap button [Place Order]");
    }
}
