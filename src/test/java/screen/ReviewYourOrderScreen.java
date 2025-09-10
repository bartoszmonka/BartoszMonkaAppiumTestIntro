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
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    private WebDriverWait getWebDriverWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void checkScreenTitle() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(titleElement));
        String reviewText = titleElement.getText();
        assertEquals("Review your order", reviewText, "Text should be 'Review your order'");
        log().info("Screen Title: {}", reviewText);
    }

    public void verifyProductName() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(productNameElement));
        String productName = productNameElement.getText();
        assertEquals(productName, productsScreen.getProductText(), "Text in el26 should match productText");
        log().info("Product name verified: {}", productName);
    }

    public void assertProductNameIsDisplayed() {
        log().info("Checking product name is displayed");
        getWebDriverWait().until(ExpectedConditions.visibilityOf(productNameElement));
        assertTrue(productNameElement.isDisplayed(), "Product name element should be displayed");
    }

    public void tapPlaceOrderButton() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(placeOrderButton));
        placeOrderButton.click();
        log().info("tap button [Place Order]");
    }
}
