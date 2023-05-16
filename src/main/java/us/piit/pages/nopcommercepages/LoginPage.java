package us.piit.pages.nopcommercepages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class LoginPage  extends CommonAPI{

        Logger log = LogManager.getLogger(LoginPage.class.getName());
        public LoginPage(WebDriver driver){

            PageFactory.initElements(driver, this);
        }

        //locators
        @FindBy(css = "#Email") //driver.findElement(By.cssSelector(""))
        WebElement usernameField;

        @FindBy(css = "#Password")
        WebElement passwordField;

        @FindBy(xpath = "//a[@class='ico-login']")
        WebElement loginText;

        @FindBy(xpath = "//button[normalize-space()='Log in']")
        WebElement loginBtn;


        @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
        WebElement errorMessage;

        @FindBy(xpath = "//div[contains(text(),'Swag Labs')]")
        WebElement loginPageHeader;
        @FindBy(xpath = "//button[@class='button-1 search-box-button']")
        WebElement isLoginPageSuccessLocator;

        @FindBy (xpath = "//h2[text()='Welcome to our store']")
        WebElement loginPageSuccessLocator;

        //*******reusable methods*********
        public void enterUsername(String username){
            typeText(usernameField, username);
            log.info("enter username success");
        }
        public void enterPassword(String password){
            typeText(passwordField, password);
            log.info("enter password success");
        }
        public void clickOnLoginBtn(){
            clickOn(loginBtn);
            log.info("click on login button Success");
        }
    public void clickOnLoginText(){
        clickOn(loginText);
        log.info("click on login Text Success");
    }
        public String getErrorMessage(){
            String text = getElementText(errorMessage);
            log.info("get error message text success");
            return text;
        }
        public boolean checkPresenceOfLoginPageHeader(){
            boolean loginPageHeaderIsDisplayed = isVisible(loginPageHeader);
            log.info("login page header presence "+loginPageHeaderIsDisplayed);
            return loginPageHeaderIsDisplayed;
        }
    public boolean checkLoginPageSuccess(){
        boolean checkLoginPageSuccessIsDisplayed = isVisible(isLoginPageSuccessLocator);
        return checkLoginPageSuccessIsDisplayed;
    }
        public String getLoginPageHeaderText(){
            String loginPageHeaderText = getElementText(loginPageHeader);
            log.info("login page header text is "+loginPageHeaderText);
            return loginPageHeaderText;
        }
    public String getLoginPageSuccessText(){
        String text = getElementText(loginPageSuccessLocator);
        log.info("user logged in success");
        return text;
    }

    }

