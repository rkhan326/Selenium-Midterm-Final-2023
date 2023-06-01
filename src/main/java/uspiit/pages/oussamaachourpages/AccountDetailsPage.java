package uspiit.pages.oussamaachourpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AccountDetailsPage {
    Logger log = LogManager.getLogger(AccountDetailsPage.class.getName());

    public AccountDetailsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
//    @FindBy(xpath = "")
//    WebElement ;
}
