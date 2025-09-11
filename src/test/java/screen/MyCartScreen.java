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

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        fluentWait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return titleElement.isDisplayed() &&
                            titleElement.getText().equals("My Cart");
                } catch (Exception e) {
                    return false;
                }
            }
        });

        String titleCard = titleElement.getText();
        assertEquals("My Cart", titleCard, "Title should 'My Cart'");
        log().info("Screen Title: {}", titleCard);
    }

    public void checkProductName() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(productNameElement));
        String titleText = productNameElement.getText();
        assertEquals(productsScreen.getProductText(), titleText, "Text in el7 should match productText");
        log().info("Product name: {}", titleText);
    }

    public void verifyProductQuantity() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(productQuantityElement));
        String valueText = productQuantityElement.getText();
        assertEquals("1", valueText, "Expected value '1', but found: " + valueText);
        log().info("Product Quantity: {}", valueText);
    }

    public void tapButtonProceedToCheckout() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(proceedToCheckoutButton));
        proceedToCheckoutButton.click();
        log().info("tap button [Proceed To Checkout]");
    }
}
