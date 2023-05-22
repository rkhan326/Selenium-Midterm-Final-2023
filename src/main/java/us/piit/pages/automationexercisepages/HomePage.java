package us.piit.pages.automationexercisepages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class HomePage extends CommonAPI {
    Logger log = LogManager.getLogger(HomePage.class.getName());
    public HomePage(WebDriver driver){PageFactory.initElements(driver, this);}


    @FindBy(css = "img[alt='Website for automation practice']")
    WebElement LoginPageHeaderButton;

}
