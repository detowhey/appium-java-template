package br.com.henrique.test;

import br.com.henrique.AppiumDriverConfiguration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.AfterClass;
import org.junit.Before;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    private static AppiumDriver<MobileElement> appiumDriver;

    protected static AppiumDriver<MobileElement> getAppiumDriver() {
        return appiumDriver;
    }

    @Before
    public void appiumDriverConfiguration() {
        appiumDriver = AppiumDriverConfiguration.getInstance("src/main/resources/alura_esporte.apk",
                "http://localhost:4723/wd/hub").getAppiumDriver();
        appiumDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void quitApp() {
        appiumDriver.closeApp();
        appiumDriver.quit();
    }
}
