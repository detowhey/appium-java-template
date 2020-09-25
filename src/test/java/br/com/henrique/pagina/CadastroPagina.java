package br.com.henrique.pagina;

import br.com.henrique.interacao.Interacao;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CadastroPagina {

    private final Interacao interacao;

    public CadastroPagina(AppiumDriver<MobileElement> appiumDriver) {
        this.interacao = new Interacao(appiumDriver);
    }

    public void voltarPagina() {
        interacao.voltarPagina();
    }

    public void inserirTextoNome(String texto) {
        interacao.inseirTextoElementoId("br.com.alura.aluraesporte:id/input_nome", texto);
    }

    public void inseirTextoSenha(String texto) {
        interacao.inseirTextoElementoId("r.com.alura.aluraesporte:id/input_senha", texto);
    }

    public void inserirTextoConfirmarSenha(String texto) {
        interacao.inseirTextoElementoId("br.com.alura.aluraesporte:id/input_confirmar_senha", texto);
    }

    public void clicarBotaoCadastrar(String texto) {
        interacao.inseirTextoElementoId("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar", texto);
    }

    public String retornarValorTextoAviso() {
        MobileElement elemento = interacao.pesuisarElementoPorId("br.com.alura.aluraesporte:id/erro_cadastro");
        String textoElemento = "";


        if (elemento.isDisplayed() && !elemento.getText().isBlank())
            textoElemento = elemento.getText();

        return textoElemento;
//        return interacao.retornarTextoElementoId("br.com.alura.aluraesporte:id/erro_cadastro");


    }
}
