package us.piit.pages.scaledupitpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class SearchPage extends CommonAPI {
    Logger log = LogManager.getLogger(SearchPage.class.getName());


    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//header[@class='page-header']/h1[1]")
    WebElement conversePageTitle;
    @FindBy(xpath = "//div[@class='page-content']/p[1]")
    WebElement errorMessage;


    public String getSearchPageTitle() {
        String text = getElementText(conversePageTitle);
        log.info("converse page header text is " + conversePageTitle);
        return text;
    }
    public String getErrorMessage() {
        String text = getElementText(errorMessage);
        log.info("get error message text success");
        return text;
    }
}
