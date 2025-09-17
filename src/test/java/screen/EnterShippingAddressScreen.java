package screen;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.TestBase;

import static generic.assertions.AssertWebElement.assertThat;

public class EnterShippingAddressScreen extends TestBase {

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

    public EnterShippingAddressScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkScreenTitle() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(titleElement));
        assertThat(titleElement).hasTextEqualTo("Enter a shipping address", "Text should be 'Enter a shipping address'");
    }

    public void fillName() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(fullNameField));
        fullNameField.sendKeys("TestName TestSurname");
        log().info("Filled in name: TestName TestSurname");
    }

    public void fillAddress() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(addressField));
        addressField.sendKeys("Test 123");
        log().info("Filled in address 1: Test 123");
    }

    public void fillCity() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(cityField));
        cityField.sendKeys("TestCity");
        log().info("Filled in city: TestCity");
    }

    public void fillState() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(stateField));
        stateField.sendKeys("TestState");
        log().info("Filled in state: TestState");
    }

    public void fillZipCode() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(zipCodeField));
        zipCodeField.sendKeys("342123");
        log().info("Filled in zip code: 342123");
    }

    public void fillCountry() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(countryField));
        countryField.sendKeys("Poland");
        log().info("Filled in country: Poland");
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
