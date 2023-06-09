package uspiit.pages.automationexercisepages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uspiit.base.CommonAPI;

public class CartPage extends CommonAPI {

    Logger log = LogManager.getLogger(CartPage.class.getName());
    public CartPage(WebDriver driver) {PageFactory.initElements(driver, this);}

    @FindBy(xpath = "//h2[text()='Subscription']")
    WebElement $subscriptionText;
    @FindBy(xpath = "//u[text()='View Cart']")
    public WebElement $maxiDressViewCartButton;
    @FindBy(css = ".btn.btn-default.check_out")
    public WebElement $placeOrderButton;
    @FindBy(xpath = "//b[text()='Cart is empty!']")
    public WebElement $cartIsEmptyText;
    @FindBy(css = ".btn.btn-default.check_out")
    public WebElement $proceedToCheckoutMaxiDressButton;

    @FindBy(css = ".btn.btn-success.close-checkout-modal.btn-block")
    public WebElement $continueOnCartMaxiDressButton;
    @FindBy(xpath = "//u[text()='Register / Login']")
    public WebElement $registerLoginCheckoutMaxiDressButton;
    @FindBy(css = ".form-control.btn.btn-primary.submit-button")
    public WebElement $payAndConfirmButton;
    @FindBy(css = ".heading")
    public WebElement $addressDetailsText;
    @FindBy(css = ".ns-klfer-e-7")
    public WebElement $adButton;

    public void clickOnMaxiDressViewCartButton(WebDriver driver) {
        clickWithActions(driver,$maxiDressViewCartButton);
        log.info("Well done my guy! Click click on 'Maxi Dress view cart button' success!!");
    }
    public void clickOnProceedToCheckoutMaxiDressButton(WebDriver driver) {
        clickWithActions(driver,$proceedToCheckoutMaxiDressButton);
        log.info("Well done my guy! Click click on 'Maxi Dress proceed to checkout button' success!!");
    }
    public void clickOnContinueOnCartMaxiDressButton(WebDriver driver) {
        clickWithActions(driver,$continueOnCartMaxiDressButton);
        log.info("Well done my guy! Click click on 'Maxi Dress continue on cart button' success!!");
    }
    public void clickOnRegisterLoginCheckoutMaxiDressButton(WebDriver driver) {
        clickWithActions(driver,$registerLoginCheckoutMaxiDressButton);
        log.info("Well done my guy! Click click on 'Register/ Login button' success!!");
    }
    public void clickOnPlaceOrderButton(WebDriver driver) {
        clickWithActions(driver,$placeOrderButton);
        log.info("Well done my guy! Click click on 'Register/ Login button' success!!");
    }

    public boolean proceedToCheckoutIsVisible(){
        log.info("Well done my guy! Proceed to checkout is visible!");
        return isVisible($proceedToCheckoutMaxiDressButton);
    }

    public String getCartIsEmptyText() {
        String text = getElementText($cartIsEmptyText);
        log.info("Well done my boy! 'Cart is empty!' text acquisition success!!");
        return text;
    }
    public String getAddressDetailsText() {
        String text = getElementText($addressDetailsText);
        log.info("Well done my boy! 'Address Details' text acquisition success!!");
        return text;
    }
    public void scrollToViewSubscriptionText(WebDriver driver){
        scrollToView(driver,$subscriptionText);
        log.info("Well done my guy! View 'Subscription Text' success!!");
    }
    public void clickOnAdButton2(WebDriver driver) {
        clickWithActions(driver, $adButton);
        log.info("Well done my guy! Click click on 'Ad button' success!!");
    }
}
