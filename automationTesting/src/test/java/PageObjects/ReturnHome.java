package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReturnHome {

    private WebDriver driver;
    private WebDriverWait wait;


    public ReturnHome(WebDriver d) {
        driver=d;
        wait=new WebDriverWait(driver, Duration.ofSeconds(40));
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "button") private WebElement btn_home;


    public void ReturnHome(){
        btn_home.click();
    }

}
