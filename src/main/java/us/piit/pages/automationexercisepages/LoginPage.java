package us.piit.pages.automationexercisepages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class LoginPage extends CommonAPI {

    Logger log = LogManager.getLogger(LoginPage.class.getName());
    public LoginPage(WebDriver driver) {PageFactory.initElements(driver, this);}

    String username = "originalgangster1@gmail.com";
    String password = "ontheblock";
    String invalidUsername = "unoriginalgangster1@gmail.com";
    String invalidPassword = "notontheblock";
    public String signupName = "Top G";
    String signupEmailAddress = "topg@gmail.com";

    //Buttons
    @FindBy(css = "a[href='/logout']")
    WebElement $logoutButton;
    @FindBy(css = "a[href='/delete_account']")
    WebElement $deleteAccountButton;
    @FindBy(css = ".btn.btn-primary")
    WebElement $deleteAccountContinueButton;
    @FindBy(css = "button[data-qa='login-button']")
    WebElement $loginButton;
    @FindBy(css = "button[data-qa='signup-button']")
    WebElement $signupButton;

    //Headers
    @FindBy(xpath = "//h2[text()='Login to your account']")
    WebElement $loginToYourAccountHeader;
    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    WebElement $loginErrorMessage;
    @FindBy(css = ".fa.fa-user")
    WebElement $loggedInIcon;

    //Input Fields
    @FindBy(css = "input[data-qa='login-email']")
    WebElement $loginEmailField;
    @FindBy(css = "input[name='password']")
    WebElement $loginPasswordField;
    @FindBy(css = "input[data-qa='signup-name']")
    WebElement $signupNameField;
    @FindBy(css = "input[data-qa='signup-email']")
    WebElement $signupEmailField;

    public void enterValidLoginEmailInLoginEmailField() {
        typeText($loginEmailField, username);
    }

    public void enterValidLoginPasswordInLoginPasswordField() {typeText($loginPasswordField, password);}

    public void enterInvalidLoginEmailInLoginEmailField() {
        typeText($loginEmailField, invalidUsername);
    }

    public void enterInvalidLoginPasswordInLoginPasswordField() {
        typeText($loginPasswordField, invalidPassword);
    }

    public void enterNameInSignupNameField() {
        typeText($signupNameField, signupName);
    }

    public void enterEmailInSignupEmailField() {
        typeText($signupEmailField, signupEmailAddress);
    }

    public void enterSignupEmailInLoginEmailField() {
        typeText($loginEmailField, signupEmailAddress);
    }

    //Methods
    public String getLoginToYourAccountHeaderText() {
        String text = getElementText($loginToYourAccountHeader);
        log.info("Well done my boy! 'Login to your account header' text acquisition success!!");
        return text;
    }
    public void clickOnLoginButton() {
        clickOn($loginButton);
        log.info("Well done my guy! Click click on 'Login button' success!!");
    }
    public void clickOnLogoutButton() {
        clickOn($logoutButton);
        log.info("Well done my guy! Click click on 'Logout button' success!!");
    }
    public void clickOnDeleteAccountButton() {
        clickOn($deleteAccountButton);
        log.info("Well done my guy! Click click on 'Delete account button' success!!");
    }
    public void clickOnDeleteAccountContinueButton() {
        clickOn($deleteAccountContinueButton);
        log.info("Well done my guy! Click click on 'Delete account continue button' success!!");
    }
    public void clickOnSignupButton() {
        clickOn($signupButton);
        log.info("Well done my guy! Click click on 'Signup button' success!!");
    }
    public boolean validatePresenceOfloggedInIcon() {
        boolean loggedInIconIsDisplayed = isVisible($loggedInIcon);
        log.info("Well done my guy! 'Logged in icon' is surely visible. Success!!");
        return loggedInIconIsDisplayed;
    }
    public String getLoginMessageErrorText() {
        String text = getElementText($loginErrorMessage);
        log.info("Well done my boy! 'Login error message' text acquisition success!!");
        return text;
    }
}
