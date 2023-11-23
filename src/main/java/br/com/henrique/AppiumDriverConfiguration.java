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


public class AppiumDriverConfiguration {

    private final AppiumDriver<MobileElement> appiumDriver;
    private static AppiumDriverConfiguration instance;

    public AppiumDriver<MobileElement> getAppiumDriver() {
        return appiumDriver;
    }

    public static AppiumDriverConfiguration getInstance(String pathApk, String pathAppiumServer) {
        if (instance == null)
            instance = new AppiumDriverConfiguration(pathApk, pathAppiumServer);

        return instance;
    }

    public AppiumDriverConfiguration(String pathApk, String pathAppiumServer) {
        File apk = new File(pathApk);
        URL urlConnection = null;

        DesiredCapabilities confiurations = new DesiredCapabilities();
        confiurations.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        confiurations.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        confiurations.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

        try {
            urlConnection = new URL(pathAppiumServer);
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }

        appiumDriver = new AppiumDriver<>(Objects.requireNonNull(urlConnection), confiurations);
    }
}
