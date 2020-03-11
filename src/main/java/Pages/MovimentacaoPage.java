package Pages;

import static Core.DriverFacory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Core.BasePage;

public class MovimentacaoPage extends BasePage {

	public void SetDataMovimentacao(String data) {
		Escreve("data_transacao", data);
	}
	public void SetDataMovimentacaoIgualAtual(String data) {
		Escreve("data_transacao", data);
	}
	public void SetDataPagamento(String data) {
		Escreve("data_pagamento", data);
	}

	public void SetDescricao(String descricao) {
		Escreve("descricao", descricao);
	}

	public void SetInteressado(String interessado) {
		Escreve("interessado", interessado);
	}

	public void SetValor(String valor) {
		Escreve("valor", valor);
	}

	public void SetConta(String conta) {
		SelecionarCombo("conta", conta);
	}

	public void SetMovimentacao() {
		SelecionarCombo("tipo", "Despesa");
	}

	public void SetPagamento() {
		ClicarRadio("status_pago");
	}

	public void SalvarMovimentacao() {
		ClicarBotaoPorTexto("Salvar");

	}

	public String ObterMensagemDeSucesso() {
		return ObterTexto(By.xpath("/html/body/div[1]"));
	}

	public String ObterMensagemDataFuturaIgualAtual() {
		return ObterTexto(By.xpath("/html/body/div[1]"));
	}
	public String msg() {
		String msg = "";
		return msg = "Data da Movimentação é obrigatório\n" + "Data do pagamento é obrigatório\n"
				+ "Descrição é obrigatório\n" + "Interessado é obrigatório\n" + "Valor é obrigatório\n"
				+ "Valor deve ser um número";
	}
	public String msgDataFutura() {
		String msg = "";
		return msg = "Data da Movimentação deve ser menor ou igual à data atual";
	}

	public List<String> ObterErros() {
		List<WebElement> erros = getDriver().findElements(By.xpath("//div[@class='alert alert-danger'//li]"));
		List<String> retorno = new ArrayList<String>();//div[@class='alert alert-danger'//li]
		for (WebElement erro : erros) {				   //div[@class='alert alert-danger'//li]
			retorno.add(erro.getText());
		}
		return retorno;
	}
}