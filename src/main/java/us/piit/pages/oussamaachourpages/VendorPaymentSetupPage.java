package us.piit.pages.oussamaachourpages;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class VendorPaymentSetupPage extends CommonAPI {
    Logger log = LogManager.getLogger(VendorPaymentSetupPage.class.getName()) ;
    public VendorPaymentSetupPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    Faker faker = new Faker();

    @FindBy(css = "input[class='dokan-form-control email']")
    WebElement paymentSetupPaypalEmailField;

    @FindBy(css = "input[class='button-primary button button-large button-next payment-continue-btn dokan-btn-theme']")
    WebElement paymentSetupContinueBtn;

    @FindBy(xpath = "//a[text()='Skip this step']")
    WebElement paymentSetupSkipThisBtn;

    public void enterPaymentSetupPaypalEmail(String email){
        typeText(paymentSetupPaypalEmailField,email);
        log.info("enter setup page paypal email success");
    }

    public void clickOnPaymentSetupContinueBtn(){
        clickOn(paymentSetupContinueBtn);
        log.info("click on page setup continue button success");
    }

    public void clickOnPaymentSkipThisStepBtn(){
        clickOn(paymentSetupSkipThisBtn);
        log.info("click on payment setup skip this button success");
    }
    public String paymentSetupFakePaypalEmail() {return faker.internet().emailAddress();}
}
