package us.piit.pages.scaledupitpages;

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


    @FindBy(css = "#reg_email")
    WebElement emailField;

    @FindBy(css = "#reg_password")
    WebElement passwordField;

    @FindBy(xpath = "//button[text()='Register']")
    WebElement registerBtn;


    @FindBy(xpath = "//div[@class='woocommerce-MyAccount-content']/p[1]")
    WebElement LoginPageHeader;




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



    public boolean checkPresenceOfLoginPageHeader() {
        boolean loginPageHeaderIsDisplayed = isVisible(LoginPageHeader);
        log.info("login page header presence " + loginPageHeaderIsDisplayed);
        return loginPageHeaderIsDisplayed;
    }


    public String getLoginPageHeadertext() {
        String loginPageHeaderText = getElementText(LoginPageHeader);
        log.info("login page header text is " + loginPageHeaderText);
        return loginPageHeaderText;

    }
}


