package uspiit.pages.scaledupitpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uspiit.base.CommonAPI;

public class CouponsPage extends CommonAPI {
    Logger log = LogManager.getLogger(CouponsPage.class.getName());

    public CouponsPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath= "//h2[text()='Pizza']")
    WebElement pizza;

    @FindBy(xpath = "//h1[text()='Food & Beverage']")
    WebElement foodAndBeveragePageHeader;

    @FindBy(xpath = "//h1[text()='Pizza']")
    WebElement pizzaPageHeader;


    @FindBy(css = ".single_add_to_cart_button.button.alt.wp-element-button")
    WebElement addToCart;

    @FindBy(xpath = "//span[@class='cart-value cart-customlocation' and text()=1]")
    WebElement cartCount;

    @FindBy(css = "#coupon_code")
    WebElement couponsField;

    @FindBy(css=".button.wp-element-button")
    WebElement applyCouponsBtn;

    @FindBy(css = ".woocommerce-error")
    WebElement couponsErrorMessage;

    @FindBy(xpath = " //ul[@class='woocommerce-error']/li[1]")
    WebElement missingCouponsError;


    public void clickOnPizzaButton() {
        clickOn(pizza);
        log.info("click on  pizza  success");

    }
    public void clickOnAddToCartButton() {
        clickOn(addToCart);
        log.info("click on add to cart success");

    }
    public boolean checkCartCount() {
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
        clickOn(applyCouponsBtn);
        log.info("click on apply coupons  success");
    }
    public boolean checkErrorMessageHeader() {
        boolean errorMessageHeaderIsDisplayed = isVisible(couponsErrorMessage);
        log.info("cart count is  " + errorMessageHeaderIsDisplayed);
        return errorMessageHeaderIsDisplayed;
    }
    public String getErrorMessageHeaderText() {
        String text = getElementText(couponsErrorMessage);
        log.info("get coupons error message text success");
        return text;
    }
    public boolean checkFoodAndBeveragePageHeader() {
        boolean foodAndBeveragePageHeaderIsDisplayed = isVisible(foodAndBeveragePageHeader);
        log.info("Food and Beverage page header  is  " + foodAndBeveragePageHeaderIsDisplayed);
        return foodAndBeveragePageHeaderIsDisplayed;
    }
    public String getFoodAndBeveragePageHeaderText() {
        String text = getElementText(foodAndBeveragePageHeader);
        log.info("Food and Beverage Header text success");
        return text;
    }
    public boolean checkPizzaPageHeader() {
        boolean pizzaPageHeaderIsDisplayed = isVisible(pizzaPageHeader);
        log.info("Pizza page header  is  " + pizzaPageHeaderIsDisplayed);
        return pizzaPageHeaderIsDisplayed;
    }
    public String getPizzaPageHeaderText() {
        String text = getElementText(pizzaPageHeader);
        log.info("Pizza Header text success");
        return text;
    }
    public boolean checkNoCouponsErrorMessageHeader() {
        boolean errorMessageHeaderIsDisplayed = isVisible(missingCouponsError);
        log.info("cart count is  " + errorMessageHeaderIsDisplayed);
        return errorMessageHeaderIsDisplayed;
    }
    public String getNoCouponsErrorMessageHeaderText() {
        String text = getElementText(missingCouponsError);
        log.info("get no coupons error message text success");
        return text;
    }
}


