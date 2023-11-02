package Definitions;

import PageObjects.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerDefinitions {
    TelecomProjectMenu telecom;
    AddCustomer customer;
    ResumeCustomer resumen;
    AddTariff tarifa;
    PlanToCustomer plan;
    ReturnHome home;


    public CustomerDefinitions() {
        telecom = new TelecomProjectMenu(Hooks.driver);
        customer= new AddCustomer(Hooks.driver);
        resumen= new ResumeCustomer(Hooks.driver);
        tarifa= new AddTariff(Hooks.driver);
        plan = new PlanToCustomer(Hooks.driver);
        home = new ReturnHome(Hooks.driver);

    }

    @Given("Que la pagina demo Guru esta diponible")
    public void queLaPaginaDemoGuruEstaDiponible() {
        Hooks.driver.get("https://demo.guru99.com/payment-gateway/");

    }

    @When("Doy click en Telecom Project")
    public void doyClickEnTelecomProject() {
        telecom.ClickTelecomProject();
    }

    @And("Doy click en agregar customer")
    public void doyClickEnAgregarCustomer() {
        telecom.ClickAgregarCustomer();

    }
    @And("cierro el anuncio")
    public void cierroElAnuncio() {

    }
    @And("Ingreso los datos para agregar el customer")
    public void ingresoLosDatosParaAgregarElCustomer() {
        customer.AddDataCustomer();
    }

    @And("capturo el Id del customer")
    public void capturoElIdDelCustomer() {
        resumen.CapturarIdCustomer();
        resumen.RegresarHome();
    }

    @And("Agrego plan tarifario al customer")
    public void agregoPlanTarifarioAlCustomer() {
        tarifa.AddTarifaCustomer();
    }

    @And("valido el nombre del cliente")
    public void validoElNombreDelCliente() {
        plan.CapturarNombreCliente();

    }

    @And("Valido el estado del cliente")
    public void validoElEstadoDelCliente() {
        plan.ValidarEstado();
    }

    @And("Selecciono La tarifa")
    public void seleccionoLaTarifa() {
        plan.SeleccionarTarifa();
    }

    @Then("regreso a la pagina principal")
    public void regresoALaPaginaPrincipal() {
        home.ReturnHome();
    }
}
