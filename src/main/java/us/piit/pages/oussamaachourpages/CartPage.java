package us.piit.pages.oussamaachourpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class CartPage extends CommonAPI {
    Logger log = LogManager.getLogger(CartPage.class.getName());

    public CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".entry-title")
    WebElement cartPageHeader;

    @FindBy(xpath = "input[title='Qty']")
    WebElement quantityUpdateArrowUpButton;

    @FindBy(css = "#coupon_code")
    WebElement couponCodeField;

    @FindBy(css = "button[value='Apply coupon']")
    WebElement applyCouponButton;

    @FindBy(css = "input[title='Qty']")
    WebElement productQuantityField;

    @FindBy(css = "button[value='Update cart']")
    WebElement updateCartButton;

    @FindBy(css = "div[role='alert']")
    WebElement couponAppliedSuccessfullyText;

    public boolean checkPresenceOfCartPageHeader(){
        boolean cartPageHeaderIsDisplayed = isVisible(cartPageHeader);
        log.info("cart page header is displayed.");
        return cartPageHeaderIsDisplayed;
    }

    public void hoverOverQuantityUpdateCartUpArrowAndClickOnIt(WebDriver driver){
        hoverOver(driver, quantityUpdateArrowUpButton);
        waitFor(1);
        clickOn(quantityUpdateArrowUpButton);
        log.info("hover Over quantity Update Arrow Up Button And Click On It success");
    }

    public void enterProductQuantity(WebDriver driver) {
        scrollToElementwJS(productQuantityField,driver);
        waitFor(1);
        clear(productQuantityField);
        typeText(productQuantityField,"2");
        log.info("Successfully updates the quantity of the product.");
    }


    public void clickOnUpdateCartButton(){
        clickOn(updateCartButton);
        log.info("Update Cart Button Click success");
    }

    public void enterCouponCode(String couponCode,WebDriver driver) {
        scrollToElementwJS(couponCodeField,driver);
        waitFor(1);
        clear(couponCodeField);
        typeText(couponCodeField,couponCode);

    }
    public void clickOnApplyCouponButton(){
        clickOn(applyCouponButton);
        log.info("Successfully entered a coupon code");
        waitFor(2);
    }

    public String getCouponAppliedSuccessfullyText() {
        String text = getElementText(couponAppliedSuccessfullyText);
        return text;
    }
}
