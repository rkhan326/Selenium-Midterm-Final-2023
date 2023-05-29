package lumatest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.lumapages.*;

public class SearchfieldTest extends CommonAPI {

    Logger LOG = LogManager.getLogger(SearchfieldTest.class.getName());

    //ReadFromExcel read = new ReadFromExcel("D:\\BootCamp Selenium\\web-automation-framework-team4\\data\\titles.xlsx", "Magento");

    @Test
    public void searchAnItemAndAddToCart() throws InterruptedException {
        HomePageMagento homePage = new HomePageMagento(getDriver());
        String expectedTitle= "Home Page";
        //String expectedTitle = read.getCellValueForGivenHeaderAndKey("key","home page title");
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        LOG.info("Sign in title page validation success");
        String item = "Bag";
        homePage.typeItemToSearch(item);
        homePage.clickOnSearchButton();

        //String expectedTitle1 = read.getCellValueForGivenHeaderAndKey("key","Bag search title");
        String expectedTitle1 = "Search results for: 'Bag'";
        String actualTitle1 = getCurrentTitle();
        Assert.assertEquals(expectedTitle1, actualTitle1);

        LOG.info("search bag title page validation success");
        SearchPageMagento searchPage = new SearchPageMagento(getDriver());
        searchPage.clickOnWayfarerMessengerBag();
        WayfarerMessengerBagPageMagento wayfarerMessengerBagPageMagento=new WayfarerMessengerBagPageMagento(getDriver());
        wayfarerMessengerBagPageMagento.clickOnAddToCartButton();

    }
    @Test
    public void searchAnItemAndAddToWishList() throws InterruptedException {
        HomePageMagento homePage = new HomePageMagento(getDriver());
        SigninPageMagento signinPageMagento = new SigninPageMagento(getDriver());
        homePage.clickOnSigninButton1();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Customer Login");
        LOG.info("Sign in title page validation success");

        //String email = ConnectDB.getTableColumnData("select * from cred","email").get(0);
        signinPageMagento.typeEmailAddress("gsbappy1@gmail.com");
        //String password = ConnectDB.getTableColumnData("select * from cred","password").get(0);
        signinPageMagento.typePassword("password&1234");
        signinPageMagento.clickOnSigninButton2();
        LOG.info("Signin success");
        String title1 = getCurrentTitle();
        Assert.assertEquals(title1, "Home Page");
        LOG.info("Sign in title page validation success");

        String item = "jacket";
        homePage.typeItemToSearch(item);
        homePage.clickOnSearchButton();

        //String expectedTitle1 = read.getCellValueForGivenHeaderAndKey("key","jacket search title");
        String expectedTitle1 = "Search results for: 'jacket'";

        String actualTitle1 = getCurrentTitle();
        Assert.assertEquals(expectedTitle1, actualTitle1);

        LOG.info("search jacket title page validation success");

        SearchPageMagento searchPage = new SearchPageMagento(getDriver());
        searchPage.hoverOverTyphonPerformanceFleecelinedJacket(getDriver());
        searchPage.clickOnAddToWishList();

    }
    @Test
    public void AdvancedSearch() throws InterruptedException {
        HomePageMagento homePage = new HomePageMagento(getDriver());
        AdvancedSearchPage advancedSearchPage=new AdvancedSearchPage(getDriver());

        homePage.clickOnAdvancedSearchButton();

        String title1= getCurrentTitle();
        Assert.assertEquals(title1, "Advanced Search");
        LOG.info("Advanced Search title page validation success");
        advancedSearchPage.typeProductName("pant");
        advancedSearchPage.typeSKU("pant");
        advancedSearchPage.typeDescription("large pant");
        advancedSearchPage.typeShortDescription("Black");
        advancedSearchPage.typePriceMinimum("20");
        advancedSearchPage.typePriceMaximum("70");
        advancedSearchPage.clickOnSearchButton();
        String errorMessage = advancedSearchPage.geterrorMessage();
        Assert.assertEquals(errorMessage, "We can't find any items matching these search criteria. Modify your search.");

    }



}
