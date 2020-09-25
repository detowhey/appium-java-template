package br.com.henrique.teste;

import br.com.henrique.AppiumDriverConfiguracao;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class CadastroTeste {

    private static AppiumDriver<MobileElement> appiumDriver;

    @Before
    public void iniciarAppiumDriver() {
        appiumDriver = AppiumDriverConfiguracao.getInstance("src/main/resources/alura_esporte.apk",
                "http://localhost:4723/wd/hub").getAppiumDriver();
        appiumDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void fecharAplicativo() {
        appiumDriver.closeApp();
        appiumDriver.quit();
    }

    @Test
    public void impedirCadastroUsuarioSenhasDiferentes() {
        MobileElement botaoCadastro = appiumDriver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastro.click();

        MobileElement inputNome = appiumDriver.findElementById("br.com.alura.aluraesporte:id/input_nome");
        inputNome.sendKeys("Henrique");

        MobileElement inputSenha = appiumDriver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        inputSenha.sendKeys("senha");

        MobileElement inputConfirmarSenha = appiumDriver.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
        inputConfirmarSenha.sendKeys("se");

        MobileElement botaoCadastrarNovoUsuario = appiumDriver
                .findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
        botaoCadastrarNovoUsuario.click();

        MobileElement erroSenhas = appiumDriver.findElementById("br.com.alura.aluraesporte:id/erro_cadastro");

        assertEquals("Senhas não conferem", erroSenhas.getText());
        appiumDriver.navigate().back();
    }

    @Test
    public void cadastrarUsuario() {
        MobileElement botaoCadastro = appiumDriver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastro.click();


        MobileElement inputNome = appiumDriver.findElementById("br.com.alura.aluraesporte:id/input_nome");
        inputNome.sendKeys("Henrique");

        MobileElement inputSenha = appiumDriver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        inputSenha.sendKeys("senha");

        MobileElement inputConfirmarSenha = appiumDriver.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
        inputConfirmarSenha.sendKeys("senha");

        MobileElement botaoCadastrarNovoUsuario = appiumDriver
                .findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
        botaoCadastrarNovoUsuario.click();
    }
}
