package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;

public class ProcessPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProcessPage(WebDriver d) {
        driver=d;
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    //locators
    @FindBy(xpath = "//font[2]") private WebElement lbl_payment;
    @FindBy(id = "card_nmuber") private WebElement txt_nroTarjeta;
    @FindBy(id = "month") private WebElement cbx_mes;
    @FindBy(id = "year") private WebElement cbx_anio;
    @FindBy(id = "cvv_code") private WebElement txt_cvv;
    @FindBy(name = "submit") private WebElement btn_pagar;

    public void CompararMonto(){
        wait.until(ExpectedConditions.visibilityOf(lbl_payment));
        String MontoCompra= lbl_payment.getText().replace("$", "");
        BigDecimal totalMontoCompra = new BigDecimal(MontoCompra).setScale(2, RoundingMode.HALF_UP);
        BigDecimal totalMontoCalculado = new BigDecimal(DescripcionProductoPage.total).setScale(2,RoundingMode.HALF_UP);
        System.out.println("El valor del monto actual es: "+ totalMontoCompra);
        System.out.println("El valor del monto calculado es: "+ totalMontoCalculado);
        Assert.assertEquals(totalMontoCompra, totalMontoCalculado);
        System.out.println("El monto de compra coincide con el pago a realizar!!");

    }

    public void IngresarDatos(){
        txt_nroTarjeta.sendKeys(CapturarTarjetaPage.tarjeta);
        new Select(cbx_mes).selectByVisibleText(CapturarTarjetaPage.mes);
        new Select(cbx_anio).selectByVisibleText(CapturarTarjetaPage.anio);
        txt_nroTarjeta.sendKeys(CapturarTarjetaPage.cvv);
        btn_pagar.click();
    }
}
