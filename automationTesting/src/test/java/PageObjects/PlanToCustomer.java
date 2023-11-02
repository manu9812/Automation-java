package PageObjects;

import com.github.dockerjava.core.dockerfile.DockerfileStatement;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlanToCustomer {

    private WebDriver driver;
    private WebDriverWait wait;

    protected static String estado = "ACTIVE";

    public PlanToCustomer(WebDriver d) {
        driver=d;
        wait=new WebDriverWait(driver, Duration.ofSeconds(40));
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h3") private WebElement tex_name;
    @FindBy(tagName = "font") private WebElement lbl_estado;
    //@FindBy(xpath = "//*[@id=\"main\"]/div/form/div[1]/table/tbody/tr/td[1]/label") private WebElement lb_tarifa;
    @FindBy(name = "submit") private WebElement btn_submit;

    public void CapturarNombreCliente(){
        String cadena =tex_name.getText().replace("Welcome to add customer tariff plan ", "");
        System.out.println(cadena);
        Assert.assertEquals(cadena, AddCustomer.nombre);
        System.out.println("Los nombres coinciden");

    }

    public void ValidarEstado(){
        try{
            //System.out.println(" Este es el estado " + lbl_estado.getText());
            Assert.assertEquals(estado,lbl_estado.getText());
            System.out.println("El usuario esta activo");
        }catch(AssertionError e){
            System.out.println("El usuario aun no ha sido activado");
        }

    }

    public void SeleccionarTarifa(){
        //wait.until(ExpectedConditions.elementToBeClickable(btn_submit)).click();
       // lb_tarifa.click();
        btn_submit.click();
    }

}
