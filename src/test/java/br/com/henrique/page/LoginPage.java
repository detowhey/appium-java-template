package br.com.henrique.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginPage extends BasePage {

    public LoginPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public void clickButtonRegisterNewUser() {
        getInteraction().clickElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
    }
}
