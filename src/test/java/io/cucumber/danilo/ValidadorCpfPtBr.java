package io.cucumber.danilo;

import io.cucumber.java.pt.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidadorCpfPtBr {
    public WebDriver driver;

    @Dado("que eu acesse a página de validação")
    public void que_eu_acesse_a_pagina_de_validação() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8081/validar-cpf");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Dado("preencho o nome")
    public void preencho_o_nome() {
        WebElement campoNome = driver.findElement(By.name("nome"));
        campoNome.clear();
        campoNome.sendKeys("Danilo");
    }

    @Dado("preencho o CPF {string}")
    public void preencho_o_CPF(String string) {
        WebElement campoCPF = driver.findElement(By.name("cpf"));
        campoCPF.clear();
        campoCPF.sendKeys(string);
        campoCPF.submit();
    }

    @Entao("devo ver um CPF válido")
    public void devo_ver_um_CPF_valido() {
        WebElement success = driver.findElement(By.className("alert-success"));
        String mensagem = driver.findElement(By.className("alert-success")).getText();
        assertEquals(mensagem, "foi validada como válido");
        driver.quit();
    }

    @Entao("devo ver um CPF inválido")
    public void devo_ver_um_CPF_inválido() {
        WebElement success = driver.findElement(By.className("alert-danger"));
        driver.quit();
    }
}
