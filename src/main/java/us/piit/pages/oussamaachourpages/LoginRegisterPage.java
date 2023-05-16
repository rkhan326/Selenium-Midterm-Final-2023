package us.piit.pages.oussamaachourpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import us.piit.base.CommonAPI;

public class LoginRegisterPage extends CommonAPI {
    Logger log = LogManager.getLogger(LoginRegisterPage.class.getName()) ;
    public LoginRegisterPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#username")
    WebElement loginUsernameField;

    @FindBy(css = "#password")
    WebElement loginPasswordField;

    @FindBy(xpath = "//button[text() = 'Log in']")
    WebElement loginBtn;

    @FindBy(xpath = "//a[@title = 'My Account']" )
    WebElement myAccountBtn;

    @FindBy(xpath = "//li[text()=\" The password you entered for the email address \"]" )
    WebElement errorMessage;

    @FindBy(xpath = "//input[@id ='reg_email' ]")
    WebElement registrationUsernameField;

    @FindBy(xpath = "//input[@id ='reg_password' ]")
    WebElement registrationPasswordField;

    @FindBy(xpath = "//input[@value = 'customer']")
    WebElement customerRadioBtn;

    @FindBy(xpath = "//input[@value = 'seller']")
    WebElement vendorRadioBtn;

    @FindBy(xpath = "//button[text()='Register']")
    WebElement registerBtn;


    //Login Methods
    public void enterLoginUsername(String username){
        typeText(loginUsernameField,username);
        log.info("enter username success");
    }
    public void enterLoginPassword(String password){
        typeText(loginPasswordField,password);
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


    //Registration Methods
    public void enterRegistrationUsername(String username){
        typeText(registrationUsernameField,username);
        log.info("enter registration username success");
    }
    public void enterRegistrationPassword(String password){
        typeText(registrationPasswordField,password);
        log.info("enter registration password success");
    }
    public void clickOnCustomerRadioBtn(){
        clickOn(customerRadioBtn);
        log.info("click on customer radio button success");
    }
    public void clickOnVendorRadioBtn(){
        clickOn(vendorRadioBtn);
        log.info("click on customer radio button success");
    }
    public boolean checkCustomerRadioBtnIsChecked(){
        boolean isCustomerRadioBtnChecked = isChecked(customerRadioBtn);
        if (isCustomerRadioBtnChecked == true){
            log.info("customer radio button is checked");
        }else {
            log.info("vendor radio button is checked");
        }
        return isCustomerRadioBtnChecked;
    }
    public boolean checkVendorRadioBtnIsChecked(){
        boolean isVendorRadioBtnChecked = isChecked(vendorRadioBtn);
        if (isVendorRadioBtnChecked == true){
            log.info("customer vendor button is checked");
        }else {
            log.info("vendor radio button is checked");
        }
        return isVendorRadioBtnChecked;
    }
    public boolean checkRegisterBtnIsVisible(){
        boolean isRegisterBtnVisible = isVisible(registerBtn);
        log.info("register button is visible");
        return isRegisterBtnVisible;
    }
    public void clickOnRegisterBtn(){
        clickOn(registerBtn);
        log.info("click on register button success");
    }


}
