package us.piit.pages.nopcommercepages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class NewsletterPage extends CommonAPI {
    Logger log = LogManager.getLogger(NewsletterPage.class.getName());
    public NewsletterPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }
    //************************Locator*******************************
    @FindBy(xpath = "//input[@id='newsletter-email']")
    WebElement newsletterEmailFieldLocator;
    @FindBy(xpath = "//button[@id='newsletter-subscribe-button']")
    WebElement subscribeLocator;
    @FindBy(xpath = "//div[@id='newsletter-result-block']")
    WebElement subscribeSuccessMessageLocator;
    @FindBy(xpath = "//div[@id='newsletter-result-block']")
    WebElement subscribeErrorMessageLocator;



    // ********************Reusable Methods*************************
    public void enterValidEmail(String email){
        typeText(newsletterEmailFieldLocator, email);
        log.info("Enter email success");
    }
    public void clickOnSubscribe(){
        clickOn(subscribeLocator);
        waitFor(1);
        log.info("click on Subscribe Success");
    }
    public String subscribeSuccessfully() {
        String text = getElementText(subscribeSuccessMessageLocator);
        log.info("Subscribe successfully confirmed.");
        return text;
    }
    public String subscribeErrorMessage() {
        String text = getElementText(subscribeErrorMessageLocator);
        log.info("Subscribe Error Message show success.");
        return text;
    }

}
