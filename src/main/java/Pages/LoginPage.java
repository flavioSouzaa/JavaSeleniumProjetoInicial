package Pages;

import static Core.DriverFacory.getDriver;

import org.openqa.selenium.By;

import Core.BasePage;
import Core.DriverFacory;

public class LoginPage extends BasePage {
	
	public void acessarTelaInicial() {
		getDriver().get("https://srbarriga.herokuapp.com");		
		
	}
	public void SetEmail(String email) {
		Escreve("email", email);
	}
	
	public void SetSenha(String Senha) {
		Escreve("senha", Senha);
	}
	
	public void Entrar() {
		ClicarBotao(By.xpath("//button[.='Entrar']"));
	}
}
