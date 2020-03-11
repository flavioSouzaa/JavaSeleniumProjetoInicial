package Testes;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import Core.BaseTest;
import Pages.ContaPage;
import Pages.MenuPage;


public class ContaTest extends BaseTest{

	MenuPage menuPage = new MenuPage();
	ContaPage contasPage = new ContaPage();
	
	@Test
	public void testeInserirConta() {
		menuPage.acessarTelaInserirConta();
		
		contasPage.SetNome("MinhaConta1");
		contasPage.Salvar();
		
		assertEquals("Conta adicionada com sucesso!", contasPage.ObterMensagemSucesso());
		assertEquals("MinhaConta1", contasPage.ObterTextoSalvo());		
	}

	@Test
	public void alterarConta() {
		
        menuPage.acessarTelaListarConta();
		
		//contasPage.clicarAlterarConta("Conta do Teste");// chamar direto o botão para clica. 
		contasPage.clicarAlterarContas();
		contasPage.SetNome("Conta do Teste alterada");
		contasPage.Salvar();
		
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.ObterMensagemSucesso());
	}
	
	@Test
	public void InserirContaComMesmoNome() {
		menuPage.acessarTelaInserirConta();
		
		contasPage.SetNome("Conta do Teste alterada");
		contasPage.Salvar();
		
		assertEquals("Já existe uma conta com esse nome!", contasPage.ObterMensagemContaExistente());
	}	
	
}
