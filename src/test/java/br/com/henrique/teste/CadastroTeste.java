package br.com.henrique.teste;

import br.com.henrique.pagina.CadastroPagina;
import br.com.henrique.pagina.LoginPagina;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CadastroTeste extends BaseTeste {

    private CadastroPagina cadastroPagina;
    private LoginPagina loginPagina;


    @Before
    public void iniciarObjetos() {
        cadastroPagina = new CadastroPagina(getAppiumDriver());
        loginPagina = new LoginPagina(getAppiumDriver());
    }

    @Test
    public void impedirCadastroUsuarioSenhasDiferentes() {
        loginPagina.clicarBotaoCadastrarNovoUsuario();
        cadastroPagina.inserirTextoNome("Henrique");
        cadastroPagina.inseirTextoSenha("senha");
        cadastroPagina.inserirTextoConfirmarSenha("se");
        cadastroPagina.clicarBotaoCadastrar();

        assertEquals("Senhas não conferem", cadastroPagina.retornarValorTextoAviso());
        cadastroPagina.voltarPagina();
    }

    @Test
    public void cadastrarUsuario() {
        loginPagina.clicarBotaoCadastrarNovoUsuario();
        cadastroPagina.inserirTextoNome("Henrique");
        cadastroPagina.inseirTextoSenha("senha");
        cadastroPagina.inserirTextoConfirmarSenha("senha");
        cadastroPagina.clicarBotaoCadastrar();
        cadastroPagina.voltarPagina();
    }
}
