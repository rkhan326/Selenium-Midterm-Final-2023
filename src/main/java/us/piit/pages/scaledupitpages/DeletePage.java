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

    @FindBy(css = ".woocommerce-products-header__title.page-title")
    WebElement shopPageHeader;

    @FindBy(xpath = "//h1[text()='Belt']")
    WebElement beltPageHeader;

    public boolean checkPresenceOfCartHeaderText() {
        boolean carPageHeaderIsDisplayed = isVisible(cartHeader);
        log.info("cart page header presence " + carPageHeaderIsDisplayed);
        return carPageHeaderIsDisplayed;
    }

    public String getCartPageHeaderText() {
        String text = getElementText(cartHeader);
        log.info("get cart page  header text success");
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
    public boolean checkBeltPageHeader() {
        boolean BeltPageHeaderIsDisplayed = isVisible(beltPageHeader);
        log.info("Belt page Header is  " + BeltPageHeaderIsDisplayed);
        return BeltPageHeaderIsDisplayed;
    }
    public String getBeltPageHeaderText() {
        String BeltPageHeaderText = getElementText(beltPageHeader);
        log.info("Belt page Header text is " + BeltPageHeaderText);
        return BeltPageHeaderText;
    }

        public void clickOnAddToCartButton() {
        clickOn(addToCartButton);
        log.info("click on add cart  success");

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
    public void clickOnX() {
        clickOn(Xbutton);
        log.info("click on  x button success");

    }
    public boolean checkPresenceOfCartEmptyHeaderText() {
        boolean cartEmptyHeaderIsDisplayed = isVisible(cartEmpty);
        log.info("cart Empty header presence " + cartEmptyHeaderIsDisplayed );
        return cartEmptyHeaderIsDisplayed ;
    }

    public String getCartEmptyPageHeaderText() {
        String text = getElementText(cartEmpty);
        log.info("get cart Empty header text success");
        return text;
    }
    public boolean checkShopPageHeader() {
        boolean ShopPageHeaderIsDisplayed = isVisible(shopPageHeader);
        log.info("shop page header  is  " + ShopPageHeaderIsDisplayed);
        return ShopPageHeaderIsDisplayed;
    }
    public String getShopPageHeaderText() {
        String ShopPageHeaderText= getElementText(shopPageHeader);
        log.info("Shop Page Header Text  is " + ShopPageHeaderText);
        return ShopPageHeaderText;

    }


}

