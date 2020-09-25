package br.com.henrique.pagina;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginPagina extends BasePagina {

    public LoginPagina(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public void clicarBotaoCadastrarNovoUsuario() {
        getInteracao().clicarElementoPorId("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
    }
}
