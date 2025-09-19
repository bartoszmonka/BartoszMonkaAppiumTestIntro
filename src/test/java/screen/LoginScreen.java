package screen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LoginScreen extends BaseScreen {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/loginTV")
    private List<WebElement> loginElements;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/username1TV")
    private WebElement usernameButton;

    @FindBy(xpath = "//*[@content-desc='Tap to login with given credentials']")
    private WebElement loginButton;


    public void authenticateUserWhenRequired() {
        if (!loginElements.isEmpty()) {
            WebElement login = loginElements.getFirst();
            String loginText = login.getText();

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
