package us.piit.pages.oussamaachourpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class VendorStoreListPage extends CommonAPI {
    Logger log = LogManager.getLogger(VendorStoreListPage.class.getName()) ;
    public VendorStoreListPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='store-data']/h2[1]/a[1]")
    WebElement storeListNewRegisteredShopName;

    public String getStoreListNewRegisteredShopNameText(){
        String storeListNewRegisteredShopNameText = getElementText(storeListNewRegisteredShopName);
        log.info("storelist new registered shopName text retrieval success");
        return storeListNewRegisteredShopNameText;
    }
}
