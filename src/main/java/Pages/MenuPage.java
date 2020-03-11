package Pages;

import org.openqa.selenium.By;

import Core.BasePage;

public class MenuPage extends BasePage {

	public void acessarTelaInserirConta() {
		ClicarLink("Contas");
		ClicarLink("Adicionar");	
	}
	public void acessarTelaListarConta(){
		ClicarLink("Contas");
		ClicarLink("Listar");
	}

	public void acessarTelaInserirMovimentacao() {
		ClicarLink("Criar Movimentação");
	}
	
}
