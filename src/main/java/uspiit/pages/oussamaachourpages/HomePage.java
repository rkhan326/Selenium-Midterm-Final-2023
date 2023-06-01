package uspiit.pages.oussamaachourpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uspiit.base.CommonAPI;

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

    @FindBy(xpath = "//li[@id='menu-item-5474']/a" )
    WebElement accessoriesBaseMenuSubLink;

    @FindBy(css = "a[href = '?add-to-cart=2706']" )
    WebElement tabletAir3AddToCart;

    @FindBy(xpath = "//span[@class = 'cart-items-count count header-icon-counter' and text() = '0']" )
    WebElement cartCountEqualsZero;

    @FindBy(xpath = "//a[@class = 'dropdown-toggle']/span[1]" )
    WebElement cartCountEqualsOne;

    @FindBy(xpath = "//a[@class = 'dropdown-toggle']/span[2]" )
    WebElement cartCountEqualsTwo;

    @FindBy(css = "#search" )
    WebElement searchBar;

    @FindBy( css = "a[href = '?add-to-cart=2702']")
    WebElement camerasCameraC430WAddToCartButton;

    @FindBy(xpath = "//a[@href = '?add-to-cart=2702']/following-sibling::a" )
    WebElement cameraC430WViewCartButton;


    public void clickOnAddToCartForCameraC430WButton(){
        clickOn(camerasCameraC430WAddToCartButton);
        log.info("Click on click On Add To Cart For Camera C430W success");
    }

    public boolean checkPresenceOfCameraC430WViewCartButton(){
        boolean viewCartButtonIsDisplayed = isVisible(cameraC430WViewCartButton);
        log.info("view cart button is successfully displayed.");
        return viewCartButtonIsDisplayed;
    }



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

    public void scrollToCameraC430WAddToCartButton(WebDriver driver){
        scrollToElementwJS(camerasCameraC430WAddToCartButton, driver);
        waitFor(2);
        log.info("Scroll to Camera c430W link success");
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
        clickOn(accessoriesBaseMenuSubLink);
        log.info("hover Over Featured Brands And Click On It success");
    }

    public boolean checkPresenceOfCartCountEqualsOne(){
        boolean cartCountEqualsOneIsDisplayed = isVisible(cartCountEqualsOne);
        log.info("cart count equals one is displayed.");
        return cartCountEqualsOneIsDisplayed;
    }

    public boolean checkPresenceOfCartCountEqualsTwo(){
        boolean cartCountEqualsOTwoIsDisplayed = isVisible(cartCountEqualsTwo);
        log.info("cart count equals two is displayed.");
        return cartCountEqualsOTwoIsDisplayed;
    }

    public void hoverOverTrendingStylesAndClickOnIt(WebDriver driver){
        hoverOver(driver,trendingStylesBaseMenuLInk);
        waitFor(1);
        clickOn(gadgetsBaseMenuSubLink);
        log.info("hover Over Trending Styles And Click On It success");
    }

    public void searchForMacChargerUsingSearchBar(String charger){
        typeTextEnter(searchBar, charger);
        log.info("Successfully entered mac charger in search bar and hit enter");
    }

    public void clickOnCameraC430WViewCartButton(){
        clickOn(cameraC430WViewCartButton);
        log.info("Click on camera c430W button success");
    }




}
