package Testes;

import static Utils.DataUtils.ObterDataComDiferencaDias;
import static Utils.DataUtils.ObterDataFormadata;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import Core.BaseTest;
import Pages.MenuPage;
import Pages.MovimentacaoPage;
import Utils.DataUtils;

public class MovimentacaoTest extends BaseTest {
 
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage moviPage = new MovimentacaoPage();
	
	@Test
	public void InserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();

		Date DataFutura = ObterDataComDiferencaDias(-3); 
		
		moviPage.SetDataMovimentacao(ObterDataFormadata(DataFutura));
		moviPage.SetDataPagamento(ObterDataFormadata(DataFutura));
		moviPage.SetDescricao("Pagamento de Boleto");
		moviPage.SetInteressado("Pedro");
		moviPage.SetValor("500");
		moviPage.SetConta("MinhaConta1");
		moviPage.SetPagamento();
		moviPage.SetMovimentacao();
		moviPage.SalvarMovimentacao();		
		assertEquals("Movimenta��o adicionada com sucesso!", moviPage.ObterMensagemDeSucesso());		
	}

	@Test
	public void InserirCamposEmBranco() {
		menuPage.acessarTelaInserirMovimentacao();	
		moviPage.SalvarMovimentacao();	
		
		assertEquals(moviPage.msg(), moviPage.ObterMensagemDeSucesso());
	
		/*List<String> erros = moviPage.ObterErros();
			assertTrue(erros.containsAll(Arrays.asList(
			"Data da Movimenta��o � obrigat�rio","Data do pagamento � obrigat�rio",
		    "Descri��o � obrigat�rio\n", "Interessado � obrigat�rio","Valor � obrigat�rio",
		    "Valor deve ser um n�mero")));
		assertEquals(6, erros.size());
	*/
	}
	
	@Test
	public void testeInserirMovimentacaoFutura() {
		menuPage.acessarTelaInserirMovimentacao();
		
		Date DataFutura = ObterDataComDiferencaDias(5);
		
		moviPage.SetDataMovimentacaoIgualAtual(ObterDataFormadata(DataFutura));
		moviPage.SetDataPagamento(ObterDataFormadata(DataFutura));
		moviPage.SetDescricao();
		moviPage.SetInteressado();
		moviPage.SetValor();
		moviPage.SetConta();
		moviPage.SetPagamento();
		moviPage.SetMovimentacao();
		moviPage.SalvarMovimentacao();		
		assertEquals(moviPage.msgDataFutura(), moviPage.ObterMensagemDataFuturaIgualAtual());		
	}
}
