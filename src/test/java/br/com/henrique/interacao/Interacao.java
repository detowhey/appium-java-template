package br.com.henrique.interacao;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Interacao {

    private final AppiumDriver<MobileElement> appiumDriver;

    public Interacao(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public MobileElement pesuisarElementoPorId(String id) {
        return appiumDriver.findElementById(id);
    }

    public void clicarElementoPorId(String id) {
        pesuisarElementoPorId(id).click();
    }

    public void inseirTextoElementoId(String id, String texto) {
        pesuisarElementoPorId(id).sendKeys(texto);
    }

    public void voltarPagina() {
        appiumDriver.navigate().back();
    }
}
