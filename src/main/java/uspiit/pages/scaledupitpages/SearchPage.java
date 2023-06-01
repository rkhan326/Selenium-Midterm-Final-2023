package uspiit.pages.scaledupitpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uspiit.base.CommonAPI;

public class SearchPage extends CommonAPI {
    Logger log = LogManager.getLogger(SearchPage.class.getName());


    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//header[@class='page-header']/h1[1]")
    WebElement conversePageTitle;
    @FindBy(xpath = "//div[@class='page-content']/p[1]")
    WebElement errorMessage;

    public boolean checkPresenceOfConversePageHeader() {
        boolean conversePageHeaderIsDisplayed = isVisible(conversePageTitle);
        log.info("Converse page header presence " + conversePageHeaderIsDisplayed);
        return conversePageHeaderIsDisplayed;
    }
    public String getConversePageTitle() {
        String text = getElementText(conversePageTitle);
        log.info("converse page header text is " + conversePageTitle);
        return text;
    }
    public String getErrorMessageText() {
        String text = getElementText(errorMessage);
        log.info("get error message text success");
        return text;
    }
    public boolean checkPresenceOfErrorMessage() {
        boolean ErrorMessagePageHeaderIsDisplayed = isVisible(errorMessage);
        log.info(" Error Message  page header presence " + ErrorMessagePageHeaderIsDisplayed);
        return ErrorMessagePageHeaderIsDisplayed;
    }
}
