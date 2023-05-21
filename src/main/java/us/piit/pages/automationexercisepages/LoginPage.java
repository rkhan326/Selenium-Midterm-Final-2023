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

    @FindBy(css = "img[alt='Website for automation practice']")
    WebElement LoginPageHeaderButton;

    @FindBy(css = "input[name='email']")
    WebElement LoginEmailField;

    @FindBy(css = "input[name='password']")
    WebElement LoginPasswordField;

    @FindBy(css = "button[data-qa='login-button']")
    WebElement LoginButton;

    @FindBy(css = "input[name='email']")
    WebElement SignupEmailField;

    @FindBy(css = "input[name='password']")
    WebElement SignupPasswordField;

    @FindBy(css = "button[data-qa='signup-button']")
    WebElement SignupButton;


}
