package us.piit.pages.scaledupitpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class DeletePage extends CommonAPI {
    Logger log = LogManager.getLogger(DeletePage.class.getName());

    public DeletePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".entry-title")
    WebElement cartHeader;

    @FindBy(css=".button.wc-backward.wp-element-button")
    WebElement returnToShopButton;

    @FindBy(xpath="//h2[text()='Belt']")
    WebElement beltButton;
    @FindBy(xpath = "//button[@name='add-to-cart']")
    WebElement addToCartButton;
    @FindBy(xpath = "//span[@class='cart-value cart-customlocation' and text()=1]")
    WebElement cartCount;
    @FindBy(xpath = "//td[@class='product-remove']/a[1]")
    WebElement Xbutton;

    @FindBy(css = ".cart-empty.woocommerce-info")
    WebElement cartEmpty;

    public boolean checkPresenceOfCartHeaderText() {
        boolean loginPageHeaderIsDisplayed = isVisible(cartHeader);
        log.info("cart page header presence " + loginPageHeaderIsDisplayed);
        return loginPageHeaderIsDisplayed;
    }

    public String getCartPageHeaderText() {
        String text = getElementText(cartHeader);
        log.info("get cart header page text success");
        return text;
    }
    public void clickOnReturnToShopBtn() {
        clickOn(returnToShopButton);
        log.info("click on return to shop  button success");

    }
    public void clickOnBeltBtn() {
        clickOn(beltButton);
        log.info("click on return to shop  button success");

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
    public void clickOnX() {
        clickOn(Xbutton);
        log.info("click on  x button success");

    }
    public boolean checkPresenceOfCartEmptyHeaderText() {
        boolean loginPageHeaderIsDisplayed = isVisible(cartEmpty);
        log.info("cart page header presence " + loginPageHeaderIsDisplayed);
        return loginPageHeaderIsDisplayed;
    }

    public String getCartEmptyPageHeaderText() {
        String text = getElementText(cartEmpty);
        log.info("get cart header page text success");
        return text;
    }


}

