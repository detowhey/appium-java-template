package br.com.henrique;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


public class AppiumDriverConfiguracao {

    private final AppiumDriver<MobileElement> appiumDriver;
    private static AppiumDriverConfiguracao instancia;

    public AppiumDriver<MobileElement> getAppiumDriver() {
        return appiumDriver;
    }

    public static AppiumDriverConfiguracao getInstance(String caminhoApk, String caminhoServidorAppium) {
        if (instancia == null)
            instancia = new AppiumDriverConfiguracao(caminhoApk, caminhoServidorAppium);

        return instancia;
    }

    public AppiumDriverConfiguracao(String caminhoApk, String caminhoServidorAppium) {

        File apk = new File(caminhoApk);
        URL urlConexao = null;

        DesiredCapabilities configuracoes = new DesiredCapabilities();
        configuracoes.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        configuracoes.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        configuracoes.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
/*        configuracoes.setCapability(MobileCapabilityType.FULL_RESET, true);*/

        try {
            urlConexao = new URL(caminhoServidorAppium);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        appiumDriver = new AppiumDriver<>(Objects.requireNonNull(urlConexao), configuracoes);
        appiumDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
