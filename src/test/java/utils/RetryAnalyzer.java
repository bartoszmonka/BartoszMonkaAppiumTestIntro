package utils;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;
import screen.HeaderVidget;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class RetryAnalyzer implements InvocationInterceptor {

    private static final int MAX_NUMBER_OF_RETRIES = 2;
    private static final Logger logger = LogManager.getLogger(RetryAnalyzer.class);

    private AndroidDriver getDriverFromTestInstance(Object testInstance) {
        try {
            Field driverField = testInstance.getClass().getSuperclass().getDeclaredField("driver");
            driverField.setAccessible(true);
            return (AndroidDriver) driverField.get(testInstance);
        } catch (Exception e) {
            logger.warn("Failed to get driver from test instance: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public void interceptTestMethod(Invocation<Void> invocation, 
                                   ReflectiveInvocationContext<Method> invocationContext, 
                                   ExtensionContext extensionContext) throws Throwable {

        String testName = extensionContext.getDisplayName();
        Object testInstance = invocationContext.getTarget().orElse(null);

        Throwable lastException = null;

        for (int attempt = 1; attempt <= MAX_NUMBER_OF_RETRIES + 1; attempt++) {
            try {
                if (attempt > 1 && testInstance != null) {
                    AndroidDriver driver = getDriverFromTestInstance(testInstance);
                    if (driver != null) {
                        HeaderVidget headerVidget = new HeaderVidget();
                        headerVidget.resetNavigationToCatalog();
                    }
                }

                if (attempt == 1) {
                    invocation.proceed();
                } else {
                    Method testMethod = invocationContext.getExecutable();
                    testMethod.invoke(testInstance);
                }

                if (attempt > 1) {
                    logger.info("Test method {} succeeded on attempt {}", testName, attempt);
                }
                return;
            } catch (Throwable throwable) {
                lastException = throwable;
                if (attempt <= MAX_NUMBER_OF_RETRIES) {
                    logger.info("Retrying test method {} (attempt {}/{})", testName, attempt + 1, MAX_NUMBER_OF_RETRIES + 1);
                } else {
                    logger.info("Test method {} will not be retried! Maximum retries ({}) exceeded.", testName, MAX_NUMBER_OF_RETRIES);
                }
            }
        }
        throw lastException;
    }
}
