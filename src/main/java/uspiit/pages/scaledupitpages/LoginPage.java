package uspiit.pages.scaledupitpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uspiit.base.CommonAPI;

public class LoginPage extends CommonAPI {
    Logger log = LogManager.getLogger(LoginPage.class.getName());

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@id='username']")
    WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;
    @FindBy(xpath = "// button[@name='login']")
    WebElement loginBtn;
    @FindBy(xpath = "//div[@class='woocommerce-notices-wrapper']/ul[1]/li[1]")
    WebElement errorMessage;

    @FindBy(xpath = "//h1[text()='My account']")
    WebElement loginPageHeader;


    @FindBy(xpath = "//div[@class='woocommerce-MyAccount-content']/p[1]")
    WebElement mainLoginPageHeader;

    @FindBy(xpath = "//a[contains(text(),'Lost your password?')]")
    WebElement forgetPassword;

    @FindBy(xpath = "//h1[text()='Lost password']")
    WebElement lostPasswordHeader;

    public void enterUsername(String username) {
        typeText(usernameField, username);

        log.info("enter username success");
    }

    public void enterPassword(String password) {
        typeText(passwordField, password);
        log.info("enter password success");
    }

    public void clickOnLoginBtn() {
        clickOn(loginBtn);
        log.info("click on login button success");

    }

    public boolean checkPresenceOfErrorMessageText() {
        boolean loginPageHeaderIsDisplayed = isVisible(errorMessage);
        log.info("login page header presence " + loginPageHeaderIsDisplayed);
        return loginPageHeaderIsDisplayed;
    }

    public String getErrorMessageText() {
        String text = getElementText(errorMessage);
        log.info("get error message text success");
        return text;
    }

    public boolean checkPresenceOfLoginPageHeader() {
        boolean loginPageHeaderIsDisplayed = isVisible(loginPageHeader);
        log.info("login page header presence " + loginPageHeaderIsDisplayed);
        return loginPageHeaderIsDisplayed;
    }

    public String getLoginPageHeadertext() {
        String loginPageHeaderText = getElementText(loginPageHeader);
        log.info("login page header text is " + loginPageHeaderText);
        return loginPageHeaderText;

    }


    public String getMainLoginPageHeadertext() {
        String loginPageHeaderText = getElementText(mainLoginPageHeader);
        log.info("login page header text is " + loginPageHeaderText);
        return loginPageHeaderText;

    }

    public void clickOnForgetPasswordBtn() {
        clickOn(forgetPassword);
        log.info("click on forget password success");

    }

    public boolean checkPresenceOfLostPasswordHeader() {
        boolean loginPageHeaderIsDisplayed = isVisible(lostPasswordHeader);
        log.info("login page header presence " + loginPageHeaderIsDisplayed);
        return loginPageHeaderIsDisplayed;
    }

    public String getForgetPasswordHeadertext() {
        String loginPageHeaderText = getElementText(lostPasswordHeader);
        log.info("login page header text is " + loginPageHeaderText);
        return loginPageHeaderText;

    }
}




