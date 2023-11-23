package br.com.henrique.interaction;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Interaction {

    private final AppiumDriver<MobileElement> appiumDriver;

    public Interaction(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public MobileElement searchElementById(String id) {
        return appiumDriver.findElementById(id);
    }

    public void clickElementById(String id) {
        searchElementById(id).click();
    }

    public void insertTextInElementById(String id, String text) {
        searchElementById(id).sendKeys(text);
    }

    public void back() {
        appiumDriver.navigate().back();
    }
}
