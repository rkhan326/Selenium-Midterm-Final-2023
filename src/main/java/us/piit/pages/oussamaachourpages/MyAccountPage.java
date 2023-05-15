package us.piit.pages.oussamaachourpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class MyAccountPage extends CommonAPI {
    Logger log = LogManager.getLogger(MyAccountPage.class.getName());

    public MyAccountPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h1[@class='entry-title']")
    WebElement myAccountHeader;

    public boolean checkPresenceOfMyAccountHeader(){
        boolean myAccountPageHeadedisDisplayed = isVisible(myAccountHeader);
        log.info("My Account page header is displayed");
        return myAccountPageHeadedisDisplayed;
    }

    public String getMyAccountHeaderText(){
        String myAccountActualHeaderText = getElementText(myAccountHeader);
        log.info("user login page validation text match success");
        return myAccountActualHeaderText;
    }
}
