package lumatest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import uspiit.base.CommonAPI;
import uspiit.pages.lumapages.*;

public class  ProductTest extends CommonAPI {

    Logger LOG = LogManager.getLogger(SearchfieldTest.class.getName());

    @Test
    public void displayingtheProducts() throws InterruptedException {
        HomePageMagento homePage = new HomePageMagento(getDriver());
        SigninPageMagento signinPageMagento = new SigninPageMagento(getDriver());
        PantsPage pantsPage = new PantsPage(getDriver());
        homePage.clickOnShopPantsToday();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Pants");
        LOG.info("Pants title page validation success");
        pantsPage.clickOnStyleButton();
        Thread.sleep(4000);
        //pantsPage.clickOnBaseLayerButton();
        pantsPage.clickOnClimatBbutton();
        //pantsPage.clickOnColdButton();

    }

    @Test
    public void SortingtheProducts() throws InterruptedException {
        HomePageMagento homePage = new HomePageMagento(getDriver());
        SigninPageMagento signinPageMagento = new SigninPageMagento(getDriver());
        WomenProductsPage womenPage = new WomenProductsPage(getDriver());
        JacketsPage jacketsPage = new JacketsPage(getDriver());
        homePage.clickOnWommenProducts();
        String title1 = getCurrentTitle();
        Assert.assertEquals(title1, "Women");
        LOG.info("Women title page validation success");
        womenPage.clickOnJackets();
        String title2 = getCurrentTitle();
        Assert.assertEquals(title2, "Jackets - Tops - Women");
        LOG.info("Jackets title page validation success");
        jacketsPage.clicKOnList();
        jacketsPage.clicKOnGrid();
        jacketsPage.clickOnSigninButton();
        //String expectedTitle = read.getCellValueForGivenHeaderAndKey("key", "login page title");
        String actualTitle = getCurrentTitle();
        String expectedTitle = "Customer Login";
        Assert.assertEquals(expectedTitle, actualTitle);
        //String email = ConnectDB.getTableColumnData("select * from cred", "email").get(0);
        signinPageMagento.typeEmailAddress("gsbappy2@gmail.com");
        //String password = ConnectDB.getTableColumnData("select * from cred", "password").get(0);
        signinPageMagento.typePassword("password$1234");
        signinPageMagento.clickOnSigninButton2();
        LOG.info("Signin success");
        jacketsPage.clickOnDropDown();
        jacketsPage.clickOnSignOut();
    }

    @Test
    public void selectWomensTopColor() throws InterruptedException {
        BasePage base = new BasePage(getDriver());


        String testPageTitle = getCurrentTitle();
        Assert.assertEquals(testPageTitle,getCurrentTitle());
        LOG.info("basic automation a success");

        base.clickOnWomen();
        Thread.sleep(2000);
        String womenPage = getCurrentTitle();
        Assert.assertEquals(womenPage,"Women" );

        base.clickOnWomenTops(getDriver());
        String womenTopsPage = getCurrentTitle();
        Assert.assertEquals(womenTopsPage,"Tops - Women");


    }
    @Test
    public void selectSortByPrice() throws InterruptedException {
        BasePage base = new BasePage(getDriver());
        WatchesPage watchesPage = new WatchesPage(getDriver());

        base.clickOnWatches(getDriver());

        watchesPage.sortByPrice();

        Thread.sleep(3000);

        double firstItemPrice = Double.parseDouble(watchesPage.getTextFromFirstItem(getDriver()));
        LOG.info(firstItemPrice+" is the price of the first item");

        double lastItemPrice = Double.parseDouble(watchesPage.getTextFromLastItem(getDriver()));
        boolean ascendingOrder = firstItemPrice<lastItemPrice;

        Assert.assertEquals(ascendingOrder,true);
        LOG.info("Sort by price successful.");


    }

}

