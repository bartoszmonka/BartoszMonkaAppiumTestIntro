package screen;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.TestBase;

import java.time.Duration;

public class HeaderVidget extends TestBase {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/cartIV")
    private WebElement cartButton;

    public HeaderVidget(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private WebDriverWait getWebDriverWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void tapOnCart() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(cartButton));
        cartButton.click();
        log().info("tap on cart");
    }
}
