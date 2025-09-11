package screen;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProductsScreen extends TestBase {
    String productText;

    @FindBy(xpath = "//*[@content-desc='title']")
    private WebElement titleElement;

    @FindBy(xpath = "//*[@text='Sauce Labs Backpack']")
    private WebElement firstProductNameElement;

    @FindBy(xpath = "//*[@resource-id='com.saucelabs.mydemoapp.android:id/productIV'][1]")
    private WebElement firstProductImageElement;

    public ProductsScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkScreenTitle() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(titleElement));
        String screenTitle = titleElement.getText();
        assertEquals("Products", screenTitle, "Title should 'Products'");
        log().info("Screen Title: {}", screenTitle);
    }

    public void getFirstProductName() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(firstProductNameElement));
        productText = firstProductNameElement.getText();
        log().info("get First Product Name: {}", productText);
    }

    public void tapOnProduct() {
        getFirstProductName();
        getWebDriverWait().until(ExpectedConditions.visibilityOf(firstProductImageElement));
        firstProductImageElement.click();
        log().info("tap on product: {}", productText);
    }

    public String getProductText() {
        return productText;
    }
}
