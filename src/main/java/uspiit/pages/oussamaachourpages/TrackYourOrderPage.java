package uspiit.pages.oussamaachourpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uspiit.base.CommonAPI;

public class TrackYourOrderPage extends CommonAPI {
    Logger log = LogManager.getLogger(TrackYourOrderPage.class.getName());


    public TrackYourOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy( css = "h1[class = 'entry-title']")
    WebElement trackYourOrderHeader;

    @FindBy( css = "button[class = 'button wp-element-button']")
    WebElement trackBtn;

    @FindBy( css = "input[id = 'orderid']")
    WebElement orderIdField;

    @FindBy( css = "input[id = 'order_email']")
    WebElement billingEmailField;

    @FindBy( xpath = "//ul[@class = 'woocommerce-error']/li[1]")
    WebElement trackOrderNotFoundErrorMessage;

    @FindBy( xpath = "//ul[@class = 'woocommerce-error']/li[1]")
    WebElement trackOrderInvalidEmailMessage;




    public void enterOrderID(String orderID){
        typeText(orderIdField, orderID);
        log.info("enter orderID success");
    }

    public void enterBillingEmail(String billingEmail){
        typeText(billingEmailField, billingEmail);
        log.info("enter billing Id success");
    }

    public void clickOnTrackBtn(){
        clickOn(trackBtn);
        log.info("click on Track button success");
    }

    public boolean checkPresenceOfTrackYourOrderHeader(){
        boolean trackYourOrderHeaderIsVisible = isVisible(trackYourOrderHeader);
        log.info("track your order header visibility check success.");
        return trackYourOrderHeaderIsVisible;
    }
    public String getTackYourOrderHeaderText(){
        String text = getElementText(trackYourOrderHeader);
        log.info("retrieval of Track Your Order Header text success");
        return text;
    }

    public boolean checkPresenceOfTrackInvalidEmailMessage(){
        boolean trackInvalidEmailMessageIsVisible = isVisible(trackOrderInvalidEmailMessage);
        log.info("track your order header visibility check success.");
        return trackInvalidEmailMessageIsVisible;
    }

    public boolean checkPresenceOfTrackOrderNotFoundMessage(){
        boolean trackOrderNotFoundMessageIsVisible = isVisible(trackOrderNotFoundErrorMessage);
        log.info("track InvalidEmailMessage visibility check success.");
        return trackOrderNotFoundMessageIsVisible;
    }

    public String getTrackOrderNotFoundErrorMessageText(){
        String text = getElementText(trackOrderNotFoundErrorMessage);
        log.info("retrieval of order not found error message text success");
        return text;
    }






}
