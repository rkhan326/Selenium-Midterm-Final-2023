package us.piit.pages.scaledupitpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class CouponsPage extends CommonAPI {
    Logger log = LogManager.getLogger(CouponsPage.class.getName());

    public CouponsPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath= "//h2[text()='Pizza']")
    WebElement pizza;

    @FindBy(css = ".single_add_to_cart_button.button.alt.wp-element-button")
    WebElement addToCart;

    @FindBy(xpath = "//span[@class='cart-value cart-customlocation' and text()=1]")
    WebElement cartCount;

    @FindBy(css = "#coupon_code")
    WebElement couponsField;

    @FindBy(css=".button.wp-element-button")
    WebElement applyCoupons;

    @FindBy(css = ".woocommerce-error")
    WebElement errorMessage;


    public void clickOnPizzaButton() {
        clickOn(pizza);
        log.info("click on  pizza  success");

    }
    public void clickOnAddToCartButton() {
        clickOn(addToCart);
        log.info("click on add to cart success");

    }
    public boolean checkcartCount() {
        boolean cartCountIsDisplayed = isVisible(cartCount);
        log.info("cart count is  " + cartCountIsDisplayed);
        return cartCountIsDisplayed;
    }
    public String getCartCountText() {
        String cartCountText = getElementText(cartCount);
        log.info("cart count text is " + cartCountText);
        return cartCountText;

    }
    public void clickOnCart() {
        clickOn(cartCount);
        log.info("click on  cart and 1 item added  success");

    }
    public void enterCoupons(String coupons) {
        typeText(couponsField, coupons);

        log.info("enter coupons success");
    }
    public void clickOnApplyCoupons() {
        clickOn(applyCoupons);
        log.info("click on apply coupons  success");
    }
    public String getErrorMessage() {
        String text = getElementText(errorMessage);
        log.info("get error message text success");
        return text;
    }
}


