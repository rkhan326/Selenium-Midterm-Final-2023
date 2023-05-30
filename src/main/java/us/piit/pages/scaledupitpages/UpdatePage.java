package us.piit.pages.scaledupitpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class UpdatePage extends CommonAPI {
    Logger log = LogManager.getLogger(UpdatePage.class.getName());


    public UpdatePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css= ".product_title.entry-title")
    WebElement KidsCollectionHeader;

    @FindBy(xpath = "//button[@name='add-to-cart']")
    WebElement addToCartButton;
    @FindBy(xpath = "//span[@class='cart-value cart-customlocation' and text()=1]")
    WebElement cartCount;

    @FindBy(css=".input-text.qty.text")
    WebElement itemNumberField;

   @FindBy(css=".input-text.qty.text")
   WebElement changeItemNumber;

    @FindBy(xpath="//button[text()='Update cart']")
    WebElement updateCartBtn;
    @FindBy(xpath = "//span[@class='cart-value cart-customlocation' and text()=2]")
    WebElement cartCountUpdateItem;

    @FindBy(xpath="//li[@id='menu-item-284']/a[1]")
    WebElement cartFromHomePage;

    @FindBy(xpath = "//span[@class='cart-value cart-customlocation' and text()=5]")
    WebElement cartCountUpdatePrice;

    @FindBy(xpath="//td[@class='product-subtotal']/span[1]")
    WebElement updatePrice;
    public boolean checkPresenceOfKidsCollectionPageHeader() {
        boolean kidsCollectionPageHeaderIsDisplayed = isVisible(KidsCollectionHeader);
        log.info("kids colletion page header presence " + kidsCollectionPageHeaderIsDisplayed);
        return kidsCollectionPageHeaderIsDisplayed;
    }

    public String getKidsCollectionPageHeadertext() {
        String kidsColletionPageHeaderText = getElementText(KidsCollectionHeader);
        log.info("kids Collection header text is " + kidsColletionPageHeaderText);
        return kidsColletionPageHeaderText;

    }
    public void clickOnAddToCartButton() {
        clickOn(addToCartButton);
        log.info("click on add cart  success");

    }
    public boolean checkcartCountHeader() {
        boolean cartCountHeaderIsDisplayed = isVisible(cartCount);
        log.info("cart count is  " + cartCountHeaderIsDisplayed );
        return cartCountHeaderIsDisplayed ;
    }
    public String getCartCountHeaderText() {
        String cartCountText = getElementText(cartCount);
        log.info("cart count text is " + cartCountText);
        return cartCountText;

    } public void clickOnCart() {
        clickOn(cartCount);
        log.info("click on  cart and 1 item added  success");

    }
    public void entreItemNumberBtn(String itemNumber) {
        typeText(changeItemNumber, itemNumber);

        log.info("enter coupons success");
    }
    public void clickOnChangeItemButton() {
        clickOn(changeItemNumber);
        log.info("click on up button success");

    }
    public void hoverOverOnQuantityField(  WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveToElement(itemNumberField).build().perform();
        log.info("hover over on categories success");
    }
    public void clickOnUpdateCartButton() {
        clickOn(updateCartBtn);
        log.info("click on update cart  success");

    }
    public boolean checkCartCountUpdateHeader() {
        boolean cartCountUpdateHeaderIsDisplayed = isVisible(cartCountUpdateItem);
        log.info("cart count is  " + cartCountUpdateHeaderIsDisplayed);
        return cartCountUpdateHeaderIsDisplayed;
    }
    public String getCartCountUpadteHeaderItemText() {
        String cartCountUpdateItemText = getElementText(cartCountUpdateItem);
        log.info("cart count text is " + cartCountUpdateItemText);
        return cartCountUpdateItemText;

    }
    public void clickOnCartButtonFromHomePage() {
        clickOn(cartFromHomePage);
        log.info("click on cart  success");

    }
    public boolean checkCartCountUpdatePriceHeader() {
        boolean cartCountUpdatePriceHeaderIsDisplayed = isVisible(cartCountUpdatePrice);
        log.info("cart count is  " + cartCountUpdatePriceHeaderIsDisplayed);
        return cartCountUpdatePriceHeaderIsDisplayed;
    }
    public String getCartCountUpadtePriceHeaderText() {
        String cartCountUpdatePriceText = getElementText(cartCountUpdatePrice);
        log.info("cart count text is " + cartCountUpdatePriceText);
        return cartCountUpdatePriceText;

    }
    public boolean checkPriceUpdate() {
        boolean PriceUpdateIsDisplayed = isVisible(updatePrice);
        log.info("Price update  is  " + PriceUpdateIsDisplayed);
        return PriceUpdateIsDisplayed;
    }
    public String getPriceUpdateText() {
        String PriceUpdateText = getElementText(updatePrice);
        log.info("cart count text is " + PriceUpdateText);
        return PriceUpdateText;

    }
}



