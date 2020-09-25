package br.com.henrique.pagina;

import br.com.henrique.interacao.Interacao;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public abstract class BasePagina {

    private final Interacao interacao;

    public BasePagina(AppiumDriver<MobileElement> appiumDriver) {
        this.interacao = new Interacao(appiumDriver);
    }

    protected Interacao getInteracao() {
        return interacao;
    }

    public void voltarPagina() {
        interacao.voltarPagina();
    }
}
