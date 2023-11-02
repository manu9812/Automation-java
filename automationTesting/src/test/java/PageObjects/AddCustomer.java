package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddCustomer {
    private WebDriver driver;
    private WebDriverWait wait;
    protected static String nombre = "Manuela";
    protected static String apellidos = "Garcia Monsalve";
    protected static String email = "dyg9812@gmail.com";
    protected static String direccion = "Calle 90";
    protected static String telefono = "3104897126";

    //crear constructor

    public AddCustomer(WebDriver d) {
        driver=d;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"main\"]/div/form/div/div[1]/label") private WebElement  rb_Background;
    @FindBy(name = "fname") private WebElement lbl_fname;

    @FindBy(name = "lname") private WebElement lbl_lname;

    @FindBy(name = "emailid") private  WebElement lbl_emailid;

    @FindBy(name= "addr") private WebElement ta_direccion;

    @FindBy(name = "telephoneno") private WebElement lbl_telefono;
    @FindBy(name = "submit") private WebElement btn_submit;

    public void AddDataCustomer(){
       wait.until(ExpectedConditions.elementToBeClickable(rb_Background));
        rb_Background.click();
        lbl_fname.sendKeys(nombre);
        lbl_lname.sendKeys(apellidos);
        lbl_emailid.sendKeys(email);
        ta_direccion.sendKeys(direccion);
        lbl_telefono.sendKeys(telefono);
        btn_submit.click();
    }
}
