package us.piit.pages.scaledupitpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
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

   @FindBy(xpath="//div[@class='quantity']/input[1]")
   WebElement changeItemNumber;

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
    public boolean checkcartCount() {
        boolean cartCountIsDisplayed = isVisible(cartCount);
        log.info("cart count is  " + cartCountIsDisplayed);
        return cartCountIsDisplayed;
    }
    public String getCartCountText() {
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
        log.info("click on add cart  success");

    }
    public void hoverOverOnQuantitField(  WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveToElement(itemNumberField).build().perform();
        log.info("hover over on categories success");
    }

}



