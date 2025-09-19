package driver;

import io.appium.java_client.android.AndroidDriver;

public class DriverManager {

    private static final ThreadLocal<AndroidDriver> androidDriverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static void setAndroidDriver(AndroidDriver driver) {
        androidDriverThreadLocal.set(driver);
    }

    public static AndroidDriver getAndroidDriver() {
        if (androidDriverThreadLocal.get() == null) {
            throw new IllegalStateException("AndroidDriver Instance was null! Please create instance of AndroidDriver using setAndroidDriver!");
        }
        return androidDriverThreadLocal.get();
    }

    public static void disposeDriver() {
        AndroidDriver driver = androidDriverThreadLocal.get();
        if (driver != null) {
            driver.quit();
        }
        androidDriverThreadLocal.remove();
    }
}