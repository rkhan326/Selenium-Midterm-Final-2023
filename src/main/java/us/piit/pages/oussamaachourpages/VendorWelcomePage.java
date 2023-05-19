package us.piit.pages.oussamaachourpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class VendorWelcomePage extends CommonAPI {
    Logger log = LogManager.getLogger(VendorWelcomePage.class.getName()) ;
    public VendorWelcomePage(WebDriver driver){PageFactory.initElements(driver, this);}

    @FindBy(xpath = "//h1[@id='wc-logo']")
    WebElement vendorWelcomeHeader;

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
}
