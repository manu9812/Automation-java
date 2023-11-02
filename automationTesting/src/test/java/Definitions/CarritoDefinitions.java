package Definitions;

import PageObjects.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CarritoDefinitions {
    MenuPage menu;
    CapturarTarjetaPage tarjeta;
    DescripcionProductoPage  descripcion;
    ProcessPage process;

    ResumenCompra resumen;

    public CarritoDefinitions() {
        menu= new MenuPage(Hooks.driver);
        tarjeta= new CapturarTarjetaPage((Hooks.driver));
        descripcion= new DescripcionProductoPage((Hooks.driver));
        process= new ProcessPage((Hooks.driver));
        resumen= new ResumenCompra(Hooks.driver);
    }
    @Given("que la pagina esta disponible")
    public void queLaPaginaEstaDisponible() {
        Hooks.driver.get("https://demo.guru99.com/payment-gateway/");
    }
    @When("doy click en Generate Card Number")
    public void doyClickEnGenerateCardNumber() {
        menu.ClickGenerarTarjeta();
    }
    @And("capturo datos de tarjeta")
    public void capturoDatosDeTarjeta() {
        tarjeta.CambiarWindws();
        tarjeta.CapturarTarjeta();
        tarjeta.CapturarCVV();
        tarjeta.CapturarFecha();
        tarjeta.CapturarLineaCredito();
        tarjeta.cerrarWindows();
    }
    @And("registro una compra de  \"<cant>\" productos")
    public void registroUnaCompraDeProductos(String cant) {
        descripcion.CapturarTarifa();
        descripcion.SelectCant(cant);
        descripcion.ClickComprar();
    }
    @And("ingreso datos de tarjeta")
    public void ingresoDatosDeTarjeta() {
        process.CompararMonto();
        process.IngresarDatos();
    }

    @And("capturo datos de la orden")
    public void capturoDatosDeLaOrden() {
        resumen.CapturarMensaje();
        resumen.CapturarOrden();
        resumen.RegresarHome();
    }
}
