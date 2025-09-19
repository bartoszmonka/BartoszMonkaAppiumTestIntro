package screen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static generic.assertions.AssertWebElement.assertThat;

public class ProductDetailsScreen extends BaseScreen {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement productNameHeader;

    @FindBy(xpath = "//*[@content-desc='Tap to add product to cart']")
    private WebElement addToCartButton;

    public void checkProductNameInHeader(String expectedProductName) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(productNameHeader));
        assertThat(productNameHeader).hasTextMatching(expectedProductName, "Product text should match header");
    }

    public void tapButtonAddToCart() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(addToCartButton));
        addToCartButton.click();
        log().info("tap button [Add to cart]");
    }
}
