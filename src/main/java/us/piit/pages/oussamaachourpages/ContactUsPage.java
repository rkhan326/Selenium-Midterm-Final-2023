package us.piit.pages.oussamaachourpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
    Logger log = LogManager.getLogger(ContactUsPage.class.getName());

    public ContactUsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
//    @FindBy(xpath = "")
//    WebElement ;
}
