package uspiit.pages.oussamaachourpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uspiit.base.CommonAPI;

public class VendorWelcomePage extends CommonAPI {
    Logger log = LogManager.getLogger(VendorWelcomePage.class.getName()) ;
    public VendorWelcomePage(WebDriver driver){PageFactory.initElements(driver, this);}

    @FindBy(xpath = "//h1[@id='wc-logo']")
    WebElement vendorWelcomeHeader;

    @FindBy(xpath = "//a[text()=\"Let's Go!\"]")
    WebElement vendorLetsGoBtn;

    @FindBy(xpath = "//a[text()='Not right now']")
    WebElement vendorNotRightNowBtn;

    public boolean checkPresenceOfVendorWelcomeHeader(){
        boolean vendorWelcomeHeaderIsDisplayed = isVisible(vendorWelcomeHeader);
        log.info("registration error message validation success.");
        return vendorWelcomeHeaderIsDisplayed;
    }

    public String getVendorWelcomeHeaderText(){
        String actualVendorWelcomeHeaderText = getElementText(vendorWelcomeHeader);
        log.info("user login page validation text match success");
        return actualVendorWelcomeHeaderText;
    }

    public void clickOnVendorLetsGoBtn(){
        clickOn(vendorLetsGoBtn);
        log.info("click on vendor lets go button success.");
    }

    public void clickOnVendorNotRightNowBtn(){
        clickOn(vendorNotRightNowBtn);
        log.info("click on vendor Not Right Now button success.");
    }


}
