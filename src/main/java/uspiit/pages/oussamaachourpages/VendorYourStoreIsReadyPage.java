package uspiit.pages.oussamaachourpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uspiit.base.CommonAPI;

public class VendorYourStoreIsReadyPage extends CommonAPI {
    Logger log = LogManager.getLogger(VendorYourStoreIsReadyPage.class.getName()) ;
    public VendorYourStoreIsReadyPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[class='button button-primary dokan-btn-theme']")
    WebElement goToYourDashboardBtn;

    @FindBy(css = "a[class='wc-return-to-dashboard']")
    WebElement returnToMarketplaceLink;

   public void clickOnGoToYourDashboardBtn(){
        clickOn(goToYourDashboardBtn);
   }

    public void clickOnReturnToMarketplaceLink(){
        clickOn(returnToMarketplaceLink);
    }

}
