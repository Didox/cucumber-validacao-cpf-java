package io.cucumber.danilo;

import io.cucumber.java.en.Given;

public class StepDefinitions {
    @Given("I have {int} cukes in my belly")
    public void I_have_cukes_in_my_belly(int cukes) {
        ValidadorCpf validador = new ValidadorCpf();
        validador.validar(validador.toString());
    }
}
