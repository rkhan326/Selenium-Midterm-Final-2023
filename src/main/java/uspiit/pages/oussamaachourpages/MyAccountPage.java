package uspiit.pages.oussamaachourpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uspiit.base.CommonAPI;

public class MyAccountPage extends CommonAPI {
    Logger log = LogManager.getLogger(MyAccountPage.class.getName());

    public MyAccountPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h1[@class='entry-title']")
    WebElement myAccountHeader;

    @FindBy(css= "li[class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--customer-logout'] a")
    WebElement logOutBtnOnMenu;
    @FindBy(xpath = "//div[@class='woocommerce-notices-wrapper']/following-sibling::p[1]/a[1]")
    WebElement logOutBtnOnBody;

    public boolean checkPresenceOfMyAccountHeader(){
        boolean myAccountPageHeaderisDisplayed = isVisible(myAccountHeader);
        log.info("My Account page header is displayed");
        return myAccountPageHeaderisDisplayed;
    }

    public String getMyAccountHeaderText(){
        String myAccountActualHeaderText = getElementText(myAccountHeader);
        log.info("user login page validation text match success");
        return myAccountActualHeaderText;
    }

    public void clickOnLogOutBtnOnMenu(){
        clickOn(logOutBtnOnMenu);
        log.info("click on log out button on menu success");
    }
    public void clickOnLogOutBtnOnBody(){
        clickOn(logOutBtnOnBody);
        log.info("click on log out button on body success");
    }
}
