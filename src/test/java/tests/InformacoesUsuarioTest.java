package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InformacoesUsuarioTest {
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(){
        //Abrindo o navegador
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Rafael\\Drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Navegando para a página do Taskit!
        navegador.get("http://www.juliodeLima.com.br/taskit");

        //Clicar no link que possui um texto "Sing in"
        navegador.findElement(By.xpath("/html/body/nav/div/div/ul[1]/li/a")).click();

        // Indentificando o fomulário de Login
        WebElement formularioSingInBox = navegador.findElement(By.id("signinbox"));

        //Digitar no campo com name "login" que está dentro do formulário de id "singbox" o texto "Rafael Silva"
        formularioSingInBox.findElement(By.name("login")).sendKeys("Rafael Silva");

        //Digitar no campo com name "password" que está dentro do formulário de id "singbox" o texto "123456"
        formularioSingInBox.findElement(By.name("password")).sendKeys("123456");

        //Clicar no link com o texto "SING IN"
        navegador.findElement(By.xpath("//*[@id=\"signinbox\"]/div[2]/a")).click();

        //Validar que dentro do elemento class "me" esta o texto "Hi, Rafael"
        WebElement me = navegador.findElement(By.className("me"));
        String texxtoNoElementoMe = me.getText();
        assertEquals("Hi, Rafael", texxtoNoElementoMe);

        //Fechar o browser
        navegador.quit();




    }

}
