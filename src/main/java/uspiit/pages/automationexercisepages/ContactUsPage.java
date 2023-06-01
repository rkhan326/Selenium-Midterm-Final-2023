package uspiit.pages.automationexercisepages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uspiit.base.CommonAPI;


public class ContactUsPage extends CommonAPI {

    Logger log = LogManager.getLogger(ContactUsPage.class.getName());
    public ContactUsPage(WebDriver driver) {PageFactory.initElements(driver, this);}



    @FindBy(xpath = "//h2[text()='Get In Touch']")
    WebElement $contactUsHeader;
    @FindBy(css = "input[data-qa='name']")
    public WebElement $contactUsReviewNameField;
    @FindBy(css = "input[data-qa='email']")
    public WebElement $contactUsReviewEmailField;
    @FindBy(css = "input[data-qa='subject']")
    public WebElement $contactUsReviewSubjectField;
    @FindBy(css = "textarea[data-qa='message']")
    public WebElement $contactUsReviewField;
    @FindBy(css = ".btn.btn-primary.pull-left.submit_form")
    public WebElement $submitContactUsReviewButton;

    public String getContactUsHeaderText() {
        String text = getElementText($contactUsHeader);
        log.info("Ya did it! 'Contact Us' text acquisition success!!");
        return text;
    }
    public void enterReviewContactUsPage(WebDriver driver) {
        typeText($contactUsReviewNameField,"Top G");
        typeText($contactUsReviewEmailField,"topg@gmail.com");
        typeText($contactUsReviewSubjectField,"Appreciation");
        typeText($contactUsReviewField,"Thank you very much for this Automation Testing website!");
        clickWithActions(driver,$submitContactUsReviewButton );
        log.info("Ya di it! Review submittion success");
    }
}
