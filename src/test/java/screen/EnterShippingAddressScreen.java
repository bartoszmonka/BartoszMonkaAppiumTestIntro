package screen;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static generic.assertions.AssertWebElement.assertThat;

public class EnterShippingAddressScreen extends BaseScreen {

    private static final Dotenv dotenv = Dotenv.configure().filename(".env.test").load();

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/enterShippingAddressTV")
    private WebElement titleElement;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/fullNameET")
    private WebElement fullNameField;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/address1ET")
    private WebElement addressField;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/cityET")
    private WebElement cityField;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/stateET")
    private WebElement stateField;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/zipET")
    private WebElement zipCodeField;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/countryET")
    private WebElement countryField;

    @FindBy(xpath = "//*[@content-desc='Saves user info for checkout']")
    private WebElement toPaymentButton;


    public void checkScreenTitle() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(titleElement));
        assertThat(titleElement).hasTextEqualTo("Enter a shipping address", "Text should be 'Enter a shipping address'");
    }

    public void fillName() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(fullNameField));
        fullNameField.sendKeys(dotenv.get("SHIPPING_FULL_NAME"));
        log().info("Filled in name: {}", dotenv.get("SHIPPING_FULL_NAME"));
    }

    public void fillAddress() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(addressField));
        addressField.sendKeys(dotenv.get("SHIPPING_ADDRESS"));
        log().info("Filled in address 1: {}", dotenv.get("SHIPPING_ADDRESS"));
    }

    public void fillCity() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(cityField));
        cityField.sendKeys(dotenv.get("SHIPPING_CITY"));
        log().info("Filled in city: {}", dotenv.get("SHIPPING_CITY"));
    }

    public void fillState() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(stateField));
        stateField.sendKeys(dotenv.get("SHIPPING_STATE"));
        log().info("Filled in state: {}", dotenv.get("SHIPPING_STATE"));
    }

    public void fillZipCode() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(zipCodeField));
        zipCodeField.sendKeys(dotenv.get("SHIPPING_ZIP_CODE"));
        log().info("Filled in zip code: {}", dotenv.get("SHIPPING_ZIP_CODE"));
    }

    public void fillCountry() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(countryField));
        countryField.sendKeys(dotenv.get("SHIPPING_COUNTRY"));
        log().info("Filled in country: {}", dotenv.get("SHIPPING_COUNTRY"));
    }

    public void fillShippingAddress() {
        fillName();
        fillAddress();
        fillCity();
        fillState();
        fillZipCode();
        fillCountry();
    }

    public void tapToPaymentButton() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(toPaymentButton));
        toPaymentButton.click();
        log().info("tap button [To Payment]");
    }
}
