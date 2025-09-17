package generic.assertions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;

public class AssertWebElement extends AbstractAssert<AssertWebElement, WebElement> {

    private final Logger logger = LogManager.getLogger(AssertWebElement.class);

    public AssertWebElement(WebElement webElement) {
        super(webElement, AssertWebElement.class);
    }

    public static AssertWebElement assertThat(WebElement webElement) {
        return new AssertWebElement(webElement);
    }

    public void hasTextEqualTo(String expectedTextValue, String customErrorMessage) {
        logger.info("Screen Title: {}", expectedTextValue);
        isNotNull();

        String actualElementText = actual.getText();
        if (!actualElementText.equals(expectedTextValue)) {
            failWithMessage(customErrorMessage + " - Expected: <%s>, but was: <%s>", expectedTextValue, actualElementText);
        }

        logger.info("Element text matched expected value!");
    }

    public void hasTextMatching(String otherText, String customErrorMessage) {
        logger.info("productText:{}", otherText);
        isNotNull();

        String actualElementText = actual.getText();
        if (!actualElementText.equals(otherText)) {
            failWithMessage(customErrorMessage + " - Expected: <%s>, but was: <%s>", otherText, actualElementText);
        }

        logger.info("Element text matched other text!");
    }

    public void hasValue(String expectedValue, String customErrorMessage) {
        logger.info("Checking product quantity has value: {}", expectedValue);
        isNotNull();

        String actualElementText = actual.getText();
        if (!actualElementText.equals(expectedValue)) {
            failWithMessage(customErrorMessage);
        }
        logger.info("Element had expected value!");
    }
}
