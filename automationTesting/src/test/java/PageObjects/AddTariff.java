package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddTariff {

    private WebDriver driver;
    private WebDriverWait wait;





    public AddTariff(WebDriver d) {
        driver=d;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);



    }

    @FindBy(linkText = "Add Tariff Plan to Customer") private WebElement ln_addplan;
    @FindBy(id = "customer_id") private WebElement lbl_id;
    @FindBy(name = "submit") private WebElement btn_submit;



    public void AddTarifaCustomer(){
        ln_addplan.click();
        lbl_id.sendKeys(ResumeCustomer.id);
        btn_submit.click();

    }

}
