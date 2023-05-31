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
    public void addToCartFromSuperDealsBaseMenu() {
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


        //assert that the cart count equals one.
        Assert.assertTrue(homePage.checkPresenceOfCartCountEqualsOne());

    }

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
        homePage.hoverOverFeaturedBrandsAndClickOnIt(getDriver());

        //assert that we are on the smart phones and tables page
        String featuredBrandsExpectedTitle = "Accessories – Welcome to Worldwide Electronics Store";
        String accessoriesActualTitle = getCurrentTitle();
        Assert.assertEquals(featuredBrandsExpectedTitle, accessoriesActualTitle);

        //click on the first item and add it to cart
        singleProductPage.clickOnAddToCartForMacCharger();

        //assert that we see the goto cart button which is only visible after item has been added to cart
        Assert.assertTrue(singleProductPage.checkPresenceOfMacChargerGoToCartButton());


        //assert that the cart count equals one.
        Assert.assertTrue(homePage.checkPresenceOfCartCountEqualsOne());
    }

    @Test (enabled = true)
    public void addToCartFromTrendingStylesBaseMenu() {
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        SingleProductPage singleProductPage = new SingleProductPage(getDriver());

        //Assert we are on the correct website
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //hover over and click on super deals button and click on it.
        homePage.hoverOverTrendingStylesAndClickOnIt(getDriver());

        //assert that we are on the smart phones and tables page
        String trendingStylesExpectedTitle = "Gadgets – Welcome to Worldwide Electronics Store";
        String trendingStylesActualTitle = getCurrentTitle();
        Assert.assertEquals(trendingStylesExpectedTitle, trendingStylesActualTitle);

        //click on the first item and add it to cart
        singleProductPage.clickOnAddToCartForGearVirtualReality();

        //assert that we see the goto cart button which is only visible after item has been added to cart
        Assert.assertTrue(singleProductPage.checkPresenceOfGearVirtualRealityToCartButton());


        //assert that the cart count equals one.
        Assert.assertTrue(homePage.checkPresenceOfCartCountEqualsOne());
    }

    @Test (enabled = true)
    public void addToCartFromSearchBarInAllCategories(){
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        SingleProductPage singleProductPage = new SingleProductPage(getDriver());

        //Assert we are on the correct website
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //search for mac charger in the search bar
        homePage.searchForMacChargerUsingSearchBar("mac charger");
        singleProductPage.scrollToMacChargerAddToCartButton(getDriver());

        //Assert that the mac charger add to cart button is vidible
        Assert.assertTrue(singleProductPage.checkPresenceOfMacChargerAddToCartButton());

        //click on mac charger add to cart button
        singleProductPage.clickOnAddToCartForMacCharger();

        //assert that we see the goto cart button which is only visible after item has been added to cart
        Assert.assertTrue(singleProductPage.checkPresenceOfMacChargerGoToCartButton());

        //assert that the cart count equals one.
        Assert.assertTrue(homePage.checkPresenceOfCartCountEqualsOne());


    }

    @Test (enabled = true)
    public void addToCartFromHomepageFeaturedItems(){
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        SingleProductPage singleProductPage = new SingleProductPage(getDriver());

        //Assert we are on the correct website
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);


        //scroll to and add the camera to cart from homepage
        homePage.scrollToCameraC430WAddToCartButton(getDriver());
        homePage.clickOnAddToCartForCameraC430WButton();

        //assert that we see the goto cart button which is only visible after item has been added to cart
        Assert.assertTrue(homePage.checkPresenceOfCameraC430WViewCartButton());

        //assert that the cart count equals one.
        Assert.assertTrue(homePage.checkPresenceOfCartCountEqualsOne());

    }
}
