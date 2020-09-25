package br.com.henrique.pagina;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CadastroPagina extends BasePagina {

    public CadastroPagina(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public void inserirTextoNome(String texto) {
        getInteracao().inseirTextoElementoId("br.com.alura.aluraesporte:id/input_nome", texto);
    }

    public void inseirTextoSenha(String texto) {
        getInteracao().inseirTextoElementoId("r.com.alura.aluraesporte:id/input_senha", texto);
    }

    public void inserirTextoConfirmarSenha(String texto) {
        getInteracao().inseirTextoElementoId("br.com.alura.aluraesporte:id/input_confirmar_senha", texto);
    }

    public void clicarBotaoCadastrar() {
        getInteracao().clicarElementoPorId("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
    }

    public String retornarValorTextoAviso() {
        MobileElement elemento = getInteracao().pesuisarElementoPorId("br.com.alura.aluraesporte:id/erro_cadastro");
        String textoElemento = "";

        if (elemento.isDisplayed())
            textoElemento = elemento.getText();

        return textoElemento;
    }
}
