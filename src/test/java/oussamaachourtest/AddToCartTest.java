package oussamaachourtest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.oussamaachourpages.HomePage;
import us.piit.pages.oussamaachourpages.LoginRegisterPage;
import us.piit.pages.oussamaachourpages.MyAccountPage;
import us.piit.pages.oussamaachourpages.SingleProductPage;

public class AddToCartTest extends CommonAPI {

    Logger log = LogManager.getLogger(AddToCartTest.class.getName());

    @Test (enabled = true)
    public void addToCartFromFeaturedBrandsBaseMenu() {
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        SingleProductPage singleProductPage = new SingleProductPage(getDriver());

        //Assert we are on the correct website
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //hover over and click on super deals button and click on it.
        homePage.hoverOverSuperDealsAndClickOnIt(getDriver());

        //assert that we are on the smart phones and tables page
        String smartPhonesAndTabletsExpectedTitle = "Smart Phones & Tablets – Welcome to Worldwide Electronics Store";
        String smartPhonesAndTabletsActualTitle = getCurrentTitle();
        Assert.assertEquals(smartPhonesAndTabletsExpectedTitle, smartPhonesAndTabletsActualTitle);

       //click on the first item and add it to cart
        singleProductPage.clickOnAddToCartForTabletAir3();

        //assert that we see the goto cart button which is only visible after item has been added to cart
        Assert.assertTrue(singleProductPage.checkPresenceOfTabledAir3GoToCartButton());
    }

//    homePage.hoverOverFeaturedBrandsAndClickOnIt(getDriver());
//
//    //String featuredBrandsExpectedTitle = "Smart Phones & Tablets – Welcome to Worldwide Electronics Store";
//    String featuredBrandsActualTitle = getCurrentTitle();
//        System.out.println(featuredBrandsActualTitle);

    //Assert.assertEquals(smartPhonesAndTabletsExpectedTitle, smartPhonesAndTabletsActualTitle);
    @Test (enabled = false)
    public void addToCartFromSearchBar(){
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());


        //Assert we are on the correct website
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

    }
    @Test (enabled = false)
    public void addToCartFromDepartments(){
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());


        //Assert we are on the correct website
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

    }
    @Test (enabled = false)
    public void addToCartFromFeaturedItems(){
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());


        //Assert we are on the correct website
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

    }
}
