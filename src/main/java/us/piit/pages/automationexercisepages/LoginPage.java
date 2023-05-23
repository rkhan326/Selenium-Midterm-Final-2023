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
    public LoginPage(WebDriver driver){PageFactory.initElements(driver, this);}

    String username = "originalgangster1@gmail.com";
    String password = "ontheblock";
    String invalidUsername = "unoriginalgangster1@gmail.com";
    String invalidPassword = "notontheblock";
    String signupName = "Top G";
    String signupEmailAddress = "topg@gmail.com";

    //Buttons
    @FindBy(css = "a[href='/logout']") WebElement logoutButton;
    @FindBy(css = "a[href='/delete_account']") WebElement deleteAccountButton;
    @FindBy(css = ".btn.btn-primary") WebElement deleteAccountContinueButton;

    //Headers
    @FindBy(xpath = "//h2[text()='Login to your account']") WebElement loginToYourAccountHeader;
    //Input Fields
    @FindBy(css = "input[data-qa='login-email']") WebElement loginEmailField;
    @FindBy(css = "input[name='password']") WebElement loginPasswordField;
    @FindBy(css = "input[data-qa='signup-name']") WebElement signupNameField;
    @FindBy(css = "input[data-qa='signup-email']") WebElement signupEmailField;
    //Login and Signup Buttons
    @FindBy(css = "button[data-qa='login-button']") WebElement loginButton;
    @FindBy(css = "button[data-qa='signup-button']") WebElement signupButton;
    //error message
    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']") WebElement loginErrorMessage;
    //logged in icon
    @FindBy(css=".fa.fa-user") WebElement loggedInIcon;

    //Methods
    public String getLoginToYourAccountHeaderText(){
        String text = getElementText(loginToYourAccountHeader);
        log.info("Well Done ma Gee! 'login to your account header text' validation success!!");
        return text;
    }
    public void enterValidLoginEmailInLoginEmailField() {
        typeText(loginEmailField, username);
    }
    public void enterValidLoginPasswordInLoginPasswordField() {typeText(loginPasswordField, password);}
    public void enterInvalidLoginEmailInLoginEmailField() {
        typeText(loginEmailField, invalidUsername);
    }
    public void enterInvalidLoginPasswordInLoginPasswordField() {
        typeText(loginPasswordField, invalidPassword);
    }
    public void enterNameInSignupNameField() {
        typeText(signupNameField, signupName);
    }
    public void enterEmailInSignupEmailField() {
        typeText(signupEmailField, signupEmailAddress);
    }


    public void clickClickOnLoginButton() {
        clickOn(loginButton);
        log.info("Well Done ma Gee! login button click click success!!");
    }
    public void clickClickOnLogoutButton() {
        clickOn(logoutButton);
        log.info("Well Done ma Gee! logout button click click success!!");
    }
    public void clickClickOnDeleteAccountButton() {
        clickOn(deleteAccountButton);
        log.info("Well Done ma Gee! delete account button click click success!!");
    }
    public void clickClickOnDeleteAccountContinueButton() {
        clickOn(deleteAccountContinueButton);
        log.info("Well Done ma Gee! delete account continue button click click success!!");
    }
    public void clickClickOnSignupButton() {
        clickOn(signupButton);
        log.info("Well Done ma Gee! signup button click click success!!");
    }
    public boolean validatePresenceOfloggedInIcon(){
        boolean loggedInIconIsDisplayed = isVisible(loggedInIcon);
        log.info("Well Done ma Gee! 'logged in icon' display success!!");
        return loggedInIconIsDisplayed;
    }
    public String getLoginMessageErrorText() {
        String text = getElementText(loginErrorMessage);
        log.info("Well Done ma Gee! 'login error message text' validation success!!");
        return text;
    }
}
