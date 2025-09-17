package screen;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.TestBase;

import static generic.assertions.AssertWebElement.assertThat;

public class EnterPaymentMethodScreen extends TestBase {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/enterPaymentMethodTV")
    private WebElement titleElement;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
    private WebElement nameField;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/cardNumberET")
    private WebElement cardNumberField;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/expirationDateET")
    private WebElement expirationDateField;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/securityCodeET")
    private WebElement securityCodeField;

    @FindBy(xpath = "//*[@content-desc='Saves payment info and launches screen to review checkout data']")
    private WebElement reviewOrderButton;

    public EnterPaymentMethodScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkScreenTitle() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(titleElement));
        assertThat(titleElement).hasTextEqualTo("Enter a payment method", "Text should be 'Enter a payment method'");
    }

    public void fillName() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(nameField));
        nameField.sendKeys("John Tester");
        log().info("Filled in name: John Tester");
    }

    public void fillCardNumber() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(cardNumberField));
        cardNumberField.sendKeys("4111 1111 1111 1111");
        log().info("Filled in card number: 4111 1111 1111 1111");
    }

    public void fillExpirationDate() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(expirationDateField));
        expirationDateField.sendKeys("0928");
        log().info("Filled in expiration date: 0928");
    }

    public void fillSecurityCode() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(securityCodeField));
        securityCodeField.sendKeys("123");
        log().info("Filled in security code: 123");
    }

    public void fillPaymentMethod() {
        fillName();
        fillCardNumber();
        fillExpirationDate();
        fillSecurityCode();
    }

    public void tapReviewOrderButton() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(reviewOrderButton));
        reviewOrderButton.click();
        log().info("tap button [Review Order]");
    }
}
