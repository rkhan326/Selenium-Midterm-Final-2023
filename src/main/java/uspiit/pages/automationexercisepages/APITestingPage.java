package uspiit.pages.automationexercisepages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uspiit.base.CommonAPI;

public class APITestingPage extends CommonAPI {

    Logger log = LogManager.getLogger(APITestingPage.class.getName());
    public APITestingPage(WebDriver driver) {PageFactory.initElements(driver, this);}

    @FindBy(xpath = "//b[text()='APIs List for practice']")
    WebElement $APITestingPageHeader;
    @FindBy(xpath = "//u[text()='API 14: GET user account detail by email']")
    WebElement $API14Text;
    @FindBy(xpath = "//h2[text()='Subscription']")
    WebElement $subscribtionText;

    public String getAPITestingPageHeaderText() {
        String text = getElementText($APITestingPageHeader);
        log.info("Ya did it! API Testing page header text acquisition success!!");
        return text;
    }
    public void clickOnAPILink() {
        clickOn($API14Text);
        log.info("Well done my guy! Click click on 'Download Invoice link' success!!");
    }
    public void scrollToViewAPI14Link(WebDriver driver){
        scrollToView(driver,$subscribtionText);
        log.info("Well done my guy! View 'API 14 Link' success!!");
    }



}
