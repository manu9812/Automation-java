package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResumeCustomer {
    private WebDriver driver;
    private WebDriverWait wait;

    protected static String id;

    public ResumeCustomer(WebDriver d) {
        driver=d;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h3") private WebElement lbl_id;
    @FindBy(className = "button") private  WebElement btn_home;

    public void CapturarIdCustomer(){
        id= lbl_id.getText();
        System.out.println("El id de la orden es: " + id);
    }

    public void RegresarHome(){
        btn_home.click();
    }
}
