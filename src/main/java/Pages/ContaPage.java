package Pages;

import org.openqa.selenium.By;

import Core.BasePage;

public class ContaPage extends BasePage {

	public void SetNome(String nome) {
		Escreve("nome", nome);
	}
	
	public void Salvar() {
		ClicarBotao(By.xpath("/html/body/div[2]/form/div[2]/button"));
		//clicar botão por texto = By.xpath("//button[.='"+texto+"']"));
	}
	
	public String ObterMensagemSucesso() {
		return ObterTexto(By.xpath("/html/body/div[1]"));
	}
	public String ObterMensagemContaExistente() {
		return ObterTexto(By.xpath("/html/body/div[1]"));
	}
	
	public String ObterTextoSalvo() {
		return ObterTexto(By.xpath("//*[@id=\"tabelaContas\"]/tbody/tr/td[1]"));
	}
		
	public void clicarAlterarConta(String string) {
		obterCelula("Conta", string, "Ações", "tabelaContas")
			.findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
	}
	public void clicarAlterarContas() {
		ClicarBotao(By.xpath("//*[@id=\"tabelaContas\"]/tbody/tr[3]/td[2]/a[1]/span"));
	}
	public void SelecionarCombo(String opcao) {
		SelecionarCamboPorPosicao("tipo", opcao);
	}
}
