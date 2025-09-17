package screen;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.TestBase;

import static generic.assertions.AssertWebElement.assertThat;

public class ProductDetailsScreen extends TestBase {
    private final ProductsScreen productsScreen;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement productNameHeader;

    @FindBy(xpath = "//*[@content-desc='Tap to add product to cart']")
    private WebElement addToCartButton;

    public ProductDetailsScreen(AndroidDriver driver, ProductsScreen productsScreen) {
        this.driver = driver;
        this.productsScreen = productsScreen;
        PageFactory.initElements(driver, this);
    }

    public void checkProductNameInHeader() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(productNameHeader));
        String productText = productsScreen.getProductText();
        assertThat(productNameHeader).hasTextMatching(productText, "Product text should match header");
    }

    public void tapButtonAddToCart() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(addToCartButton));
        addToCartButton.click();
        log().info("tap button [Add to cart]");
    }
}
