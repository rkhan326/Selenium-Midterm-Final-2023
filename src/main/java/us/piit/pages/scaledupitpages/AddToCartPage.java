package us.piit.pages.scaledupitpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class AddToCartPage extends CommonAPI {

    Logger log = LogManager.getLogger(AddToCartPage.class.getName());

    public AddToCartPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//h2[text()='Bag Collection']")
    WebElement bagCollectionButon;

    @FindBy(xpath = "//button[@name='add-to-cart']")
    WebElement addToCartButton;

    @FindBy(xpath = "//span[@class='cart-value cart-customlocation' and text()=1]")
    WebElement cartCount;

    @FindBy(xpath="//h2[text()='Patient Ninja']")
    WebElement PatientNinjaButton;

    @FindBy(css= ".product_title.entry-title")
    WebElement bagCollectionPageHeader;

    @FindBy(css = ".woocommerce-products-header__title.page-title")
    WebElement shopPageHeader;

    public void clickOnBagCollection() {
        clickOn(bagCollectionButon);
        log.info("click on bag collection success");

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
    public boolean checkBagCollectionPageHeader() {
        boolean BagCollectionHeaderIsDisplayed = isVisible(bagCollectionPageHeader);
        log.info("Bag Collection Header is  " + BagCollectionHeaderIsDisplayed );
        return BagCollectionHeaderIsDisplayed ;
    }
    public String getBagCollectionHeaderText() {
        String BagCollectionHeaderText = getElementText(bagCollectionPageHeader);
        log.info("Bag Collection Header Text is " + BagCollectionHeaderText);
        return BagCollectionHeaderText;

    }
    public void clickOnCart() {
        clickOn(cartCount);
        log.info("click on  cart and 1 item added  success");

    }
//    public boolean checkHoddiesPageHeader() {
//        boolean HoddiesPageHeaderIsDisplayed = isVisible(hoddiesPageHeader);
//        log.info(" Hoddies Page Header is  " +  HoddiesPageHeaderIsDisplayed);
//        return  HoddiesPageHeaderIsDisplayed;
//    }
//    public String getHoddiesPageHeaderText() {
//        String ShopPageHeaderText= getElementText(hoddiesPageHeader);
//        log.info("Shop Page Header Text  is " + ShopPageHeaderText);
//        return ShopPageHeaderText;
//
//    }
    public boolean checkPatientNinjaPageHeader() {
        boolean BagCollectionHeaderIsDisplayed = isVisible(bagCollectionPageHeader);
        log.info("Bag Collection Header is  " + BagCollectionHeaderIsDisplayed );
        return BagCollectionHeaderIsDisplayed ;
    }
    public String getPatientNinjaHeaderText() {
        String BagCollectionHeaderText = getElementText(bagCollectionPageHeader);
        log.info("Bag Collection Header Text is " + BagCollectionHeaderText);
        return BagCollectionHeaderText;

    }
    public void clickOnPatientNinjaButton() {
        clickOn(PatientNinjaButton);
        log.info("click on patient Ninja button  success");

    }

}


