package screen;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import tests.TestBase;

import java.time.Duration;

import static generic.assertions.AssertWebElement.assertThat;

public class MyCartScreen extends TestBase {
    private final ProductsScreen productsScreen;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement titleElement;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/titleTV")
    private WebElement productNameElement;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private WebElement productQuantityElement;

    @FindBy(xpath = "//*[@content-desc='Confirms products for checkout']")
    private WebElement proceedToCheckoutButton;

    public MyCartScreen(AndroidDriver driver, ProductsScreen productsScreen) {
        this.driver = driver;
        this.productsScreen = productsScreen;
        PageFactory.initElements(driver, this);
    }

    public void checkScreenTitle() {
        FluentWait<AndroidDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        fluentWait.until((ExpectedCondition<Boolean>) driver -> {
            try {
                return titleElement.isDisplayed() &&
                        titleElement.getText().equals("My Cart");
            } catch (Exception e) {
                return false;
            }
        });

        assertThat(titleElement).hasTextEqualTo("My Cart", "Title should 'My Cart'");
    }

    public void checkProductName() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(productNameElement));
        assertThat(productNameElement).hasTextMatching(productsScreen.getProductText(), "Text should match productText");
    }

    public void verifyProductQuantity() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(productQuantityElement));
        assertThat(productQuantityElement).hasValue("1", "Expected value '1', but found: " + productQuantityElement.getText());
    }

    public void tapButtonProceedToCheckout() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(proceedToCheckoutButton));
        proceedToCheckoutButton.click();
        log().info("tap button [Proceed To Checkout]");
    }
}
