package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResumenCompra {

    private WebDriver driver;
    private WebDriverWait wait;

    protected static  String mensaje;
    protected static String orden;


    public ResumenCompra(WebDriver d) {
        driver=d;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // declarar los locators
    @FindBy(tagName = "h2") private WebElement lbl_mensaje;
    @FindBy(xpath = "//*[@id=\"three\"]/div/div/table/tbody/tr[1]/td[2]/h3/strong") private WebElement lbl_Nro_orden;
    @FindBy(xpath = "//*[@id=\"three\"]/div/div/ul/li/a")private WebElement btn_home;
    public void CapturarMensaje(){
        mensaje= lbl_mensaje.getText();
        System.out.println("El estado de la compra es: "+ mensaje);
    }

    public void CapturarOrden(){
        orden= lbl_Nro_orden.getText();
        System.out.println("El numero de orden es: " + orden);
    }

    public void RegresarHome(){
        btn_home.click();
    }


}
