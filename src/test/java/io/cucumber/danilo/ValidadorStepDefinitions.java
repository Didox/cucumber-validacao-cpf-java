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

public class ValidadorStepDefinitions {

    public WebDriver driver;
    
    @Given("I access the validator page")
    public void i_access_the_validator_page() {
        // System.setProperty("webdriver.chrome.driver", "/tmp/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8081/validar-cpf");
        driver.manage().timeouts().implicitlyWait(300,TimeUnit.SECONDS);
    }

    @When("I fill the name")
    public void i_fill_the_name() {
        WebElement campoNome = driver.findElement(By.name("nome"));
        campoNome.clear();
        campoNome.sendKeys("Danilo");
    }

    @When("I fill de CPF {string}")
    public void i_fill_de_CPF(String string) {
        WebElement campoCPF = driver.findElement(By.name("cpf"));
        campoCPF.clear();
        campoCPF.sendKeys(string);
        campoCPF.submit();
    }
    
    @Then("A have a invalid CPF")
    public void a_have_a_invalid_CPF() {
        WebElement success = driver.findElement(By.className("alert-danger"));
        driver.quit();
    }

    @Then("A have a valid CPF")
    public void a_have_a_valid_CPF() {
        WebElement success = driver.findElement(By.className("alert-success"));
        driver.quit();
    }
}
