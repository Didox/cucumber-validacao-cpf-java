package io.cucumber.danilo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidadorStepDefinitions {

    public WebDriver driver;
    
    @Given("I access the validator page")
    public void i_access_the_validator_page() {
        // System.setProperty("webdriver.chrome.driver", "/tmp/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8081/validar-cpf");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @When("I fill the name")
    public void i_fill_the_name() throws InterruptedException {
        WebElement campoNome = driver.findElement(By.name("nome"));
        campoNome.clear();
        campoNome.sendKeys("Danilo");
        Thread.sleep(2000);
    }

    @When("I fill de CPF {string}")
    public void i_fill_de_CPF(String string) {
        WebElement campoCPF = driver.findElement(By.name("cpf"));
        campoCPF.clear();
        campoCPF.sendKeys(string);
        campoCPF.submit();
    }
    
    @Then("A have a invalid CPF")
    public void a_have_a_invalid_CPF() throws InterruptedException {
        // WebDriverWait wait = new WebDriverWait(driver, 10);
        // wait.until(ExpectedConditions.visibilityOf(camponome));
        
        WebElement success = driver.findElement(By.className("alert-danger"));
        Thread.sleep(2000);
        driver.quit();
    }

    @Then("A have a valid CPF")
    public void a_have_a_valid_CPF() throws InterruptedException {
        WebElement success = driver.findElement(By.className("alert-success"));

        String mensagem = driver.findElement(By.className("alert-success")).getText();
        // String mensagem = driver.findElement(By.id("enviar")).getText();
        // String mensagem = driver.findElement(By.tagName("div")).getText();
        assertEquals(mensagem , "foi validada como válido");

        Thread.sleep(2000);
        driver.quit();
    }
}
