package us.piit.pages.scaledupitpages;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class RegistrationPage extends CommonAPI {
    Logger log = LogManager.getLogger(RegistrationPage.class.getName());

    public RegistrationPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }
    Faker faker =new Faker();


    @FindBy(css = "#reg_email")
    WebElement emailField;
    @FindBy(css = "#reg_password")
    WebElement passwordField;
    @FindBy(xpath = "//button[text()='Register']")
    WebElement registerBtn;
    @FindBy(xpath = "//div[@class='woocommerce-MyAccount-content']/p[1]")
    WebElement validUsPassRegisterPageHeader;
    @FindBy(xpath = "//ul[@class='woocommerce-error']/li[1]")
    WebElement validEmailErrorMessage;

    @FindBy(xpath="//div[@class='woocommerce-MyAccount-content']/p[1]")
    WebElement weekPassRegisterPageHeader;



    public void enterEmail(String username) {
        typeText(emailField, username);

        log.info("enter email address success");
    }

    public void enterPassword(String password) {
        typeText(passwordField, password);
        log.info("enter password success");
    }


    public void clickOnRegisterBtn() {
        clickOn(registerBtn);
        log.info("click on register  button success");

    }



    public boolean checkPresenceOfValidUsPassRegisterPageHeader() {
        boolean loginPageHeaderIsDisplayed = isVisible(validUsPassRegisterPageHeader);
        log.info("login page header presence " + loginPageHeaderIsDisplayed);
        return loginPageHeaderIsDisplayed;
    }


    public String getValidUsPassRegisterPageHeadertext() {
        String loginPageHeaderText = getElementText(validUsPassRegisterPageHeader);
        log.info("login page header text is " + loginPageHeaderText);
        return loginPageHeaderText;

    }
    public boolean checkPresenceOfValidUsernameErrorMessage() {
        boolean loginPageHeaderIsDisplayed = isVisible(validEmailErrorMessage);
        log.info("login page header presence " + loginPageHeaderIsDisplayed);
        return loginPageHeaderIsDisplayed;
    }
    public String getValidUsernameErrorMessage() {
        String text = getElementText(validEmailErrorMessage);
        log.info("get error message text success");
        return text;
    }
    public boolean checkPresenceOfWeekPassRegisterPageHeader() {
        boolean loginPageHeaderIsDisplayed = isVisible(weekPassRegisterPageHeader);
        log.info("login page header presence " + loginPageHeaderIsDisplayed);
        return loginPageHeaderIsDisplayed;
    }


    public String getValidWeekPassRegisterPageHeadertext() {
        String loginPageHeaderText = getElementText(weekPassRegisterPageHeader);
        log.info("login page header text is " + loginPageHeaderText);
        return loginPageHeaderText;

    }
    public String enterNewFakeRegistrationEmail(){ return faker.internet().emailAddress(); }

    public String enterNewFakeRegistrationPassword(){ return faker.internet().password(); }
}


