package br.com.henrique.teste;

import br.com.henrique.AppiumDriverConfiguracao;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.AfterClass;
import org.junit.Before;

import java.util.concurrent.TimeUnit;

public abstract class BaseTeste {

    private static AppiumDriver<MobileElement> appiumDriver;

    protected static AppiumDriver<MobileElement> getAppiumDriver() {
        return appiumDriver;
    }

    @Before
    public void configurarAppiumDriver() {
        appiumDriver = AppiumDriverConfiguracao.getInstance("src/main/resources/alura_esporte.apk",
                "http://localhost:4723/wd/hub").getAppiumDriver();
        appiumDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void fecharAplicativo() {
        appiumDriver.closeApp();
        appiumDriver.quit();
    }
}
