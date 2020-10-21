package br.com.henrique;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AutomationName;
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
        configuracoes.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

        try {
            urlConexao = new URL(caminhoServidorAppium);
        } catch (MalformedURLException excecao) {
            excecao.printStackTrace();
        }

        appiumDriver = new AppiumDriver<>(Objects.requireNonNull(urlConexao), configuracoes);
    }
}
