package lumatest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.lumapages.CompareWatchPage;
import us.piit.pages.lumapages.HomePageMagento;
import us.piit.pages.lumapages.SigninPageMagento;
import us.piit.pages.lumapages.WatchPageMagento;

public class CompareTest extends CommonAPI {

    Logger LOG = LogManager.getLogger(CompareTest.class.getName());

@Test
    public void CheckOutCompareList() throws InterruptedException {
        HomePageMagento homePage = new HomePageMagento(getDriver());
        WatchPageMagento watchPageMagento = new WatchPageMagento(getDriver());
        CompareWatchPage compareWatchPage = new CompareWatchPage(getDriver());
        SigninPageMagento signinPageMagento = new SigninPageMagento(getDriver());
        homePage.hoverOverGear(getDriver());
        homePage.clickOnWatches();
        watchPageMagento.hoverOverItem1(getDriver());
        watchPageMagento.clickOnAddToCompareBtn1();

        watchPageMagento.hoverOver(getDriver());
        watchPageMagento.clickOnAddToCompareBtn2();
        homePage.clickOnSigninButton1();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Customer Login");
        LOG.info("Sign in title page validation success");

       // String email = ConnectDB.getTableColumnData("select * from cred","email").get(0);
        signinPageMagento.typeEmailAddress("gsbappy@gmail.com");
        //String password = ConnectDB.getTableColumnData("select * from cred","password").get(0);
        signinPageMagento.typePassword("Aarshi2019@");
        signinPageMagento.clickOnSigninButton2();
        LOG.info("Signin success");

        homePage.ClickOnCompareProductsButton();
        String title3 = getCurrentTitle();
        Assert.assertEquals(title3, "Products Comparison List - Magento Commerce");
        LOG.info("Compare Products title page validation success");
        Thread.sleep(3000);
        compareWatchPage.clickOnRemoveProductButton();
        compareWatchPage.clickOnOkButton();
        compareWatchPage.clickOnAddToCartButton();
    }

    @Test
    public void searchAndCompareTwoItems() throws InterruptedException {
        HomePageMagento homePage = new HomePageMagento(getDriver());
        WatchPageMagento watchPageMagento = new WatchPageMagento(getDriver());
        CompareWatchPage compareWatchPage = new CompareWatchPage(getDriver());
        SigninPageMagento signinPageMagento = new SigninPageMagento(getDriver());
        homePage.clickOnSigninButton1();
        //String expectedTitle = read.getCellValueForGivenHeaderAndKey("key","login page title");
        String expectedTitle = "Customer Login";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //String email = ConnectDB.getTableColumnData("select * from cred","email").get(0);
        signinPageMagento.typeEmailAddress("gsbappy@gmail.com");
        //String password = ConnectDB.getTableColumnData("select * from cred","password").get(0);
        signinPageMagento.typePassword("Aarshi2019@");
        signinPageMagento.clickOnSigninButton2();
        //String expectedTitle1 = read.getCellValueForGivenHeaderAndKey("key","home page title");
        String expectedTitle1 = "Customer Login";
        String actualTitle1 = getCurrentTitle();
        Assert.assertEquals(expectedTitle1, actualTitle1);
        LOG.info("Signin success");

        homePage.searchItem("watch");
        //String expectedTitle2 = read.getCellValueForGivenHeaderAndKey("key","wath search title");
        String actualTitle2 = getCurrentTitle();
        String expectedTitle2="Search results for: 'watch'";
        Assert.assertEquals(expectedTitle2, actualTitle2);
        LOG.info("searchwatch title page validation success");
        watchPageMagento.hoverOverItem1(getDriver());
        watchPageMagento.clickOnAddToCompareButton1();

        String confirmation = watchPageMagento.getconfirmationMessage();
        Assert.assertEquals(confirmation, "You added product Dash Digital Watch to the comparison list.");
        watchPageMagento.hoverOverItem2(getDriver());
        watchPageMagento.clickOnAddToCompareButton2();

        String confirmation1 = watchPageMagento.getconfirmationMessage1();
        Assert.assertEquals(confirmation1, "You added product Aim Analog Watch to the comparison list.");
        watchPageMagento.clickOnCompareButton();
        //String expectedTitle3 = read.getCellValueForGivenHeaderAndKey("key","compare product page title");
       String expectedTitle3 = "Products Comparison List - Magento Commerce";
        String actualTitle3 = getCurrentTitle();
        Assert.assertEquals(expectedTitle3, actualTitle3);
        LOG.info("Compare Products title page validation success");
    }









}
