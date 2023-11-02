package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.time.Duration;

public class DescripcionProductoPage {
    private WebDriver driver;
    private WebDriverWait wait;
    protected String tarifa;

    protected static double total;


    public DescripcionProductoPage(WebDriver d) {
        driver=d;
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    //mapeo de locators
    @FindBy(tagName = "h3")private WebElement lbl_tarifa;
    @FindBy(name = "quantity") private WebElement cbx_cantidad;
    @FindBy(tagName = "input") private WebElement btn_comprar;


    public void CapturarTarifa(){
        tarifa= lbl_tarifa.getText().replace("Price: $","");
        System.out.println("El valor de la tarifa por producto es:"+ tarifa);
    }

    public void SelectCant(String cant){
        new Select(cbx_cantidad).selectByVisibleText(cant);
        total= Double.parseDouble(tarifa)*Double.parseDouble(cant);
        System.out.println("El valor comprado es de: "+ total);
    }

    public void ClickComprar(){
        btn_comprar.click();
    }

}
