package us.piit.pages.oussamaachourpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class ContactUsPage extends CommonAPI {
    Logger log = LogManager.getLogger(ContactUsPage.class.getName());

    public ContactUsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
//    @FindBy(xpath = "")
//    WebElement ;
}
