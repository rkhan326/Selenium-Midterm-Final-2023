package us.piit.pages.nopcommercepages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class ContactUsPage extends CommonAPI {
    Logger log = LogManager.getLogger(ContactUsPage.class.getName());
    public ContactUsPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }
    //******************locators**********************

    @FindBy(xpath = "//a[normalize-space()='Contact us']")
    WebElement clickOnContactUs;

    @FindBy(xpath = "//input[@id='FullName']")
    WebElement FullField;

    @FindBy(xpath = "//input[@id='Email']")
    WebElement emailField;

    @FindBy(xpath = "//textarea[@id='Enquiry']")
    WebElement typeTextField;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    WebElement hitSubmitButton;

    @FindBy(xpath = "//div[@class='result']")
    WebElement contactUsValidation;
    @FindBy(css = "#Email-error")
    WebElement contactUsValidationErrorLocator;





    // ***************Reusable methods******************

    //Click on Contact Us button
    public void clickOnContactUsButton() {
        clickOn(clickOnContactUs);
        log.info("Click on contact us button successfully");
    }

    //type FullName
    public void typeFullName(String fullName) {
        typeText(FullField, fullName);
        log.info("Type full Name successfully");
    }

    //type Email
    public void typeEmail(String email) {
        typeText(emailField, email);
        log.info("Type email successfully");
    }

    //type In TextField Box
    public void typeInTextFieldBox(String typeMessage) {
        typeText(typeTextField, typeMessage);
        log.info("Type Message successfully");
    }

    //click On Submit Button
    public void clickOnSubmitButton() {
        clickOn(hitSubmitButton);
        log.info("Click successfully");

    }

    // Contact Us validation
    public String contactUsValidation() {
        String text = getElementText(contactUsValidation);
        log.info(" contactUs Validation successfully.");
        return text;
    }
    public String contactUsValidationErrorMessage() {
        String text = getElementText(contactUsValidationErrorLocator);
        log.info(" show error message successfully.");
        return text;
    }


}
