package screen;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.TestBase;

import java.util.List;

public class LoginScreen extends TestBase {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/loginTV")
    private List<WebElement> loginElements;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/username1TV")
    private WebElement usernameButton;

    @FindBy(xpath = "//*[@content-desc='Tap to login with given credentials']")
    private WebElement loginButton;

    public LoginScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void authenticateUserWhenRequired() {
        List<WebElement> elements = driver.findElements(AppiumBy.id("com.saucelabs.mydemoapp.android:id/loginTV"));

        if (!elements.isEmpty()) {
            WebElement el187 = elements.get(0);
            String loginText = el187.getText();

            if (loginText.equals("Login")) {
                log().info("Login screen appeared - performing login");

                getWebDriverWait().until(ExpectedConditions.visibilityOf(usernameButton));
                usernameButton.click();
                getWebDriverWait().until(ExpectedConditions.visibilityOf(loginButton));
                loginButton.click();
            }
        } else {
            log().info("No login screen - continuing test normally");
        }
    }
}
