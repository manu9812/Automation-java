package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CloseAd {

    private WebDriver driver;
    private WebDriverWait wait;
    //crear constructor
    public CloseAd(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }





}
