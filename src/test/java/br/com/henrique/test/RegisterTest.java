package br.com.henrique.test;

import br.com.henrique.page.RegisterPage;
import br.com.henrique.page.LoginPage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegisterTest extends BaseTest {

    private RegisterPage registerPage;
    private LoginPage loginPage;

    @Before
    public void instancePageObjects() {
        registerPage = new RegisterPage(getAppiumDriver());
        loginPage = new LoginPage(getAppiumDriver());
    }

    @Test
    public void preventRegistrationUserDifferentPasswords() {
        loginPage.clickButtonRegisterNewUser();
        registerPage.insertName("Henrique");
        registerPage.insertPassword("senha");
        registerPage.insertConfirmPassword("se");
        registerPage.clickButtonRegister();

        assertEquals("Senhas não conferem", registerPage.getTextValueNotice());
        registerPage.back();
    }

    @Test
    public void registerNewUser() {
        loginPage.clickButtonRegisterNewUser();
        registerPage.insertName("Henrique");
        registerPage.insertPassword("senha");
        registerPage.insertConfirmPassword("senha");
        registerPage.clickButtonRegister();
        registerPage.back();
    }
}
