package br.com.henrique.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class RegisterPage extends BasePage {

    public RegisterPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public void insertName(String text) {
        getInteraction().insertTextInElementById("br.com.alura.aluraesporte:id/input_nome", text);
    }

    public void insertPassword(String text) {
        getInteraction().insertTextInElementById("br.com.alura.aluraesporte:id/input_senha", text);
    }

    public void insertConfirmPassword(String text) {
        getInteraction().insertTextInElementById("br.com.alura.aluraesporte:id/input_confirmar_senha", text);
    }

    public void clickButtonRegister() {
        getInteraction().clickElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
    }

    public String getTextValueNotice() {
        MobileElement mobileElement = getInteraction().searchElementById("br.com.alura.aluraesporte:id/erro_cadastro");
        String elementText = "";

        if (mobileElement.isDisplayed())
            elementText = mobileElement.getText();

        return elementText;
    }
}
