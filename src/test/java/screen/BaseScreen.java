package screen;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseScreen {

    private final Logger logger = LogManager.getLogger(this.getClass().getName());

    public BaseScreen() {
        PageFactory.initElements(DriverManager.getAndroidDriver(), this);
    }

    protected Logger log() {
        return logger;
    }

    protected WebDriverWait getWebDriverWait() {
        return new WebDriverWait(DriverManager.getAndroidDriver(), Duration.ofSeconds(20));
    }
}
