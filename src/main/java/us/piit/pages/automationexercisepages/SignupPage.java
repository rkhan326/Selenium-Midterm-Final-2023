package us.piit.pages.automationexercisepages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class SignupPage extends CommonAPI {

    Logger log = LogManager.getLogger(SignupPage.class.getName());
    public SignupPage(WebDriver driver) {PageFactory.initElements(driver, this);}

    String signupPassword = ("ontheblock");
    String fName = ("Top");
    String lName = ("G");
    String signupAddress = ("1 World Trade");
    String singupState = ("NY");
    String singupCity = ("NY");
    String singupZipcode = ("11111");
    String singupMobile = ("347777777");

    @FindBy(css = "#password")
    WebElement $signupPasswordField;
    @FindBy(css = "#first_name")
    WebElement $signupFNameField;
    @FindBy(css = "#last_name")
    WebElement $signupLNameField;
    @FindBy(css = "#address1")
    WebElement $signupAddressField;
    @FindBy(css = "#state")
    WebElement $signupStateField;
    @FindBy(css = "#city")
    WebElement $signupCityField;
    @FindBy(css = "#zipcode")
    WebElement $signupZipcodeField;
    @FindBy(css = "#mobile_number")
    WebElement $signupMobileField;
    @FindBy(css = ".btn.btn-default")
    WebElement $createAccountButton;
    @FindBy(css = ".btn.btn-primary")
    WebElement $signupContinueButton;

    //methods
    public void enterPasswordInSignupField() {typeText($signupPasswordField, signupPassword);}

    public void enterFNameInSignupField() {
        typeText($signupFNameField, fName);
    }

    public void enterLNameInSignupField() {
        typeText($signupLNameField, lName);
    }

    public void enterAddressInSignupField() {
        typeText($signupAddressField, signupAddress);
    }

    public void enterStateInSignupField() {
        typeText($signupStateField, singupState);
    }

    public void enterCityInSignupField() {
        typeText($signupCityField, singupCity);
    }

    public void enterZipcodeInSignupField() {
        typeText($signupZipcodeField, singupZipcode);
    }

    public void enterMobileInSignupField() {
        typeText($signupMobileField, singupMobile);
    }

    public void clickOnSignupButton() {
        clickOn($createAccountButton);
        log.info("Well done ma Gee! create account button click click success!!");
    }
    public void clickOnSingupContinueButton() {
        clickOn($signupContinueButton);
        log.info("Well done ma Gee! sign up continue button click click success!!");
    }
}
