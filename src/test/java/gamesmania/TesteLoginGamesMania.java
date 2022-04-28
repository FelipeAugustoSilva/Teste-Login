package gamesmania;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLoginGamesMania {
	private WebDriver driver;

	@Before 
	public void abrirNavegador() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		}
	
	@Test
	public void testeNavegador () {
		driver.get("http://localhost:4200/login");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement inputEmail = driver.findElement(By.id("exampleInputEmail1"));
		WebElement inputSenha = driver.findElement(By.id("exampleInputPassword1"));
		WebElement botaoLogin = driver.findElement(By.className("btn-primary"));
		
		/*inputEmail.sendKeys("felipe@gmail.com");
		inputSenha.sendKeys("teste");
		botaoLogin.click();*/
		
		String[] listaSenhas = {"senha1", "senhasenha2", "1234", "335277"};
		for(int tentativas = 0; tentativas < listaSenhas.length; tentativas++) {
		
			try {
				inputEmail.clear();
				inputSenha.clear();
				
				inputEmail.sendKeys("felipeaugustodasilva23@gmail.com");
				inputSenha.sendKeys(listaSenhas[tentativas]);
				botaoLogin.click();
				
				Thread.sleep(3000);
				
			}catch (InterruptedException e) {
				e.printStackTrace();
				
			}
		}
	}
	
}
