package scaledupittest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.scaledupitpages.AddToCartPage;
import us.piit.pages.scaledupitpages.HomePage;
import us.piit.utility.Utility;

import java.util.Properties;

public class AddToCartTest extends CommonAPI {
    Logger log = LogManager.getLogger(AddToCartTest.class.getName());

    Properties prop = Utility.loadProperties();


    @Test (enabled = true,priority = 0)
    public void addToCartFromShop() {
        HomePage homePage = new HomePage(getDriver());
        AddToCartPage cart = new AddToCartPage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // click on shop button
        homePage.clickOnShopButton();
        log.info("click on shop button success");

        // check if user landed to the shop page
        Assert.assertTrue(cart.checkShopPageHeader());
        String expectedShopPageHeader = "Shop";
        String actualShopPageHeader = cart.getShopPageHeaderText();
        Assert.assertEquals(expectedShopPageHeader, actualShopPageHeader);
        log.info("shop header text validate  success");

        // click on bag collection
        cart.clickOnBagCollection();
        log.info("click on Bag collection  success");

        // check if user landed to the Bag collection page
        Assert.assertTrue(cart.checkBagCollectionPageHeader());
        String expectedBagCollectionPageHeader = "Bag Collection";
        String actualBagCollectionPageHeader = cart.getBagCollectionHeaderText();
        Assert.assertEquals(expectedBagCollectionPageHeader, actualBagCollectionPageHeader);
        log.info("Bag Collection header text validate  success");

        // click on add to cart
        cart.clickOnAddToCartButton();
        log.info("click on add to cart success");
        waitFor(3);


        // check 1 item has added to the cart
        String expectedCartCount = "1";
        String actualCartCount = cart.getCartCountText();
        Assert.assertEquals(expectedCartCount, actualCartCount);
        cart.clickOnCart();
        waitFor(3);
        log.info("1 item added to cart success");

    }

     @Test (enabled = true,priority = 1)
    public void addToCartFromCategories() {
        HomePage homePage = new HomePage(getDriver());
        AddToCartPage cart = new AddToCartPage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);

        // hover over on catefgories
        homePage.hoverOverOnCategoriesButton(getDriver());
        waitFor(3);

        // click on food and beverage
        homePage.hoverOverOnClothingButton(getDriver());
        waitFor(3);

        // click on hoddies
        homePage.clickOnHoddiesButton();
        waitFor(3);

        //check if user landed to the Hoddies page
        Assert.assertTrue(cart.checkHoddiesPageHeader());
        String expectedHoddiesPageHeader = "Hoodies";
        String actualHoddiesPageHeader = cart.getHoddiesPageHeaderText();
        Assert.assertEquals(expectedHoddiesPageHeader, actualHoddiesPageHeader);
        log.info("Hoddies Page header text validate  success");

        // click on  patient Ninja
        cart.clickOnPatientNinjaButton();
        waitFor(3);


        //check if user landed to the Patient Ninja  page
        Assert.assertTrue(cart.checkPatientNinjaPageHeader());
        String expectedPatientNinjaPageHeader = "Patient Ninja";
        String actualPatientNinjaPageHeader = cart.getPatientNinjaHeaderText();
        Assert.assertEquals(expectedPatientNinjaPageHeader, actualPatientNinjaPageHeader);
        log.info("Patient NinjaPage header text validate  success");

        //click on add to cart
        cart.clickOnAddToCartButton();
        waitFor(3);

        // check 1 item has added to the cart
        String expectedCartCount = "1";
        String actualCartCount = cart.getCartCountText();
        Assert.assertEquals(expectedCartCount, actualCartCount);
        cart.clickOnCart();
        waitFor(3);
        log.info("1 item added to cart success");
        //  takeScreenshot("add cart screenshot");

    }

    @Test(enabled = true, priority = 2)
    public void addToCartFromSearchBar() {
        AddToCartPage cart = new AddToCartPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user landed successfully to the website ");
        waitFor(3);


       // click on searchbar
        homePage.typeItemToSearch("Light shoes");
        waitFor(3);

       // click on search button
        homePage.clickOnSearchButton();

        // user is landed to the Light shoes page
       Assert.assertTrue(cart.checkPresenceOfShoesPageHeader());
        String expectedSearchPageHeader = "Search Results for: Light shoes";
        String actualSearchageHeader = cart.getShoesPageTitle();
        Assert.assertEquals(expectedSearchPageHeader, actualSearchageHeader);
        log.info("Light shoes page header text validate ");
        waitFor(3);

        // scroll to read more button
        scrollToElement(0,3000);
        waitFor(3);

        // check if read more button is  visible
        Assert.assertTrue(cart.checkReadMoreButtonIsVisible());
        waitFor(3);

        // click on read more button
        cart.clickOnReadMoreButton();
        waitFor(3);

        //click on add to cart
        cart.clickOnAddToCartButton();
        waitFor(3);

        // check 1 item has added to the cart
        String expectedCartCount = "1";
        String actualCartCount = cart.getCartCountText();
        Assert.assertEquals(expectedCartCount, actualCartCount);
        cart.clickOnCart();
        waitFor(3);
        log.info("1 item added to cart success");
    }
}


//    @Test(groups={"smoke","sanity"})
//    public void smokeSanityTest(){
//        System.out.println("this is group smoke+sanity");
//    }
//    @Test(groups={"smoke"})
//    public void smokeTest(){
//        System.out.println("this is group smoke");
//    }
//
//    @Test(groups={"sanity"})
//    public void sanityTest(){
//        System.out.println("this is group sanity");
//    }
//    @ Test(groups={"regression","sanity"})
//    public void sanityRegressionTest(){
//        System.out.println("this is group sanity + regression");
//    }
//    @Test(groups={"regression","smoke"})
//    public void regressionSmokeTest(){
//        System.out.println("this is group smoke + regression");
//    }
//    @Test(groups={"regression"})
//    public void regressionTest(){
//        System.out.println("this is group regression");
//    }
//}



