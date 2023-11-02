package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MenuPage {
    // crear dos varianles una de tipo web driver u otra de tipo webdriverwait
    private WebDriver driver;
    private WebDriverWait wait;
    //crear constructor
    public MenuPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }
    // declarar nuestros objetos
    @FindBy(linkText = "Generate Card Number") private WebElement lnk_generarTarjeta;
    //crear metodos del page
    public void ClickGenerarTarjeta(){
        wait.until(ExpectedConditions.elementToBeClickable(lnk_generarTarjeta));
        lnk_generarTarjeta.click();
    }

}
