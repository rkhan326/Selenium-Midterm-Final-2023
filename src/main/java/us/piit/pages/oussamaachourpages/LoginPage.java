package us.piit.pages.oussamaachourpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import us.piit.base.CommonAPI;

public class LoginPage extends CommonAPI {
    Logger log = LogManager.getLogger(LoginPage.class.getName()) ;
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#username")
    WebElement usernameField;

    @FindBy(xpath = "//button[text() = 'Log in']")
    WebElement loginBtn;

    @FindBy(xpath = "//a[@title = 'My Account']" )
    WebElement myAccountBtn;

    @FindBy(xpath = "//li[text()=\" The password you entered for the email address \"]" )
    WebElement errorMessage;



    public void enterUsername(String username){
        typeText(usernameField,username);
        log.info("enter username success");
    }

    public void enterPassword(String password){
        typeText(usernameField,password);
        log.info("enter password success");
    }

    public void clickOnLoginBtn(){
        clickOn(loginBtn);
        log.info("click on login button Success");

    }
    public String getErrorMessage(){
        String text = getElementText(errorMessage);
        log.info("get error message text success");
        return text;
    }
    public boolean checkPresenceOfErrorMessage(){
        boolean errorMessageIsDisplayed = isVisible(errorMessage);
        log.info("error message validation success.");
        return errorMessageIsDisplayed;
    }



}
