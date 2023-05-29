package us.piit.pages.oussamaachourpages;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class LoginRegisterPage extends CommonAPI {
    Logger log = LogManager.getLogger(LoginRegisterPage.class.getName()) ;
    public LoginRegisterPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    Faker faker = new Faker();

    @FindBy(css = "#username")
    WebElement loginUsernameField;

    @FindBy(css = "#password")
    WebElement loginPasswordField;

    @FindBy(xpath = "//button[text() = 'Log in']")
    WebElement loginBtn;

    @FindBy(xpath = "//a[@title = 'My Account']" )
    WebElement myAccountBtn;

    @FindBy(xpath = "//li[text()= ' The password you entered for the email address ']" )
    WebElement loginInvalidPasswordMessage;

    @FindBy(xpath = "//ul[@class= 'woocommerce-error']//li[1]" )
    WebElement loginInvalidUsernameMessage;
    @FindBy(xpath = "//ul[@class ='woocommerce-error']//li[1]" )
    WebElement loginUnrecognizedEmailMessage;

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

    @FindBy (xpath = "//li[text()=' An account is already registered with your email address. ']")
    WebElement registrationErrorMessage;

    @FindBy(xpath= "//input[@id ='first-name' ]")
    WebElement registrationVendorFirstNameField;

    @FindBy(xpath= "//input[@id ='last-name' ]")
    WebElement registrationVendorLastNameField;

    @FindBy(xpath= "//input[@id ='company-name' ]")
    WebElement registrationVendorShopNameField;

    @FindBy(xpath= "//input[@id ='seller-url' ]")
    WebElement registrationVendorShopUrlField;

    @FindBy(xpath= "//input[@id ='shop-phone' ]")
    WebElement registrationVendorShopContactField;

    @FindBy(xpath = "//a[text()='Lost your password?']")
    WebElement lostYourPasswordLink;

    @FindBy(xpath = "//div[@class= 'woocommerce-password-strength bad']")
    WebElement weakPassword;

    @FindBy(xpath = "//div[@class= 'woocommerce-password-strength good']")
    WebElement mediumPassword;

    @FindBy(xpath = "//div[@class= 'woocommerce-password-strength strong']")
    WebElement strongPassword;



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
    public String getLoginInvalidPasswordMessageText(){
        String text = getElementText(loginInvalidPasswordMessage);
        log.info("get invalid password login message text success");
        return text;
    }
    public String getLoginInvalidUsernameMessageText(){
        String text = getElementText(loginInvalidUsernameMessage);
        log.info("get invalid username login message text success");
        return text;
    }
    public String getLoginUnrecognizedEmailMessageText(){
        String text = getElementText(loginUnrecognizedEmailMessage);
        log.info("get Unrecognized Email login Message text success");
        return text;
    }
    public boolean checkPresenceOfLoginInvalidPasswordMessage(){
        boolean errorMessageIsDisplayed = isVisible(loginInvalidPasswordMessage);
        log.info("login invalid password error message validation success.");
        return errorMessageIsDisplayed;
    }

    public boolean checkPresenceOfLoginInvalidUsernameMessage(){
        boolean errorMessageIsDisplayed = isVisible(loginInvalidUsernameMessage);
        log.info("login invalid Username error message validation success.");
        return errorMessageIsDisplayed;
    }

    public boolean checkPresenceOfLoginUnrecognizedEmailMessage(){
        boolean errorMessageIsDisplayed = isVisible(loginUnrecognizedEmailMessage);
        log.info("login invalid Username error message validation success.");
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

    public boolean checkPresenceOfRegistrationErrorMessage(){
        boolean errorMessageIsDisplayed = isVisible(registrationErrorMessage);
        log.info("registration error message validation success.");
        return errorMessageIsDisplayed;
    }

    public void enterRegistrationVendorFirstName(String vendorFirstName){
        typeText(registrationVendorFirstNameField,vendorFirstName);
        log.info("enter registration vendor firstname success");
    }
    public void enterRegistrationVendorLastName(String vendorLastName){
        typeText(registrationVendorLastNameField,vendorLastName);
        log.info("enter registration vendor lastname success");
    }

    public void enterRegistrationVendorShopName(String vendorShopName){
        typeText(registrationVendorShopNameField,vendorShopName);
        log.info("enter registration vendor shop name success");
    }

    public void enterRegistrationVendorShopUrl(String vendorShopUrl){
        typeText(registrationVendorShopUrlField,vendorShopUrl);
        log.info("enter registration vendor shop url success");
    }

    public void enterRegistrationVendorShopContact(String vendorShopContact){
        typeText(registrationVendorShopContactField,vendorShopContact);
        log.info("enter registration vendor shop contact info success");
    }

    public void scrollToRegisterBtnwJS(WebDriver driver){
        scrollToElementwJS(registerBtn, driver);
    }

    public void clickOnLostYourPasswordLink(){
        clickOn(lostYourPasswordLink);
        log.info("click on lost your password link");
    }
    public String getStrongPasswordStrengthText(){
        String text = getElementText(strongPassword);
        log.info("get strong password strength  text success");
        return text;
    }
    public String getWeakPasswordStrengthText(){
        String text = getElementText(weakPassword);
        log.info("get weak password strength  text success");
        return text;
    }
    public String getMediumPasswordStrengthText(){
        String text = getElementText(mediumPassword);
        log.info("get medium password strength  text success");
        return text;
    }

    public String newFakeRegistrationLoginUsername(){ return faker.internet().emailAddress();}
    public String newFakeRegistrationLoginPassword() { return faker.internet().password(10,12,true,true,true);}
    public String fakeVendorFirstName(){ return faker.name().firstName();}
    public String fakeVendorLastName(){ return faker.name().lastName();}
    public String fakeVendorShopName(){return faker.company().name();}
    public String fakeVendorShopUrl(){ return faker.company().url();}
    public String fakeVendorShopContact(){ return faker.phoneNumber().phoneNumber();}
    public String fakeWeakPassword(){ return faker.internet().password(1,8,false,false,true);}
    public String fakeMediumPassword(){ return faker.internet().password(9,10,true,true,true);}
    public String fakeStrongPassword(){ return faker.internet().password(11,20,true,true,true);}
}

