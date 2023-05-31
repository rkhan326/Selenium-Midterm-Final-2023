package us.piit.pages.oussamaachourpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class HomePage extends CommonAPI {

    Logger log = LogManager.getLogger(HomePage.class.getName());


    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title = 'My Account']" )
    WebElement myAccountLink;
    @FindBy(xpath = "//a[@title='Stores']" )
    WebElement storesListLink;

    @FindBy(css = "a[title ='Track Your Order']" )
    WebElement trackYorOrderLink;

    @FindBy(xpath = "//h2[text()='Camera C430W 4k with  Waterproof cover']" )
    WebElement cameraC430W;

    @FindBy(css = "a[title = 'Super Deals']" )
    WebElement superDealsBaseMenuLink;

    @FindBy(css = "a[title = 'Featured Brands']" )
    WebElement featuredBrandBaseMenuLink;

    @FindBy(css = "a[title = 'Trending Styles']" )
    WebElement trendingStylesBaseMenuLInk;

    @FindBy(css = "a[title = 'Smart Phones & Tablets']" )
    WebElement smartPhonesAndTabletsBaseMenuSubLink;

    @FindBy(css = "a[title = 'Gadgets']" )
    WebElement gadgetsBaseMenuSubLink;

    @FindBy(css = "a[title = 'Accessories']" )
    WebElement accessoriesBaseMenuSubLink;

    @FindBy(css = "a[href = '?add-to-cart=2706']" )
    WebElement tabletAir3AddToCart;

    @FindBy(xpath = "//span[@class = 'cart-items-count count header-icon-counter' and text() = '0']" )
    WebElement cartCountEqualsZero;

    @FindBy(xpath = "//a[@class = 'dropdown-toggle']/span[1]" )
    WebElement cartCountEqualsOne;







    public void clickOnMyAccountLink(){
        clickOn(myAccountLink);
        log.info("Click on My Account link success");
    }

    public void clickOnStoresListLink(){
        clickOn(storesListLink);
        log.info("Click on Stores List link success");
    }
    public void clickOnTrackYourOrderLink(){
        clickOn(trackYorOrderLink);
        log.info("Click on Track Your Order link success");
    }
    public void clickOnCameraC430WLink(WebDriver driver){
        scrollToElementwJS(cameraC430W, driver);
        waitFor(2);
        clickOn(cameraC430W);
        log.info("Click on Camera c430W link success");
    }
    public void hoverOverSuperDealsAndClickOnIt(WebDriver driver){
        hoverOver(driver, superDealsBaseMenuLink);
        waitFor(1);
        clickOn(smartPhonesAndTabletsBaseMenuSubLink);
        log.info("hover Over Super Deals And Click On It success");
    }

    public void hoverOverFeaturedBrandsAndClickOnIt(WebDriver driver){
        hoverOver(driver, featuredBrandBaseMenuLink);
        waitFor(1);
       // clickOn(accessoriesBaseMenuSubLink);
        log.info("hover Over Featured Brands And Click On It success");
    }
    public void clickOnAddToCartForTabletAir3(){
        clickOn(tabletAir3AddToCart);
        log.info("Click on click On Add To Cart For Tablet Air 3 link success");
    }

}
