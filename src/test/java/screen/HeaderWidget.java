package screen;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.TestBase;

public class HeaderWidget extends TestBase {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/cartIV")
    private WebElement cartButton;

    @FindBy(xpath = "//*[@content-desc='View menu']")
    private WebElement viewMenuElement;

    @FindBy(xpath = "//*[@text='Catalog']")
    private WebElement catalogElement;

    public HeaderWidget(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void tapOnCart() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(cartButton));
        cartButton.click();
        log().info("tap on cart");
    }

    public void clickOnViewMenu() {
        viewMenuElement.click();
        log().info("Clicked on View menu");
    }

    public void clickOnCatalog() {
        catalogElement.click();
        log().info("Clicked on Catalog - navigation reset completed");
    }

    public void resetNavigationToCatalog() {
        try {
            log().info("Resetting navigation to catalog view before retry");
            clickOnViewMenu();
            clickOnCatalog();
        } catch (Exception e) {
            log().warn("Failed to reset navigation to catalog: {}", e.getMessage());
        }
    }
}
