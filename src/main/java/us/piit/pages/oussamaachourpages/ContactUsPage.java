package us.piit.pages.oussamaachourpages;

import com.github.javafaker.Faker;
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

    Faker faker = new Faker();

    @FindBy(css = ".entry-title")
    WebElement contactUsHeader;

    @FindBy(css = "#wpforms-5345-field_0")
    WebElement firstNameField;

    @FindBy(css = "#wpforms-5345-field_0-last")
    WebElement lastNameField;

    @FindBy(css = "#wpforms-5345-field_1")
    WebElement emailField;

    @FindBy(css = "#wpforms-5345-field_2")
    WebElement commentOrMessageField;

    @FindBy(css = "#wpforms-submit-5345")
    WebElement sendMessageBtn;

    @FindBy(css = "#wpforms-confirmation-5345 p")
    WebElement tYForContactingUsMessage;

    @FindBy(css = "#wpforms-5345-field_1-error")
    WebElement invalidEmailErrorMessage;


    public boolean checkPresenceOfContactUsHeader(){
        boolean contactUsHeaderIsDisplayed = isVisible(contactUsHeader);
        log.info("contact us header validation success.");
        return contactUsHeaderIsDisplayed;
    }

    public void enterFirstName(String firstName){
        typeText(firstNameField, firstName);
        log.info("enter contact us firstname success");
    }

    public void enterLastName(String lastName){
        typeText(lastNameField, lastName);
        log.info("enter contact us lastname success");
    }
    public void enterEmail(String email){
        typeText(emailField, email);
        log.info("enter contact us email success");
    }
    public void clickOnMessageOrCommentField(){
        clickOn(commentOrMessageField);
        log.info("enter contact us message Or Comment success");
    }
    public void enterMessageOrComment(String messageOrComment){
        typeText(commentOrMessageField, messageOrComment);
        log.info("enter contact us message Or Comment success");
    }

    public void clickOnSendMessageBtn(WebDriver driver){
        scrollToElementwJS(sendMessageBtn, driver);
        waitFor(1);
        clickOn(sendMessageBtn);
        log.info("click on send message button success");
    }

    public boolean checkPresenceOfTYForContactingUsMessage(){
        boolean TYMessageIsDisplayed = isVisible(tYForContactingUsMessage);
        log.info("Thank you For Contacting Us Message validation success.");
        return TYMessageIsDisplayed;
    }

    public boolean checkPresenceOfInvalidEmailErrorMessage(){
        boolean invalidEmailErrorMessageIsDisplayed = isVisible(invalidEmailErrorMessage);
        log.info("invalid Email Error Message validation success.");
        return invalidEmailErrorMessageIsDisplayed;
    }



    public String fakeCustomerFirstName(){ return faker.funnyName().name();}
    public String fakeCustomerLastName(){ return faker.funnyName().name();}
    public String fakeCustomerEmail(){ return faker.internet().emailAddress();}
    public String fakeCustomerMessageOrComment(){ return faker.backToTheFuture().quote();}

}
