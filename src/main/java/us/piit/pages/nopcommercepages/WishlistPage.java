package us.piit.pages.nopcommercepages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class WishlistPage extends CommonAPI {
    Logger log = LogManager.getLogger(WishlistPage.class.getName());

    public WishlistPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }
    //******************locators**********************

    @FindBy(xpath = "//ul[@class = 'top-menu notmobile']/li[1]/a[1]")
    WebElement computerMenuLocator;
    @FindBy(xpath = "//a[contains(text(),'Desktops ')]")
    WebElement desktopMenuLocator;
    @FindBy(xpath = "//h1[text()='Desktops']")
    WebElement desktopPageLocator;
    @FindBy(xpath = "//img[@alt='Picture of Build your own computer']")
    WebElement productLocator;

    @FindBy(xpath = "//select[@name='product_attribute_2']")
    WebElement selectRAMLocator;
    @FindBy(xpath = "//select[@name='product_attribute_2']/option[@value='3']")
    WebElement select2gbLocator;
    @FindBy(xpath = "//input[@name='product_attribute_3' and @value= '6']")
    WebElement RadioButtonLocator;

    @FindBy(css = "#add-to-wishlist-button-1")
    WebElement wishListButtonLocator;
    @FindBy(css = "//span[@class='close']")
    WebElement closeConfirmMessageLocator;


    @FindBy(xpath = "//span[@class='wishlist-label']")
    WebElement clickWishListMenuLocator;
    @FindBy(xpath = "//th[@class='product']")
    WebElement clickWishListPageLocator;


    //*************************Reusable Methods******************************


    public void hoverOverComputerMenu(WebDriver driver) {
        hoverOver(driver, computerMenuLocator);
        log.info("hoverOver Computer menu Success");
        waitFor(1);
    }

    public void hoverOverDesktopMenuAndClick(WebDriver driver) {
        hoverOverAndClick(driver, desktopMenuLocator);
        log.info("hoverOver Desktop menu and click Success");
    }

    public String checkDesktopsPageIsOpen() {
        String text = getElementText(desktopPageLocator);
        log.info("user desktop page open success");
        return text;
    }

    public void clickOnProduct() {
        clickOn(productLocator);
        log.info("click on Product Success");
    }

    public void selectRamMenu() {
        clickOn(selectRAMLocator);
        log.info("click on RAM menu Success");
    }

    public void selectRam2gbMenu() {
        clickOn(select2gbLocator);
        log.info("click on 2gb  Success");
    }

    public void clickOnRadioButton() {
        clickOn(RadioButtonLocator);
        log.info("click on HDD radio button Success");
    }

    public void clickOnWishlistButton() {
        clickOn(wishListButtonLocator);
        log.info("click on wishList Button Success");
        waitFor(1);
    }

    public void closeConfirmMessage() {
        clickOn(closeConfirmMessageLocator);
        log.info("click on close Button Success");
        waitFor(1);
    }

    public void clickWishListMenu() {
        clickOn(clickWishListMenuLocator);
        waitFor(2);
        log.info("click on wishList Button Success");

    }

    public String checkWishListPage() {
        String text = getElementText(clickWishListPageLocator);
        log.info("customer now wishlist page");
        return text;
    }
}
