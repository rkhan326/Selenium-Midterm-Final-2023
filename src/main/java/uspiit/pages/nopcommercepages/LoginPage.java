package uspiit.pages.nopcommercepages;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uspiit.base.CommonAPI;

public class LoginPage  extends CommonAPI {

        Logger log = LogManager.getLogger(LoginPage.class.getName());
        Faker faker = new Faker();
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
        @FindBy(xpath = "//a[normalize-space()='Log in']")
        WebElement loginLink;


    @FindBy(xpath = "//button[normalize-space()='Log in']")
        WebElement loginBtn;


        @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
        WebElement errorMessage;


        @FindBy(xpath = "//button[@class='button-1 search-box-button']")
        WebElement isLoginPageSuccessLocator;

        @FindBy(xpath = "//a[normalize-space()='Log out']")
        WebElement loginValidation;
        // Logout button
        @FindBy(xpath = "//a[@class='ico-logout']")
        WebElement LogOutButton;

        //Log-Out Validation
        @FindBy(xpath = "//a[@class='ico-login']")
        WebElement LogoutValidation;

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
            waitFor(1);
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

    public boolean checkLoginPageSuccess(){
        boolean checkLoginPageSuccessIsDisplayed = isVisible(isLoginPageSuccessLocator);
        return checkLoginPageSuccessIsDisplayed;
    }

    public String loginValidationText() {
        String text = getElementText(loginValidation);
        log.info("  login Validation successfully");
        return text;
    }
    public void clickOnLogOutButton() {
        clickOn(LogOutButton);
        log.info(" Click On LogOutButton successfully");
    }
    //Log-Out Validation
    public String logOutValidationText() {
        String text = getElementText(LogoutValidation);
        log.info("  log out Validation successfully");
        return text;
    }
    public void clickOnLoginLink() {
        clickOn(loginLink);
        log.info(" Click On LoginLink successfully.");

    }


}


