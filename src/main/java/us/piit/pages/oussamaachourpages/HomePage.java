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

    public void clickOnMyAccountLink(){
        clickOn(myAccountLink);
        log.info("Click on My Account link success");
    }

    public void clickOnStoresListLink(){
        clickOn(storesListLink);
        log.info("Click on Stores List link success");
    }

}
