package scaledupittest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.scaledupitpages.HomePage;
import us.piit.pages.scaledupitpages.SearchPage;
import us.piit.utility.ExcelReader;
import us.piit.utility.Utility;

import java.util.List;
import java.util.Properties;

public class SearchTest extends CommonAPI {
    Logger log = LogManager.getLogger(SearchTest.class.getName());

    Properties prop = Utility.loadProperties();

    @Test(enabled = true, priority = 1)
    public void searchConverse() {
        SearchPage searchpage = new SearchPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // click on searchbar and type converse , and click on search button
        homePage.typeItemToSearch("converse");
        waitFor(3);

        homePage.clickOnSearchButton();
        waitFor(3);

        // user is landed to the converse page
        String expectedSearchPageHeader = "Search Results for: converse";
        String actualSearchageHeader = searchpage.getConversePageTitle();
        Assert.assertEquals(expectedSearchPageHeader, actualSearchageHeader);
        log.info("converse  page header text validate ");
        waitFor(3);

    }

    @Test(enabled = true, priority = 1)
    public void searchHondaCar() {
        SearchPage searchpage = new SearchPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // click on searchbar and type Honda car , and click on search button
        homePage.typeItemToSearch("Honda car");
        waitFor(3);

        homePage.clickOnSearchButton();
        waitFor(3);

        // chech user is getting an error message
        String expectedErrorMessage = "Sorry, but nothing matched your search terms. Please try again with some different keywords.";
        String actualErrorMessage = searchpage.getErrorMessageText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        log.info("error message  text validate ");
        waitFor(3);

    }

  //  @Test(enabled = true)
    public void selectConverseOptionFromDropdown() {
        HomePage homePage = new HomePage(getDriver());
        SearchPage searchpage = new SearchPage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // click on search field
        homePage.clickOnSearchField();

       // select converse from the dropmenu
   //     homePage.selectOptionFromDropdown("converse",getDriver());
        //homePage.selectOptionFromDropdown();
        // click on search button
//          homePage.clickOnSearchButton();
//        waitFor(5)
//        homepage.selectOptionFromMenuDropdownWithSelectOptions("Kindle Store");
//        waitFor(5);
//    }
//
//        // user is landed to the converse page
//        String expectedSearchPageHeader = "Search Results for: converse";
//        String actualSearchageHeader = searchpage.getConversePageTitle();
//        Assert.assertEquals(expectedSearchPageHeader, actualSearchageHeader);
//        log.info("converse  page header text validate ");
//        waitFor(3);
//
//    }
    }




    @Test(enabled = true, priority = 2)
    public void searchMultipleItems() {

        ExcelReader excelReader = new ExcelReader(Utility.currentDir + "/data/ScalledupitSearchTestdata.xlsx");
        List<String> items = excelReader.getEntireColumnForGivenHeader("Sheet1", "item");
        HomePage homePage = new HomePage(getDriver());
        for (String item : items) {
            homePage.typeItemToSearch(item);
            waitFor(3);
            homePage.clearSearchField();


        }

    }
}

