package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TelecomProjectMenu {
    private WebDriver driver;
    private WebDriverWait wait;
    //crear constructor
    public TelecomProjectMenu(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }

    @FindBy(linkText = "Telecom Project") private WebElement lnk_telecom_Project;

    @FindBy(linkText = "Add Customer") private WebElement lnk_add_customer;


    public void ClickTelecomProject(){
        wait.until(ExpectedConditions.elementToBeClickable(lnk_telecom_Project));
        lnk_telecom_Project.click();
    }
    public void ClickAgregarCustomer(){
        wait.until(ExpectedConditions.elementToBeClickable(lnk_add_customer));
        lnk_add_customer.click();

    }

}
