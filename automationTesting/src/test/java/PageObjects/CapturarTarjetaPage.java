package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;


//Encapsulamiento (Nivel o tipo de acceso hacia las variables y metodos con los que trabajamos)
// Private -> solo se puede usar en la misma clase donde se declara
//Public -> se puede llamar en diferentes clases dentro del proyecto
// protected -> se puede usar entre las clases de un mismo Package
public class CapturarTarjetaPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //declarar variables para obtener los datos limpios

    protected static String tarjeta;
    protected static String cvv;
    protected static String mes;
    protected static String anio;
    protected static String saldo;



    public CapturarTarjetaPage(WebDriver d) {
        driver=d;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    // declarar locator
    @FindBy(xpath = "//h4[1]")private WebElement lbl_numeroTarjeta;
    @FindBy(xpath = "//h4[2]")private WebElement lbl_numeroCVV;
    @FindBy(xpath = "//h4[3]")private WebElement lbl_Fecha;
    @FindBy(xpath = "//h4[4]")private WebElement lbl_LineaCredito;

    public void CambiarWindws(){
        Set<String>indentificadores= driver.getWindowHandles();
        for (String identificador:indentificadores){
            driver.switchTo().window(identificador);
        }
    }
    public void CapturarTarjeta(){
        wait.until(ExpectedConditions.visibilityOf(lbl_numeroTarjeta));
        tarjeta= lbl_numeroTarjeta.getText().replace("Card Number:- ", "");
        System.out.println("El valor del tarjeta es: "+tarjeta);
    }
    public void CapturarCVV(){
        wait.until(ExpectedConditions.visibilityOf(lbl_numeroCVV));
        cvv =lbl_numeroCVV.getText().replace("CVV:- ","");
        System.out.println("El valor del cvv es: "+cvv);
    }
    public void CapturarFecha(){

        wait.until(ExpectedConditions.visibilityOf(lbl_Fecha));
        String fecha[]=lbl_Fecha.getText().replace("Exp:- ", "").split("/");
        mes=fecha[0];
        anio=fecha[1];
        System.out.println("El valor del mes es: "+mes);
        System.out.println("El valor del año es: "+anio);

    }
    public void CapturarLineaCredito(){
        wait.until(ExpectedConditions.visibilityOf(lbl_LineaCredito));
        saldo=lbl_LineaCredito.getText().replace("Credit Limit $", "");
        System.out.println("El valor de credito es: "+saldo);
    }
    public void cerrarWindows(){
        driver.close();
        driver.switchTo().window("");
    }
}
