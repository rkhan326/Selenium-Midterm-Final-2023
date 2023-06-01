package uspiit.pages.oussamaachourpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uspiit.base.CommonAPI;

public class VendorDashboardPage extends CommonAPI {
    Logger log = LogManager.getLogger(VendorDashboardPage.class.getName()) ;
    public VendorDashboardPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@class='entry-title' and text()='Dashboard']")
    WebElement vendorDashboardHeader;

    public boolean checkPresenceOfVendorDashboardHeader(){
        boolean vendorDashboardHeaderIsDisplayed = isVisible(vendorDashboardHeader);
        log.info("vendor dashboard header is displayed.");
        return vendorDashboardHeaderIsDisplayed;
    }

    public String getVendorDashboardHeaderText(){
        String vendorDashboardHeaderText = getElementText(vendorDashboardHeader);
        log.info("vendor dashboard header text is acquired.");
        return vendorDashboardHeaderText;
    }
}
