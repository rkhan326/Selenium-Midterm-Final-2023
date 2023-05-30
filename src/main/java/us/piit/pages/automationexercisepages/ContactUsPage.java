package us.piit.pages.automationexercisepages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class ContactUsPage extends CommonAPI {

    Logger log = LogManager.getLogger(ContactUsPage.class.getName());
    public ContactUsPage(WebDriver driver) {PageFactory.initElements(driver, this);}

    @FindBy(xpath = "//h2[text()='Get In Touch']")
    WebElement $contactUsHeader;

    public String getContactUsHeaderText() {
        String text = getElementText($contactUsHeader);
        log.info("Ya did it! 'Contact Us' text acquisition success!!");
        return text;
    }
}
