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
}
