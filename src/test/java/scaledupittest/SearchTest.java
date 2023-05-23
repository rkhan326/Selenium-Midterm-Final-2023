package scaledupittest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.scaledupitpages.HomePage;
import us.piit.pages.scaledupitpages.LoginPage;
import us.piit.pages.scaledupitpages.SearchPage;
import us.piit.utility.ExcelReader;
import us.piit.utility.Utility;

import java.util.List;
import java.util.Properties;

public class SearchTest extends CommonAPI {
    Logger log = LogManager.getLogger(SearchTest.class.getName()); // when you creating the log object you have to use the class where you are

    Properties prop = Utility.loadProperties();



    @Test(enabled = false)
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
        String actualSearchageHeader = searchpage.getSearchPageTitle();
        Assert.assertEquals(expectedSearchPageHeader, actualSearchageHeader);
        log.info("converse  page header text validate ");
        waitFor(3);

    }
    @Test(enabled = false)
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

        // get error message
        String expectedErrorMessage = "Sorry, but nothing matched your search terms. Please try again with some different keywords.";
        String actualErrorMessage = searchpage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        log.info("error message  text validate ");
        waitFor(3);

    }
    @Test
    public void searchMultipleItems() {

        ExcelReader excelReader = new ExcelReader(Utility.currentDir + "/Datas/TestData.xlsx");
        List<String> items = excelReader.getEntireColumnForGivenHeader("Sheet1", "item");
        HomePage homePage = new HomePage(getDriver());
        for (String item : items) {
            homePage.typeItemToSearch(item);
            waitFor(3);
            homePage.clearSearchField();


        }
    }}

