package us.piit.pages.nopcommercepages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class SearchPage extends CommonAPI {
    Logger log = LogManager.getLogger(SearchPage.class.getName());
    public SearchPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }
    //locators
    @FindBy(xpath = "//input[@id='small-searchterms']")
    WebElement findSearchBoxLocator;
    @FindBy(xpath = "//button[@class='button-1 search-box-button']")
    WebElement searchButtonLocator;
    //****Reusable methods****
    public void typeInSearchBox(String text){
        typeText(findSearchBoxLocator, text);
        log.info("type macbook in search box success");
    }
    public void clickOnSearchBtn(){
        clickOn(searchButtonLocator);
        log.info("click on search button Success");
    }
}
