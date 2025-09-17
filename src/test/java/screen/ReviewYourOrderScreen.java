package screen;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.TestBase;

import static generic.assertions.AssertWebElement.assertThat;

public class ReviewYourOrderScreen extends TestBase {

    private final ProductsScreen productsScreen;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/enterShippingAddressTV")
    private WebElement titleElement;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/titleTV")
    private WebElement productNameElement;

    @FindBy(xpath = "//*[@content-desc='Completes the process of checkout']")
    private WebElement placeOrderButton;

    public ReviewYourOrderScreen(AndroidDriver driver, ProductsScreen productsScreen) {
        this.driver = driver;
        this.productsScreen = productsScreen;
        PageFactory.initElements(driver, this);
    }

    public void checkScreenTitle() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(titleElement));
        assertThat(titleElement).hasTextEqualTo("Review your order", "Text should be 'Review your order'");
    }

    public void verifyProductName() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(productNameElement));
        assertThat(productNameElement).hasTextMatching(productsScreen.getProductText(), "Text in el26 should match productText");
    }

    public void tapPlaceOrderButton() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(placeOrderButton));
        placeOrderButton.click();
        log().info("tap button [Place Order]");
    }
}
